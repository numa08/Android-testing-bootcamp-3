package net.numa08.android_testing_bootcamp3.di.modules;

import com.google.gson.Gson;

import net.numa08.android_testing_bootcamp3.network.connpass.ConnpassAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
@Module
public class ConnpassAPIModule {

    final static String END_POINT = "http://connpass.com/api/";
    private ConnpassAPI connpassAPI;

    @Provides
    public ConnpassAPI providesConnpassAPI(Gson gson) {
        if (connpassAPI == null) {
            connpassAPI = new Retrofit.Builder().
                    baseUrl(END_POINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(ConnpassAPI.class);
        }
        return connpassAPI;
    }
}
