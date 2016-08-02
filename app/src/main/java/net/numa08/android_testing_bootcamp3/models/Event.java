package net.numa08.android_testing_bootcamp3.models;

import android.support.annotation.StringDef;

import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

/**
 * events	配列(複数要素)	検索結果のイベントリスト
 * event_id	整数	イベントID	364
 * title	文字列(UTF-8)	タイトル	BPStudy#56
 * catch	文字列(UTF-8)	キャッチ	株式会社ビープラウドが主催するWeb系技術討論の会
 * description	文字列(UTF-8)	概要(HTML形式)	今回は「Python プロフェッショナル　プログラミング」執筆プロジェクトの継続的ビルドについて、お話しして頂きます。
 * event_url	文字列(UTF-8)	connpass.com 上のURL	http://connpass.com/event/364/
 * hash_tag	文字列(UTF-8)	Twitterのハッシュタグ	bpstudy
 * started_at	文字列(UTF-8)	イベント開催日時 (ISO-8601形式)	2012-04-17T18:30:00+09:00
 * ended_at	文字列(UTF-8)	イベント終了日時 (ISO-8601形式)	2012-04-17T20:30:00+09:00
 * limit	整数	定員	80
 * event_type	文字列(UTF-8)	イベント参加タイプ	participation: connpassで参加受付あり
 * advertisement: 告知のみ
 * series	オブジェクト	グループ
 * address	文字列(UTF-8)	開催場所	東京都渋谷区千駄ヶ谷5-32-7
 * place	文字列(UTF-8)	開催会場	BPオフィス (NOF南新宿ビル4F)
 * lat	浮動小数点数	開催会場の緯度	35.680236100000
 * lon	浮動小数点数	開催会場の経度	139.701308500000
 * owner_id	整数	管理者のID	8
 * owner_nickname	文字列(UTF-8)	管理者のニックネーム	haru860
 * owner_display_name	文字列(UTF-8)	管理者の表示名	佐藤 治夫
 * accepted	整数	参加者数	80
 * waiting	整数	補欠者数	15
 * updated_at	文字列(UTF-8)	更新日時 (ISO-8601形式)	2012-03-20T12:07:32+09:00
 */

public final class Event {

    @SerializedName("event_id")
    long eventId;
    String title;
    @SerializedName("catch")
    String catchText;
    String description;
    @SerializedName("event_url")
    String eventUrl;
    @SerializedName("hash_tag")
    String hashTag;
    @SerializedName("started_at")
    Date startedAt;
    @SerializedName("ended_at")
    Date endedAt;
    long limit;
    @SerializedName("event_type")
    @EventType
    String eventType;
    Series series;
    String address;
    String place;
    String lat;
    String lon;
    @SerializedName("owner_id")
    long ownerId;
    @SerializedName("owner_nickname")
    String ownerNickname;
    @SerializedName("owner_display_name")
    String ownerDisplayName;
    long accepted;
    long waiting;
    @SerializedName("updated_at")
    Date updatedAt;

    @StringDef({EventType.PARTICIPATION, EventType.ADVETISEMENT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EventType {
        String PARTICIPATION = "participation";
        String ADVETISEMENT = "advertisement";
    }

    public long getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getCatchText() {
        return catchText;
    }

    public String getDescription() {
        return description;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public String getHashTag() {
        return hashTag;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    public long getLimit() {
        return limit;
    }

    @EventType
    public String getEventType() {
        return eventType;
    }

    public Series getSeries() {
        return series;
    }

    public String getAddress() {
        return address;
    }

    public String getPlace() {
        return place;
    }

    public double getLat() {
        return Double.parseDouble(lat);
    }

    public double getLon() {
        return Double.parseDouble(lon);
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getOwnerNickname() {
        return ownerNickname;
    }

    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    public long getAccepted() {
        return accepted;
    }

    public long getWaiting() {
        return waiting;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
