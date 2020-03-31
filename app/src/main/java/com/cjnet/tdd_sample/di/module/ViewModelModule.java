package com.cjnet.tdd_sample.di.module;

import com.cjnet.tdd_sample.api.TDDViewModelFactory;
import com.cjnet.tdd_sample.di.scope.ViewModelKey;
import com.cjnet.tdd_sample.ui.viewmodel.PostsViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    abstract ViewModel bindNewsViewModel(PostsViewModel searchViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindTDDViewModelFactory(TDDViewModelFactory factory);
}
