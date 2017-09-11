package com.terry.jwt_android;

import retrofit2.Retrofit;

/**
 * *
 * name     Rest
 * Creater  Terry
 * time     2017/6/21
 * *
 **/

public class Rest {

    private static RestAPI restAPI;

    public static RestAPI getRestApi() {
        if (restAPI == null) {
            restAPI = new Retrofit.Builder()
                    .baseUrl("http://10.45.54.128:2017")
                    .build()
                    .create(RestAPI.class);
        }
        return restAPI;

    }

}
