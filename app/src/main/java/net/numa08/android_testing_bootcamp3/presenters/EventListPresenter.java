package net.numa08.android_testing_bootcamp3.presenters;

import net.numa08.android_testing_bootcamp3.network.connpass.Response;

public interface EventListPresenter {

    interface EventListView {
        void showEvents(Response response);
        void showError(Throwable error);
    }

    void onCreate();

    void onResume();

    void onPause();

    void onDestroy();

    void showSeriesOfEvent(long seriedId);

    void setEventLietView(EventListView eventListView);

}
