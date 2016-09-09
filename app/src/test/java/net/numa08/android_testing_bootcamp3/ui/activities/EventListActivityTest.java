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
import retrofit2.mock.Calls;

import static net.numa08.android_testing_bootcamp3.testtools.TestObjectFactory.createResponse;
import static net.numa08.android_testing_bootcamp3.testtools.TestUtils.loadJson;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


// Activity に関するテスト
// 1つのクラスに対して複数の状態が想定され、テストケースがややこしくなるとき
// static class を利用することもある
@SuppressWarnings("unused")
public class EventListActivityTest {

    // Presenter で connpass api を呼び出した結果成功したときのパターン
    @RunWith(RobolectricTestRunner.class)
    @Config(application = TestApplication.class)
    public static class SuccessLoadEventTest {

        // Presenter のモックを Dagger2 のコンポーネントを上書きして Activity に与える
        // Retrofit の interface を mockito を使ってモックし、モックのレスポンスを返すことで、
        // 常に同じ Response の得られる Presenter を Activity に与えることができる
        @Before
        public void initMockPresenter() throws Throwable {
            final String json = loadJson("response.json");
            final Response response = createResponse(json);
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
            assertThat("RecyclerView.Adapter が Event の数だけ View を返すこと" ,list.getAdapter().getItemCount(), is(2));
        }
    }

}
