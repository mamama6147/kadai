package com.example.kadai.repository

import com.example.kadai.model.Company
import com.example.kadai.model.Member
import org.apache.ibatis.annotations.*

@Mapper
interface CompanyMapper {
    /** 会社登録  */
    @Insert("""
        INSERT INTO companies(
          company_name
        , company_alias
        ) VALUES(
          #{companyName}
        , #{companyAlias}
        )
        """)
    fun insertOne(company: Company): Int

    /** 会社取得　*/
    @Select("""
        <script>
            select
            *
            from
            companies
            <where>
                <if test="companyId != null">
                    company_id =#{companyId}
                </if>
                <if test="companyName != null">
                    and company_name like "%"#{companyName}"%"
                </if>
            </where>
        </script>
    """)
    @ResultMap("company")
    fun findMany(): List<Company>

    /** 会社取得　*/
    @Select("""
        select
        *
        from
        companies
        where
        company_id = #{memberId}
    """)
    @ResultMap("company")
    fun findOne(companyId: Int?): Company

    /** 会社更新(1件)  */
    @Update("""
        update
        companies
        set
          company_name = #{companyName}
        , company_alias = #{companyAlias}
        where
        company_id = #{companyId}
    """
    )
    @ResultMap("company")
    fun updateOne(
        @Param("companyId") companyId: Int?,
        @Param("companyName") companyName: String?,
        @Param("companyAlias") companyAlias: String?
    )

    /** ユーザー削除(1件)  */
    @Delete("""
        delete from
        companies
        where
        company_id = #{companyId}
    """)
    @ResultMap("company")
    fun deleteOne(@Param("companyId") companyId: Int?): Int
}