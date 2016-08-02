package net.numa08.android_testing_bootcamp3.ui.viewmodels;

import android.view.LayoutInflater;

import net.numa08.android_testing_bootcamp3.databinding.ViewEventRowBinding;
import net.numa08.android_testing_bootcamp3.models.Event;
import net.numa08.android_testing_bootcamp3.models.mapper.GsonMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static net.numa08.android_testing_bootcamp3.testtools.TestUtils.loadJson;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class EventRowViewModelTest {

    @Test
    public void get_events_in_japan() throws Throwable {
        final Event event = createEvent();
        final ViewEventRowBinding binding = createViewEventRowBinding();
        final EventRowViewModel viewModel = new EventRowViewModel(binding);

        viewModel.setEvent(event);
        assertThat(viewModel.getMonth(), is("08"));
        assertThat(viewModel.getDate(), is("05"));
//        assertThat(viewModel.getDateOfWeek(), is("金"));
        assertThat(viewModel.getPlace(), is("東京都渋谷区神泉町8-16　渋谷ファーストプレイス8F"));
        assertThat(viewModel.getTitle(), is("Android Testing Bootcamp #3"));
        assertThat(viewModel.getStartedAt(), is("19:00"));
    }

    @Test
    public void bind_model_to_view() throws Throwable {
        final Event event = createEvent();
        final ViewEventRowBinding binding = createViewEventRowBinding();
        final EventRowViewModel viewModel = new EventRowViewModel(binding);

        viewModel.setEvent(event);

        assertThat(binding.monthText.getText().toString(), is("08"));
        assertThat(binding.dateText.getText().toString(), is("05"));
//        assertThat(binding.dateOfWeekText.getText().toString(), is("金"));
        assertThat(binding.placeText.getText().toString(), is("東京都渋谷区神泉町8-16　渋谷ファーストプレイス8F"));
        assertThat(binding.titleText.getText().toString(), is("Android Testing Bootcamp #3"));
        assertThat(binding.startedAtText.getText().toString(), is("19:00"));
    }

    private ViewEventRowBinding createViewEventRowBinding() {
        final LayoutInflater layoutInflater = LayoutInflater.from(RuntimeEnvironment.application);
        return ViewEventRowBinding.inflate(layoutInflater, null, false);
    }

    private Event createEvent() throws Throwable {
        final String json = loadJson("event.json");
        return new GsonMapper().getGson().fromJson(json, Event.class);
    }

}