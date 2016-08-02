package net.numa08.android_testing_bootcamp3.ui.activities;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import net.numa08.android_testing_bootcamp3.TestApplication;
import net.numa08.android_testing_bootcamp3.di.components.ApplicationComponents;
import net.numa08.android_testing_bootcamp3.di.components.DaggerApplicationComponents;
import net.numa08.android_testing_bootcamp3.di.modules.ConnpassAPIModule;
import net.numa08.android_testing_bootcamp3.network.connpass.ConnpassAPI;
import net.numa08.android_testing_bootcamp3.network.connpass.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.mock.Calls;

import static net.numa08.android_testing_bootcamp3.testtools.TestUtils.loadJson;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SuppressWarnings("unused")
public class EventListActivityTest {

    @RunWith(RobolectricTestRunner.class)
    @Config(application = TestApplication.class)
    public static class SuccessLoadEventTest {

        @Before
        public void initMockPresenter() {
            final ApplicationComponents components = DaggerApplicationComponents.builder()
                    .connpassAPIModule(new ConnpassAPIModule() {
                        @Override
                        public ConnpassAPI providesConnpassAPI(final Gson gson) {
                            return new ConnpassAPI() {
                                @Override
                                public Call<Response> showSeriesOfEvent(@Query("series_id") long seriesId) {
                                    try {
                                        final String json = loadJson("response.json");
                                        final Response response = gson.fromJson(json, Response.class);
                                        return Calls.response(response);
                                    } catch (Throwable throwable) {
                                        throw new AssertionError(throwable);
                                    }
                                }

                                @Override
                                public Call<Response> showEvent(@Query("event_id") long eventId) {
                                    throw new AssertionError("これが呼ばれることは無い");
                                }
                            };
                        }
                    }).build();
            ((TestApplication) ShadowApplication.getInstance().getApplicationContext()).setApplicationComponents(components);
        }

        @Test
        public void show_events() throws Throwable {
            final EventListActivity activity = Robolectric.buildActivity(EventListActivity.class).create().get();
            final RecyclerView list = (RecyclerView) activity.findViewById(android.R.id.list);
            assertThat(list.getAdapter().getItemCount(), is(2));
        }
    }

}