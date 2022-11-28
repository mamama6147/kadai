package com.example.kadai.repository

import com.example.kadai.model.Member
import org.apache.ibatis.annotations.*

@Mapper
interface MemberMapper {
    /** ユーザー登録  */
    @Insert("""
        INSERT INTO member(
          member_name
        , member_rank
        , company_id) VALUES(
          #{memberName}
        , #{memberRank}
        , #{companyId}
        )
        """)
    fun insertOne(member: Member): Int

    /** ユーザー取得　*/
    @Select("""
        <script>
            select
            *
            from
            member
            left join companies
            on member.company_id=companies.company_id
            <where>
                <if test="memberId != null">
                    member_id =#{memberId}
                </if>
                <if test="memberName != null">
                    and member_name like "%"#{memberName}"%"
                </if>
            </where>
        </script>
    """)
    @ResultMap("member")
    fun findMany(member: Member): List<Member>

    /** ユーザー取得　*/
    @Select("""
        select
        *
        from
        member
        left join companies
        on member.company_id=companies.company_id
        where
        member.member_id = #{memberId}
    """)
    @ResultMap("member")
    fun findOne(memberId: Int?): Member

    /** ユーザー更新(1件)  */
    @Update("""
        update
        member
        set
          member_name = #{memberName}
        , member_rank = #{memberRank}
        , company_id = #{companyId}
        where
        member_id = #{memberId}
    """
    )
    @ResultMap("member")
    fun updateOne(
        @Param("memberId") memberId: Int?,
        @Param("memberName") memberName: String?,
        @Param("memberRank") memberRank: String?,
        @Param("companyId") companyId: Int?
    )

    /** ユーザー削除(1件)  */
    @Delete("""
        delete from
        member
        where
        member_id = #{memberId}
    """)
    @ResultMap("member")
    fun deleteOne(@Param("memberId") memberId: Int?): Int
}