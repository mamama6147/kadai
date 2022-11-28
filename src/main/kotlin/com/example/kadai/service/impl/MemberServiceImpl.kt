package com.example.kadai.service.impl

import com.example.kadai.model.Member
import com.example.kadai.repository.MemberMapper
import com.example.kadai.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberServiceImpl(
    @Autowired private val mapper: MemberMapper
): MemberService{
    /** ユーザー登録  */
    override fun insert(member: Member) {

        mapper.insertOne(member)
    }

    /** ユーザー取得  */
    override fun getMembers(member: Member): List<Member> {
        return mapper.findMany(member)
    }

    /** ユーザー取得（１件） */
    override fun getMemberOne(memberId: Int?): Member {
        return mapper.findOne(memberId)
    }

    /** ユーザー更新(1件)  */
    @Transactional
    override fun updateUserOne(
        memberId: Int?,
        memberName: String?,
        memberRank: String?,
        companyId: Int?
    ) {

        mapper.updateOne(memberId, memberName, memberRank, companyId)
    }

    /** ユーザー削除(1件)  */
    override fun deleteMemberOne(memberId: Int?) {
        val count = mapper.deleteOne(memberId)
    }
}