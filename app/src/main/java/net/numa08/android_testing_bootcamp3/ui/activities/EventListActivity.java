package net.numa08.android_testing_bootcamp3.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.numa08.android_testing_bootcamp3.CustomApplication;
import net.numa08.android_testing_bootcamp3.R;
import net.numa08.android_testing_bootcamp3.databinding.ActivityEventListBinding;
import net.numa08.android_testing_bootcamp3.presenters.EventListPresenter;
import net.numa08.android_testing_bootcamp3.ui.adapters.EventListAdapter;
import net.numa08.android_testing_bootcamp3.ui.viewmodels.EventListActivityViewModel;

import javax.inject.Inject;

public class EventListActivity extends AppCompatActivity {

    public static final long ANDROID_TEST_BOOTCAMP = 2090;
    @Inject
    EventListPresenter eventListPresenter;
    EventListActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityEventListBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_event_list);
        CustomApplication
                .getInstance()
                .getApplicationComponents()
                .presenterComponents()
                .inject(this);
        eventListPresenter.onCreate();
        final EventListAdapter adapter = new EventListAdapter();
        viewModel = new EventListActivityViewModel(dataBinding, eventListPresenter, adapter);
        viewModel.showSeriesOfEvent(ANDROID_TEST_BOOTCAMP);
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventListPresenter.onResume();
    }

    @Override
    protected void onPause() {
        eventListPresenter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        eventListPresenter.onDestroy();
        super.onDestroy();
    }
}
