package resource;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.widget.ImageView;

import java.io.File;

public class Others {
    public static int user_id,restaurant_id, post_id;
    public static String username, userImage, phoneNumber, email, full_name;
    public static String openAfterLogin;
    public static String token, role;
    public static int cuisinePrice;
    public static int cuisine_id;
    public static int cuisineCategoryId;
    public static int restaurant_table;

    //    public String getRealPathFromUri(Uri uri, Context context) {
//        String[] projection = {MediaStore.Images.Media.DATA};
//        CursorLoader loader = new CursorLoader(context, uri, projection,null,null,null);
//        Cursor cursor = loader.loadInBackground();
//        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//        cursor.moveToFirst();
//        String result = cursor.getString(colIndex);
//        cursor.close();
//        return result;
//    }
//    public void previewImage(String imagepath, ImageView imgProfile) {
//        File imgFlie = new File(imagepath);
//        if(imgFlie.exists()){
//            Bitmap myBitmap = BitmapFactory.decodeFile(imgFlie.getAbsolutePath());
//            imgProfile.setImageBitmap(myBitmap);
//
//        }
//    }
    public void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
