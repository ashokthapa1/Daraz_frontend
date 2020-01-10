package com.example.menu.bll;

import android.content.SharedPreferences;

import API.UserAPI;
import model.LoginSignupResponse;
import model.Users;
import resource.Others;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;


public class LoginBLL {
    private String username;
    private String password;
    boolean isSuccess = false;
    public LoginBLL(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean checkUser()

    {

        Users users = new Users(this.username, this.password);
        UserAPI userAPI = Url.getInstance().create(UserAPI.class);
        Call<LoginSignupResponse> loginCall = userAPI.auth(users);

        try {
            Response<LoginSignupResponse> loginSignupResponseResponse = loginCall.execute();
            if (loginSignupResponseResponse.body().getSuccess()) {
                Others.user_id = loginSignupResponseResponse.body().getUser_id();
                Others.full_name = loginSignupResponseResponse.body().getFull_name();
                Others.email = loginSignupResponseResponse.body().getEmail();
                Others.username = loginSignupResponseResponse.body().getUsername();
                Others.userImage = loginSignupResponseResponse.body().getUserImage();
                Others.phoneNumber = loginSignupResponseResponse.body().getPhoneNumber();
                Others.token = loginSignupResponseResponse.body().getToken();
                Others.role = loginSignupResponseResponse.body().getRole();

                isSuccess = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
}