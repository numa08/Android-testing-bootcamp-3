package net.numa08.android_testing_bootcamp3.ui.viewmodels;

import net.numa08.android_testing_bootcamp3.databinding.ActivityEventListBinding;
import net.numa08.android_testing_bootcamp3.models.Event;
import net.numa08.android_testing_bootcamp3.network.connpass.Response;
import net.numa08.android_testing_bootcamp3.presenters.EventListPresenter;
import net.numa08.android_testing_bootcamp3.ui.adapters.EventListAdapter;

import java.util.List;

public class EventListActivityViewModel implements EventListPresenter.EventListView {
    final ActivityEventListBinding binding;
    final EventListPresenter eventListPresenter;
    final EventListAdapter adapter;

    public EventListActivityViewModel(ActivityEventListBinding binding, EventListPresenter eventListPresenter, EventListAdapter adapter) {
        this.binding = binding;
        this.eventListPresenter = eventListPresenter;
        this.adapter = adapter;
        this.binding.list.setAdapter(this.adapter);
        this.eventListPresenter.setEventLietView(this);
    }

    public void showSeriesOfEvent(long seriesID) {
        this.eventListPresenter.showSeriesOfEvent(seriesID);
    }

    @Override
    public void showEvents(Response response) {
        final List<Event> events = response.getEvents();
        adapter.setEvents(events);
        binding.notifyChange();
    }

    @Override
    public void showError(Throwable error) {

    }

    public boolean hasData() {
        return adapter.getItemCount() > 0;
    }
}
