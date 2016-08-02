package net.numa08.android_testing_bootcamp3.models;

/**
 * series	オブジェクト	グループ
 * id	整数	グループID	1
 * title	文字列(UTF-8)	グループタイトル	BPStudy
 * url	文字列(UTF-8)	グループのconnpass.com 上のURL	http://connpass.com/series/1/
 */

public final class Series {
    long id;
    String title;
    String url;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
