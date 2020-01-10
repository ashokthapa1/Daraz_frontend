package com.example.menu.bll;

import android.content.Context;
import android.widget.Toast;

import com.example.menu.RegisterActivity;

import API.UserAPI;
import model.LoginSignupResponse;
import model.Users;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;

public class RegisterBLL {
    private String fullName, userName, email, phoneNumber, password, profileImageName;
    boolean isSuccess = false;

    public RegisterBLL(String fullName, String userName, String email, String phoneNumber, String password, String profileImageName) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.profileImageName = profileImageName;
    }

    public boolean register() {
        Users users = new Users(this.fullName, this.userName, this.email, this.phoneNumber, this.password, this.profileImageName);
        UserAPI userAPI = Url.getInstance().create(UserAPI.class);
        Call<LoginSignupResponse> registerCall = userAPI.addUser(users);
        try {
            Response<LoginSignupResponse> loginSignupResponseResponse = registerCall.execute();
            if (loginSignupResponseResponse.body().getSuccess()){
                isSuccess = true;
            }


        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
