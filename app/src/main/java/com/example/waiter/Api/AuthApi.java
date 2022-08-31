package com.example.waiter.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface AuthApi {

    @POST("sign_in")
    Call<User> signAnswer(@Body User user );

    @GET("menu")
    Call<MenuFull> getMenu(@Header("token") String token);

    @GET("area")
    Call<AreaList> getArea(@Header ("token") String token);

    @GET("object")
    Call<ObjectList> getObject(@Header ("token") String token);

}
