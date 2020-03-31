package com.cjnet.tdd_sample.di.module;

import com.cjnet.tdd_sample.api.ApiConstant;
import com.cjnet.tdd_sample.api.ApiEndPoint;
import com.cjnet.tdd_sample.di.scope.AppScope;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @AppScope
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(ApiConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @AppScope
    @Provides
    ApiEndPoint providePostsApi(Retrofit retrofit) {
        return retrofit.create(ApiEndPoint.class);
    }
}