package net.numa08.android_testing_bootcamp3.testtools;

import android.annotation.SuppressLint;

import net.numa08.android_testing_bootcamp3.models.mapper.GsonMapperTest;

import java.io.InputStream;

import okio.Okio;

public final class TestUtils {
    /**
     * test/resources 以下に配置されたファイルをロードし、文字列を返します。
     * ファイルの中身は utf-8 でエンコードされている必要があります。
     *
     * @param file test/resources からの相対パスでファイルのパスを指定します
     * @return 読み込んだファイルの中の文字列
     */
    @SuppressLint("NewApi")
    public static String loadJson(String file) throws Throwable {
        try (final InputStream in = GsonMapperTest.class.getClassLoader().getResourceAsStream(file)) {
            return Okio.buffer(Okio.source(in))
                    .readByteString()
                    .utf8();
        }
    }

}
