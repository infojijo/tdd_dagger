package com.cjnet.tdd_sample.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module
abstract public class ApplicationModule {

    @Binds
    abstract Context provideContext(Application application);

}
