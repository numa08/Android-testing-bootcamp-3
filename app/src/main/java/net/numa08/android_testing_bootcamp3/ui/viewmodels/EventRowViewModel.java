package net.numa08.android_testing_bootcamp3.ui.viewmodels;

import android.text.format.DateFormat;

import net.numa08.android_testing_bootcamp3.databinding.ViewEventRowBinding;
import net.numa08.android_testing_bootcamp3.models.Event;

public class EventRowViewModel {
    final ViewEventRowBinding binding;
    Event event;

    public EventRowViewModel(ViewEventRowBinding binding) {
        this.binding = binding;
        this.binding.setEvent(this);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        binding.setEvent(this);
        binding.executePendingBindings();
    }


    public String getMonth() {
        return DateFormat.format("MM", event.getStartedAt()).toString();
    }

    public String getDate() {
        return DateFormat.format("dd", event.getStartedAt()).toString();
    }

    public String getDateOfWeek() {
        return DateFormat.format("E", event.getStartedAt()).toString();
    }

    public String getPlace() {
        return event.getAddress();
    }

    public String getTitle() {
        return event.getTitle();
    }

    public String getStartedAt() {
        return DateFormat.format("kk:mm", event.getStartedAt()).toString();
    }
}
