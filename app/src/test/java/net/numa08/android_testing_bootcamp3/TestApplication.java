package net.numa08.android_testing_bootcamp3;

import net.numa08.android_testing_bootcamp3.di.components.ApplicationComponents;

// テストのときだけ利用をする Application クラス
// Robolectric を利用してテストを行うとき、アノテーションで指定することで
// 利用される
public class TestApplication extends CustomApplication {
    // テストのときだけ setApplicationComponents を呼べるように、 public なメソッドとして override した
    @Override
    public void setApplicationComponents(ApplicationComponents applicationComponents) {
        super.setApplicationComponents(applicationComponents);
    }
}
