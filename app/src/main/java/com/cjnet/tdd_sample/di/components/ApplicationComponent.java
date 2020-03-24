package com.cjnet.tdd_sample.di.components;

import com.cjnet.tdd_sample.PostApp;
import com.cjnet.tdd_sample.di.module.ActivityBindingModule;
import com.cjnet.tdd_sample.di.module.ApplicationModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class})

public interface ApplicationComponent extends AndroidInjector<PostApp> {

    void inject(PostApp application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(PostApp application);

        ApplicationComponent build();
    }
}
