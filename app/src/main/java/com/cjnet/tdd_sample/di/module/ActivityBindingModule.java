package com.cjnet.tdd_sample.di.module;

import com.cjnet.tdd_sample.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector()
    abstract MainActivity bindMainActivity();

}
