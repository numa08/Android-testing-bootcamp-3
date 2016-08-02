package net.numa08.android_testing_bootcamp3;

import android.app.Application;

import net.numa08.android_testing_bootcamp3.di.components.ApplicationComponents;
import net.numa08.android_testing_bootcamp3.di.components.DaggerApplicationComponents;

public class CustomApplication extends Application {

    private static CustomApplication self;
    private ApplicationComponents applicationComponents;

    public static CustomApplication getInstance() {
        return self;
    }

    public ApplicationComponents getApplicationComponents() {
        return applicationComponents;
    }

    protected void setApplicationComponents(ApplicationComponents applicationComponents) {
        this.applicationComponents = applicationComponents;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        self = this;
        applicationComponents = DaggerApplicationComponents.create();
    }
}
