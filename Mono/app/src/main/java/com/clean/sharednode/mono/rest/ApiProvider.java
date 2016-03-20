package com.clean.sharednode.mono.rest;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by filipemendes on 29/12/15.
 */
public class ApiProvider {
    private static final String ENDPOINT = "http://jsonplaceholder.typicode.com";

    public static RestAdapter getApi(){
        OkHttpClient client = new OkHttpClient();

        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(client))
                .setEndpoint(ENDPOINT)
                .build();
    }
}
