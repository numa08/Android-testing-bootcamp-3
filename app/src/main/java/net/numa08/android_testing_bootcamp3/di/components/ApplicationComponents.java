package net.numa08.android_testing_bootcamp3.di.components;

import com.google.gson.Gson;

import net.numa08.android_testing_bootcamp3.di.modules.ConnpassAPIModule;
import net.numa08.android_testing_bootcamp3.di.modules.GsonModule;
import net.numa08.android_testing_bootcamp3.network.connpass.ConnpassAPI;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ConnpassAPIModule.class,
        GsonModule.class})
public interface ApplicationComponents {

    Gson gson();
    ConnpassAPI connpassAPI();
    PresenterComponents presenterComponents();
}
