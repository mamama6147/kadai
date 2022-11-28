'use strict';

/** 画面ロード時の処理. */
jQuery(function($){

  /** 登録ボタンを押したときの処理. */
  $('#btn-insert').click(function (event) {
    // ユーザー登録
    insertMember();
  });
});

/** メンバー登録処理 */
function insertMember() {

  // バリデーション結果をクリア
//  removeValidResult();

  // フォームの値を取得
  var formData = $('#signup-form').serializeArray();

  // ajax通信
  $.ajax({
    type : "POST",
    cache : false,
    url : '/member/new/rest',
    data: formData,
    dataType : 'json',
  }).done(function(data) {
    // ajax成功時の処理
    console.log(data);

//    if(data.result == 90) {
//      // validationエラー時の処理
//      $.each(data.errors, function (key, value) {
//        reflectValidResult(key, value)
//      });

//    } else if(data.result == 0) {
      alert('ユーザーを登録しました');
      // メンバー一覧画面にリダイレクト
      window.location.href = '/member/list';
//    }

  }).fail(function(jqXHR, textStatus, errorThrown) {
    // ajax失敗時の処理
    alert('ユーザー登録に失敗しました');

  }).always(function() {
    // 常に実行する処理
  });
}