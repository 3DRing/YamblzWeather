package com.ringov.yamblzweather.data.networking;

import android.support.annotation.NonNull;

import com.ringov.yamblzweather.Config;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseInterceptor implements Interceptor {

    /**
     * Add api key to each HTTP request params
     */
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl newUrl = request.url().newBuilder()
                .addQueryParameter(Config.API.KEY_FIELD, Config.API.KEY)
                .build();
        Request newRequest = request.newBuilder().url(newUrl).build();
        return chain.proceed(newRequest);
    }
}
