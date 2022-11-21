package com.example.kadai.repository

import com.example.kadai.model.Member
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.SelectKey

@Mapper
interface MemberMapper {
    /** ユーザー登録  */
    @Insert("""
        INSERT INTO member(
          member_id
        , member_name
        , member_rank
        , company_id) VALUES(
          #{id}
        , #{memberName}
        , #{memberRank}
        , #{companyId}
        )
        """)
    @SelectKey(
        statement = [""],
        keyProperty = "id",
        before = false,
        resultType = Int::class)
    fun insertOne(member: Member): Int

    /** ユーザー取得　*/
    @Select("""
        select
        *
        from
        member
        left join companies
        on member.company_id=companies.company_id
    """)
    fun findMany(): List<Member>


}