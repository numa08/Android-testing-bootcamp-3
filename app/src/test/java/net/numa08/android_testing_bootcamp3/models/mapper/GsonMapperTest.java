package net.numa08.android_testing_bootcamp3.models.mapper;

import com.google.gson.Gson;

import net.numa08.android_testing_bootcamp3.models.Event;
import net.numa08.android_testing_bootcamp3.models.Series;
import net.numa08.android_testing_bootcamp3.network.connpass.Response;

import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

import static net.numa08.android_testing_bootcamp3.testtools.TestUtils.loadJson;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//  GsonMapper クラスの生成する gson を利用して正しく connpass api のレスポンスを
//  パースできるかどうかをテストします。
public class GsonMapperTest {


    // Event クラスにパースをするテスト
    @Test
    public void decode_event_json() throws Throwable {
        final String json = loadJson("event.json");
        final Gson gson = new GsonMapper().getGson();
        final Event event = gson.fromJson(json, Event.class);

        assertThat(event.getEventUrl(), is("http://android-testing-bootcamp.connpass.com/event/36783/"));
        assertThat(event.getEventType(), is("participation"));
        final Series series = event.getSeries();
        assertThat(series.getUrl(), is("http://android-testing-bootcamp.connpass.com/"));
        assertThat(series.getId(), is(2090L));
        assertThat(series.getTitle(), is("Android Testing Bootcamp"));

        // expected に Calendar を利用するときは
        // 海外の CI サービスを利用するなどした際にもテストが通るように
        // Locale を指定する
        final Calendar updatedAt = Calendar.getInstance(Locale.JAPAN);
        updatedAt.set(2016, Calendar.JULY, 27, 14, 15, 50);
        updatedAt.set(Calendar.MILLISECOND, 0);
        assertThat(event.getUpdatedAt(), is(updatedAt.getTime()));

        assertThat(event.getLat(), is(35.655261600000));

        final Calendar startedAt = Calendar.getInstance(Locale.JAPAN);
        startedAt.set(2016, Calendar.AUGUST, 5, 19, 0, 0);
        startedAt.set(Calendar.MILLISECOND, 0);
        assertThat(event.getStartedAt(), is(startedAt.getTime()));

        assertThat(event.getHashTag(), is("Android_Testing_BC"));
        assertThat(event.getTitle(), is("Android Testing Bootcamp #3"));
        assertThat(event.getEventId(), is(36783L));
        assertThat(event.getLon(), is(139.693729900000));
        assertThat(event.getWaiting(), is(40L));
        assertThat(event.getLimit(), is(37L));
        assertThat(event.getOwnerId(), is(13107L));
        assertThat(event.getOwnerDisplayName(), is("Fumihiko Shiroyama"));
        assertThat(event.getDescription(), is("<h1>概要</h1>\n<p>Android開発者のみなさん、テスト書いてますか？<br>\n<a href=\"http://android-testing-bootcamp.connpass.com/event/31636/\" rel=\"nofollow\">前回</a>も大盛り上がりだったAndroid Testing Bootcampの第3回を開催します！</p>\n<p>今回は初めてのハンズオン（体験学習）形式で行います。<br>\n<strong>テストを初めて書く</strong> or <strong>あまり効果的に書けていない</strong>、<strong>自分のテストの書き方に自信がない</strong>といった方に、ハンズオンセミナー形式で課題にのっとって少しずつテストの書き方を体験していただきます。</p>\n<h1>テーマ</h1>\n<ul>\n<li>JUnit4で書く初めてのUnit Test for Android</li>\n<li>Mockito</li>\n<li>PowerMock</li>\n<li>できたらEspresso or Robolectric</li>\n<li>もしかしたらDIを利用したテストを書きやすい設計講座</li>\n</ul>\n<p>このうち時間の許す限り進めていきます。</p>\n<h1>チューターさん募集</h1>\n<p>上記テーマのうち、2つ以上で何かしら初めての方の学習を手助けできるという方、チューターとしてご協力いただけると非常に嬉しいです！</p>\n<h2>注意点</h2>\n<p>ハンズオン形式なので、必ず以下の説明をよく読んでから、当てはまる方のお申し込みをお願いします。</p>\n<ol>\n<li>Android StudioのインストールされたPCを当日必ず持参出来る方</li>\n<li>Javaの基礎がわかりAndroidでサンプルアプリでもいいので何かしらビルドした経験のある方</li>\n<li>できるかぎりドタキャンをしないでいただける方</li>\n<li>Androidのテストを書きたいという愛と情熱さえあれば初心者大歓迎！</li>\n</ol>\n<p>特に、人数をしぼってチューターさんにご協力いただくハンズオン形式なので、どうしても無理になってしまった方はできるだけ前日夜までにキャンセルして次の方にゆずっていただけると助かります。</p>\n<h1>タイムスケジュール</h1>\n<table>\n<thead>\n<tr>\n<th align=\"left\">時間</th>\n<th align=\"left\">内容</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td align=\"left\">18:45</td>\n<td align=\"left\">開場</td>\n</tr>\n<tr>\n<td align=\"left\">19:00-19:15</td>\n<td align=\"left\">会場諸注意と協賛企業さまよりお知らせ</td>\n</tr>\n<tr>\n<td align=\"left\">19:15-21:00</td>\n<td align=\"left\">ハンズオン（詳細決まり次第アップデートします）</td>\n</tr>\n<tr>\n<td align=\"left\">21:00-22:00</td>\n<td align=\"left\">懇親会</td>\n</tr>\n<tr>\n<td align=\"left\">22:00-</td>\n<td align=\"left\">撤収作業</td>\n</tr>\n</tbody>\n</table>\n<h1>会場について</h1>\n<p><strong>VOYAGE GROUP セミナールーム パンゲア</strong></p>\n<ul>\n<li>JR山手線　渋谷駅より徒歩15分</li>\n<li>京王井の頭線　神泉駅より徒歩3分</li>\n</ul>\n<p>19時過ぎに、正面玄関が外から開かなくなります。中から人が出てくるタイミングでダッシュで入館していただくか、左手を壁に裏まで回り込んで、裏口からご入館ください。<br>\n会場は <strong>8F</strong> です。エレベータで8Fまでお越しください。</p>\n<p>会場では電源とWiFiがご利用いただけますが、電源には限りがあります。</p>\n<h1>懇親会について</h1>\n<p>会場をお貸し下さった <a href=\"http://voyagegroup.com/\" rel=\"nofollow\">VOYAGE GROUP</a> 様の多大なるご厚意により、懇親会で軽食とドリンクがご提供いただける予定です。</p>\n<h1>その他</h1>\n<p>本イベントは開発者同士の知見共有や交流を目的としたものです。<br>\n技術者の採用や営業目的のご参加はご遠慮ください。</p>"));
        assertThat(event.getAddress(), is("東京都渋谷区神泉町8-16　渋谷ファーストプレイス8F"));
        assertThat(event.getCatchText(), is("はじめてのAndroidテストハンズオン"));
        assertThat(event.getAccepted(), is(34L));

        final Calendar endedAt = Calendar.getInstance(Locale.JAPAN);
        endedAt.set(2016, Calendar.AUGUST, 5, 22, 0, 0);
        endedAt.set(Calendar.MILLISECOND, 0);
        assertThat(event.getEndedAt(), is(endedAt.getTime()));

        assertThat(event.getPlace(), is("VOYAGE GROUP"));
    }

    // connpass-api の response をパースするテスト
    @Test
    public void decode_response_json() throws Throwable {
        final String json = loadJson("response.json");
        final Gson gson = new GsonMapper().getGson();
        final Response response = gson.fromJson(json, Response.class);

        assertThat(response.getResultsReturned(), is(2L));
        assertThat(response.getResultsAvailable(), is(2L));
        assertThat(response.getResultStart(), is(1L));
        assertThat(response.getEvents().size(), is(2));
    }
}