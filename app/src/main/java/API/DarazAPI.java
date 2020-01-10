package API;


import java.util.List;

import model.Cuisine;
import model.MenuList;
import model.response.ImageResponse;
import model.response.Response;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface DarazAPI {


    @GET("api/restaurant/addCuisine")
    Call<Response> addCuisine(@Body Cuisine cuisine);

    @Multipart
    @POST("api/restaurant/upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);


    @GET("api/restaurant/{id}/restaurant-cuisine")
    Call<List<MenuList>> getRestaurantCuisine(@Path("id") int id);



}
