package com.terry.jwt_android;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * *
 * name     RestAPI
 * Creater  Terry
 * time     2017/6/21
 * *
 **/

public interface RestAPI {

    @POST("login")
    @FormUrlEncoded
    Call<BaseModel<String>> login(@Field("name") String name,
                                  @Field("pwd") String pwd);

    @GET("user")
    Call<BaseModel<User>> getUser(@Header("jwt") String token);

}
