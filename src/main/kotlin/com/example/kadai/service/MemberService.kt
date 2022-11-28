package com.example.kadai.service

import com.example.kadai.model.Member

interface MemberService {
    /** メンバー登録  */
    fun insert(member: Member)

    /** ユーザー取得  */
    fun getMembers(member: Member): List<Member>

    /** ユーザー取得（１件） */
    fun getMemberOne(memberId: Int?): Member

    /** ユーザー更新(1件)  */
    fun updateUserOne(
        memberId: Int?,
        memberName: String?,
        memberRank: String?,
        companyId: Int?
    )

    /** ユーザー削除(1件)  */
    fun deleteMemberOne(memberId: Int?)
}