package net.numa08.android_testing_bootcamp3.network.connpass;

import com.google.gson.annotations.SerializedName;

import net.numa08.android_testing_bootcamp3.models.Event;

import java.util.List;

/**
 * results_returned	整数	含まれる検索結果の件数	1
 * results_available	整数	検索結果の総件数	191
 * results_start	整数	検索の開始位置
 */
public final class Response {
    @SerializedName("results_returned")
    long resultsReturned;
    @SerializedName("results_available")
    long resultsAvailable;
    @SerializedName("results_start")
    long resultStart;
    List<Event> events;

    public long getResultsReturned() {
        return resultsReturned;
    }

    public long getResultsAvailable() {
        return resultsAvailable;
    }

    public long getResultStart() {
        return resultStart;
    }

    public List<Event> getEvents() {
        return events;
    }
}
