'use strict';

var memberData = null; // メンバーデータ
var table = null; // DataTablesオブジェクト

/** 画面ロード時の処理. */
jQuery(function($){

  // DataTablesの初期化
  createDataTables();

  /** 検索ボタンを押したときの処理. */
  $('#btn-search').click(function (event) {
    // 検索
    search();
  });
});

/** 検索処理. */
function search() {

  // formの値を取得
  var formData = $('#member-search-form').serialize();

  // ajax通信
  $.ajax({
    type : "GET",
    url : '/member/get/list',
    data: formData,
    dataType : 'json',
    contentType: 'application/json; charset=UTF-8',
    cache : false,
    timeout : 5000,
  }).done(function(data) {
    // ajax成功時の処理
    console.log(data);
    // JSONを変数に入れる
    memberData = data;
    // DataTables作成
    createDataTables();


  }).fail(function(jqXHR, textStatus, errorThrown) {
    // ajax失敗時の処理
    alert('検索処理に失敗しました');
  }).always(function() {

  });
}

/** DataTables作成. */
function createDataTables() {

  //既にDataTablesが作成されている場合
  if(table !== null) {
    // DataTables破棄
    table.destroy();
  }

  // DataTables作成
  table = $('#member-list-table').DataTable({

    //表示データ
    data: memberData,
    //データと列のマッピング
    columns: [
      { data: 'memberId'}, // メンバーID
      { data: 'memberName'}, // 氏名
      { data: 'memberRank'}, // ランク
      { data: 'company.companyName'},// 所属会社
      {
        data: 'memberId', // 詳細画面のURL
          render: function ( data, type, row ) {
            var url = '<a href="/member/' + data + '">詳細</a>';
            return url;
        }
      }

    ]

  });
}