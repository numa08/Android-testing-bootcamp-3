package net.numa08.android_testing_bootcamp3.testtools;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.numa08.android_testing_bootcamp3.models.Event;
import net.numa08.android_testing_bootcamp3.network.connpass.Response;

public class TestObjectFactory {

    public static Event createEvent(String json) throws Throwable {
        final Gson gson = getGson();
        return gson.fromJson(json, Event.class);
    }

    public static Response createResponse(String json) throws Throwable {
        final Gson gson = getGson();
        return gson.fromJson(json, Response.class);
    }

    @NonNull
    private static Gson getGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
    }


}
