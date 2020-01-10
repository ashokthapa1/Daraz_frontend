package API;

import java.util.List;

import model.LoginSignupResponse;
import model.Users;
import model.response.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserAPI {

    @POST("api/account/register")
    Call<LoginSignupResponse> addUser(@Body Users users);

    @POST("api/account/login")
    Call<LoginSignupResponse> auth(@Body Users users);

}
