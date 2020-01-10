package com.example.menu;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menu.bll.RegisterBLL;

import java.io.File;
import java.io.IOException;

import API.DarazAPI;
import model.response.ImageResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;

public class RegisterActivity extends AppCompatActivity {
    private EditText etFullName, etUserName, etEmail, etPassword, etConfirmPassword, etPhoneNumber;
    private AppCompatButton btnRegister;
    private ImageView ivProfile;
    private TextView link_login;
    private String profileImagepath, profileImageName;
    private int id =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //        remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // will hide the title bar
        this.getWindow()

                .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//enable full scren
        setContentView(R.layout.activity_register);


        etFullName = findViewById(R.id.etFullName);
        etUserName = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        ivProfile = findViewById(R.id.ivProfile);
        link_login = findViewById(R.id.link_login);
        btnRegister = findViewById(R.id.btnRegister);



        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseProfileImage();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (etConfirmPassword.getText().toString().equals(etPassword.getText().toString())) {
                        register();
                    } else {
                        etConfirmPassword.setError("Please enter same password");
                        etConfirmPassword.requestFocus();
                    }

            }
        });
        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void register() {
        SaveProfileImageOnly();

        String fullName = etFullName.getText().toString();
        final String userName = etUserName.getText().toString();
        String email = etEmail.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();
        String password = etPassword.getText().toString();

        final RegisterBLL rll = new RegisterBLL(fullName, userName, email, phoneNumber, password, profileImageName);
        com.example.menu.StrictMode.StrictMode.StrictMode();
        if (rll.register()){
            Toast.makeText(RegisterActivity.this, "Register Successfull", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(RegisterActivity.this, "Register Failed!!", Toast.LENGTH_LONG).show();
        }

    }



    private void browseProfileImage() {
        Intent intent = new Intent(Intent.ACTION_PICK); //to browse image
        intent.setType("image/*"); //user now can only select the image
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Please Select an image", Toast.LENGTH_LONG).show();
            }
        }
        Uri uri = data.getData();
        profileImagepath = getRealPathFromUri(uri);
        previewProfileImage(profileImagepath);
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(), uri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

    private void previewProfileImage(String imagePath) {
        File file = new File(imagePath);
        if (file.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            ivProfile.setImageBitmap(myBitmap);

        }
    }

    private void SaveProfileImageOnly() {
        File file = new File(profileImagepath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile", file.getName(), requestBody);

        DarazAPI darazAPI = Url.getInstance().create(DarazAPI.class);
        Call<ImageResponse> responseBodyCall = darazAPI.uploadImage(body);

        StrictMode();

        try {
            Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
            //After saving an image, retrieve the current name of the image
            profileImageName = imageResponseResponse.body().getFilename();

        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}



