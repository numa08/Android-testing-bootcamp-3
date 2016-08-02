package net.numa08.android_testing_bootcamp3.testtools;

import android.annotation.SuppressLint;

import net.numa08.android_testing_bootcamp3.models.mapper.GsonMapperTest;

import java.io.InputStream;

import okio.Okio;

public final class TestUtils {
    @SuppressLint("NewApi")
    public static String loadJson(String file) throws Throwable {
        try (final InputStream in = GsonMapperTest.class.getClassLoader().getResourceAsStream(file)) {
            return Okio.buffer(Okio.source(in))
                    .readByteString()
                    .utf8();
        }
    }

}
