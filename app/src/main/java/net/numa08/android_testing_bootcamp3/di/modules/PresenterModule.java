package net.numa08.android_testing_bootcamp3.di.modules;

import net.numa08.android_testing_bootcamp3.di.ViewScope;
import net.numa08.android_testing_bootcamp3.network.connpass.ConnpassAPI;
import net.numa08.android_testing_bootcamp3.presenters.EventListPresenter;
import net.numa08.android_testing_bootcamp3.presenters.internale.EventListPresenterImpl;

import dagger.Module;
import dagger.Provides;

@ViewScope
@Module
public class PresenterModule {

    @Provides
    public EventListPresenter providesEventListPresenter(ConnpassAPI connpassAPI) {
        return new EventListPresenterImpl(connpassAPI);
    }

}
