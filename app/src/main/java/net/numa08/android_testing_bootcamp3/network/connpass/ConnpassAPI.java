package net.numa08.android_testing_bootcamp3.network.connpass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConnpassAPI {
    @GET("v1/event/")
    Call<Response> showSeriesOfEvent(@Query("series_id") long seriesId);

    @GET("v1/event/")
    Call<Response> showEvent(@Query("event_id") long eventId);
}
