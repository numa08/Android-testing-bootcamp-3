package net.numa08.android_testing_bootcamp3.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.numa08.android_testing_bootcamp3.databinding.ViewEventRowBinding;
import net.numa08.android_testing_bootcamp3.models.Event;
import net.numa08.android_testing_bootcamp3.ui.viewmodels.EventRowViewModel;

import java.util.Collections;
import java.util.List;

public final class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    List<Event> events = Collections.emptyList();

    public void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final ViewEventRowBinding binding = ViewEventRowBinding.inflate(layoutInflater, parent, false);
        final View view = binding.getRoot();
        return new ViewHolder(view, binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Event event = events.get(position);
        holder.viewModel.setEvent(event);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {

        final EventRowViewModel viewModel;

        public ViewHolder(View itemView, ViewEventRowBinding binding) {
            super(itemView);
            this.viewModel = new EventRowViewModel(binding);
        }
    }
}
