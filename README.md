# [Android Testing Bootcamp](http://android-testing-bootcamp.connpass.com/event/36783/)

テストの書き方を学ぶためのソースコードを利用したサンプルです。

connpass のイベント情報をリストに表示するアプリに対して Robolectric を利用し JVM 上で動作をするテストを用意しました。

テストを行いやすくするために Dagger2 を利用した DI を導入しています。

## 使い方

[pull/1](https://github.com/numa08/Android-testing-bootcamp-3/pull/1) でテストの無いアプリに対してテストを追加した pull request を作りました。 diff を見ながら何を行ったのかを進めていきます。

ハンズオン型式なので、一部ライブコーディングをしながら進めていきたいと思います。

## アプリ解説

[Connpass API](http://connpass.com/about/api/) を利用して Android Testing Bootcamp のイベントを取得し、 `RecyclerView` に表示します。

主な依存ライブラリとして

 - Retrofit2: HTTP 通信
 - Dagger2: DI

を利用しています。

### DI

Retrofit による通信モジュールやデータ取得を行う Presentation は DI を利用し、テストとそれ以外などのパターンで差し替えを行うことができるようにしています。

### Data Binding と ViewModel

Data Binding を利用して API から取得をしたデータの表示を行います。取得したデータそのものは View に直接セットすることができないので、 ViewModel を用意して必要なデータを取り出しやすくしています。

## テスト

[Robolectric](http://robolectric.org/) と [Mockito](http://mockito.org/) を利用して JVM 上で動作をするテストを用意しました。

### 最初のテスト

Robolectric や Mockito を利用しない箇所のテストを書きます。 Robolectric は Android の API を JVM 上で動かすためのライブラリ。そのため、 Android SDK に依存をしない箇所については普通の Robolectric を利用しなくても構いません。

[junit のみでテストを用意できる gson 生成クラスのテストを書きました](https://github.com/numa08/Android-testing-bootcamp-3/pull/1/commits/cfc226063c84d5f13c1dede8867d626ec7a2830b)

 - `GsonMapperTest.java`

API からのレスポンスの json をデシリアライズするために利用する Gson を生成するクラスをテストします。 json 文字列を生成された Gson を利用してシリアライズし、正しくデータをマッピングできるかどうかの確認を行います。

### Robolectric を利用したテスト

Android SDK に依存をしている部分は Robolectric を利用してテストを書く必要があります。

[Robolectric を利用する必要のある部分のテストを書きました](https://github.com/numa08/Android-testing-bootcamp-3/pull/1/commits/751db729ed7954f2ab24bb93af215d4c5f093145)

 - `EventRowViewModelTest.java`

Connpass API のレスポンスを表示可能なデータ型式とする ViewModel のテストです。 `EventRowViewModel` はデータがセットされると View にデータが描画されるため、最終的に描画されたデータの内容をテストします。

### Mockito を利用したテスト

Mockito を利用することで class や interface のモックを生成し、処理の結果を操作することで Activity 等のコンポーネントをテストできます。

[mockito を利用する部分のテストを書きました
](https://github.com/numa08/Android-testing-bootcamp-3/pull/1/commits/01cc48055e5941980f0ceb11b11058671136fb66)

 - `SuccessLoadEventTest`

`ConnpassAPI` に依存した　`EventListActivity` をテストするために、 `ConnpassAPI` をモックし、 Robolectric 用に作った Application のサブクラスを利用してモックを Dagger によって DI します。

その結果、画面に描画されるデータを検証することでデータの取得と描画が行われていることをテストします。
