package net.numa08.android_testing_bootcamp3.di.components;

import net.numa08.android_testing_bootcamp3.di.ViewScope;
import net.numa08.android_testing_bootcamp3.di.modules.PresenterModule;
import net.numa08.android_testing_bootcamp3.ui.activities.EventListActivity;

import dagger.Subcomponent;

@ViewScope
@Subcomponent(modules = {PresenterModule.class})
public interface PresenterComponents {
    void inject(EventListActivity activity);
}
