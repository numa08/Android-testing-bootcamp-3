package net.numa08.android_testing_bootcamp3.ui.activities;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import net.numa08.android_testing_bootcamp3.TestApplication;
import net.numa08.android_testing_bootcamp3.di.components.ApplicationComponents;
import net.numa08.android_testing_bootcamp3.di.components.DaggerApplicationComponents;
import net.numa08.android_testing_bootcamp3.di.modules.ConnpassAPIModule;
import net.numa08.android_testing_bootcamp3.models.mapper.GsonMapper;
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
import retrofit2.mock.Calls;

import static net.numa08.android_testing_bootcamp3.testtools.TestUtils.loadJson;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("unused")
public class EventListActivityTest {

    @RunWith(RobolectricTestRunner.class)
    @Config(application = TestApplication.class)
    public static class SuccessLoadEventTest {

        @Before
        public void initMockPresenter() throws Throwable {
            final String json = loadJson("response.json");
            final Gson gson = new GsonMapper().getGson();
            final Response response = gson.fromJson(json, Response.class);
            final Call<Response> call = Calls.response(response);

            final ConnpassAPI mockAPI = mock(ConnpassAPI.class);
            when(mockAPI.showSeriesOfEvent(anyLong())).thenReturn(call);
            
            final ApplicationComponents components = DaggerApplicationComponents.builder()
                    .connpassAPIModule(new ConnpassAPIModule() {
                        @Override
                        public ConnpassAPI providesConnpassAPI(final Gson gson) {
                            return mockAPI;
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