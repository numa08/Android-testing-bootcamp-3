package net.numa08.android_testing_bootcamp3.presenters.internale;

import net.numa08.android_testing_bootcamp3.network.connpass.ConnpassAPI;
import net.numa08.android_testing_bootcamp3.network.connpass.Response;
import net.numa08.android_testing_bootcamp3.presenters.EventListPresenter;

import retrofit2.Call;
import retrofit2.Callback;

public final class EventListPresenterImpl implements EventListPresenter {
    final ConnpassAPI connpassAPI;
    EventListView eventListView;

    public EventListPresenterImpl(ConnpassAPI connpassAPI) {
        this.connpassAPI = connpassAPI;
    }

    @Override
    public void onCreate() {}

    @Override
    public void onResume() {}

    @Override
    public void onPause() {}

    @Override
    public void onDestroy() {
        this.eventListView = null;
    }

    @Override
    public void showSeriesOfEvent(long seriedId) {
        connpassAPI.showSeriesOfEvent(seriedId)
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (eventListView == null) {
                            return;
                        }
                        if (!response.isSuccessful()) {
                            //TODO show http error
                            return;
                        }
                        eventListView.showEvents(response.body());
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        if (eventListView == null) {
                            return;
                        }
                        eventListView.showError(t);
                    }
                });
    }

    @Override
    public void setEventLietView(EventListView eventListView) {
        this.eventListView = eventListView;
    }
}
