'use strict';

/** 画面ロード時の処理. */
jQuery(function($){

  /** 更新ボタンを押したときの処理. */
  $('#btn-update').click(function (event) {
    // プロジェクト更新
    updateProject();
  });

  /** 削除ボタンを押したときの処理. */
  $('#btn-delete').click(function (event) {
    // プロジェクト削除
    deleteProject();
  });
});

/** プロジェクト更新処理. */
function updateProject() {

  // フォームの値を取得
  var formData = $('#project-detail-form').serializeArray();

  // ajax通信
  $.ajax({
    type : "PUT",
    cache : false,
    url : '/project/update',
    data: formData,
    dataType : 'json',
  }).done(function(data) {
    // ajax成功時の処理
    alert('プロジェクトを更新しました');
    // メンバー一覧画面にリダイレクト
    window.location.href = '/project/list';

  }).fail(function(jqXHR, textStatus, errorThrown) {
    // ajax失敗時の処理
    alert('プロジェクト更新に失敗しました');
  }).always(function() {
    // 常に実行する処理
  });
}

/** プロジェクト削除処理. */
function deleteProject() {

  // フォームの値を取得
  var formData = $('#project-detail-form').serializeArray();

  // ajax通信
  $.ajax({
    type : "DELETE",
    cache : false,
    url : '/project/delete',
    data: formData,
    dataType : 'json',
  }).done(function(data) {
    // ajax成功時の処理
    alert('プロジェクトを削除しました');
    // プロジェクト一覧画面にリダイレクト
    window.location.href = '/project/list';

  }).fail(function(jqXHR, textStatus, errorThrown) {
    // ajax失敗時の処理
    alert('プロジェクト削除に失敗しました');

  }).always(function() {
    // 常に実行する処理
  });
}