package com.cjnet.tdd_sample.di.module;

import com.cjnet.tdd_sample.api.RxSchedulers;
import com.cjnet.tdd_sample.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class RxModule {
    @AppScope
    @Provides
    public RxSchedulers providesScheduler() {
        return RxSchedulers.DEFAULT;
    }
}
