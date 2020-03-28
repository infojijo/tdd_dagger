package com.cjnet.tdd_sample.di.module;

import com.cjnet.tdd_sample.api.ApiEndPoint;
import com.cjnet.tdd_sample.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @AppScope
    @Provides
    static ApiEndPoint provideAuthApi(Retrofit retrofit) {

        return retrofit.create(ApiEndPoint.class);
    }
}