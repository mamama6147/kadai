package com.example.kadai.service

import com.example.kadai.model.Member

interface MemberService {
    /** メンバー登録  */
    fun insert(member: Member)

    /** ユーザー取得  */
    fun getMembers(): List<Member>
}