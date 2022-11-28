package com.example.kadai.repository

import com.example.kadai.model.Project
import org.apache.ibatis.annotations.*
import java.util.Date

@Mapper
interface ProjectMapper {

    /** プロジェクト登録  */
    @Insert(
        """
        INSERT INTO project(
          project_name
        , period_from
        , period_to
        ) VALUES(
          #{projectName}
        , #{periodFrom}
        , #{periodTo}
        )
        """
    )
    fun insertOne(project: Project): Int

    /** プロジェクト取得　*/
    @Select(
        """
            select
            *
            from
            project
    """
    )
    @ResultMap("project")
    fun findMany(): List<Project>

    /** プロジェクト取得　*/
    @Select(
        """
        select
        *
        from
        project
        where
        project_id = #{projectId}
    """
    )
    @ResultMap("project")
    fun findOne(projectId: Int?): Project

    /** プロジェクト更新(1件)  */
    @Update(
        """
        update
        project
        set
          project_name = #{projectName}
        , period_from = #{periodFrom}
        , period_to = #{periodTo}
        where
        project_id = #{projectId}
    """
    )
    @ResultMap("project")
    fun updateOne(
        @Param("projectId") projectId: Int?,
        @Param("projectName") projectName: String?,
        @Param("periodFrom") periodFrom: Date?,
        @Param("periodTo") periodTo: Date?
    )

    /** プロジェクト削除(1件)  */
    @Delete(
        """
        delete from
        project
        where
        project_id = #{projectId}
    """
    )
    @ResultMap("project")
    fun deleteOne(@Param("projectId") projectId: Int?): Int

}