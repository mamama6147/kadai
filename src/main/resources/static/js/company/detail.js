'use strict';

/** 画面ロード時の処理. */
jQuery(function($){

  /** 更新ボタンを押したときの処理. */
  $('#btn-update').click(function (event) {
    // 会社更新
    updateCompany();
  });

  /** 削除ボタンを押したときの処理. */
  $('#btn-delete').click(function (event) {
    // 会社削除
    deleteCompany();
  });
});

/** 会社更新処理. */
function updateCompany() {

  // フォームの値を取得
  var formData = $('#company-detail-form').serializeArray();

  // ajax通信
  $.ajax({
    type : "PUT",
    cache : false,
    url : '/company/update',
    data: formData,
    dataType : 'json',
  }).done(function(data) {
    // ajax成功時の処理
    alert('会社を更新しました');
    // メンバー一覧画面にリダイレクト
    window.location.href = '/company/list';

  }).fail(function(jqXHR, textStatus, errorThrown) {
    // ajax失敗時の処理
    alert('会社更新に失敗しました');
  }).always(function() {
    // 常に実行する処理
  });
}

/** 会社削除処理. */
function deleteCompany() {

  // フォームの値を取得
  var formData = $('#company-detail-form').serializeArray();

  // ajax通信
  $.ajax({
    type : "DELETE",
    cache : false,
    url : '/company/delete',
    data: formData,
    dataType : 'json',
  }).done(function(data) {
    // ajax成功時の処理
    alert('会社を削除しました');
    // 会社一覧画面にリダイレクト
    window.location.href = '/company/list';

  }).fail(function(jqXHR, textStatus, errorThrown) {
    // ajax失敗時の処理
    alert('会社削除に失敗しました');

  }).always(function() {
    // 常に実行する処理
  });
}