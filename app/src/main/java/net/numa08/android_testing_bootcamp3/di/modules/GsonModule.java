package net.numa08.android_testing_bootcamp3.di.modules;

import com.google.gson.Gson;

import net.numa08.android_testing_bootcamp3.models.mapper.GsonMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class GsonModule {

    private Gson gson;

    @Provides
    public Gson providesGson() {
        if (gson == null) {
            gson = new GsonMapper().getGson();
        }
        return gson;
    }

}
