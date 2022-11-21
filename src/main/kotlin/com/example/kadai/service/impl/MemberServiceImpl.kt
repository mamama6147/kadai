package com.example.kadai.service.impl

import com.example.kadai.model.Member
import com.example.kadai.repository.MemberMapper
import com.example.kadai.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(
    @Autowired private val mapper: MemberMapper
): MemberService{
    /** ユーザー登録  */
    override fun insert(member: Member) {

        mapper.insertOne(member)
    }

    /** ユーザー取得  */
    override fun getMembers(): List<Member> {
        return mapper.findMany()
    }
}