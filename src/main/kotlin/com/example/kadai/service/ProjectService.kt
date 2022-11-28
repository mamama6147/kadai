package com.example.kadai.service

import com.example.kadai.model.Company
import com.example.kadai.model.Member
import com.example.kadai.model.Project
import java.util.*

interface ProjectService {
    /** プロジェクト登録  */
    fun insert(project: Project)

    /** プロジェクト取得  */
    fun getProjects(): List<Project>

    /** プロジェクト取得（１件） */
    fun getProjectOne(projectId: Int?): Project

    /** プロジェクト更新(1件)  */
    fun updateProjectOne(
        projectId: Int?,
        projectName: String?,
        periodFrom: Date?,
        periodTo: Date?
    )

    /** プロジェクト削除(1件)  */
    fun deleteProjectOne(projectId: Int?)
}