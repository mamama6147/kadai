package com.example.kadai.service.impl


import com.example.kadai.model.Project
import com.example.kadai.repository.ProjectMapper
import com.example.kadai.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjectServiceImpl(
    @Autowired private val mapper: ProjectMapper
) : ProjectService {
    /** プロジェクト登録  */
    override fun insert(project: Project) {

        mapper.insertOne(project)
    }
    /** プロジェクト取得  */
    override fun getProjects(): List<Project> {
        return mapper.findMany()
    }

    /** プロジェクト取得（１件） */
    override fun getProjectOne(projectId: Int?): Project {
        return mapper.findOne(projectId)
    }

    /** プロジェクト更新（１件） */
    override fun updateProjectOne(
        projectId: Int?,
        projectName: String?,
        periodFrom: Date?,
        periodTo: Date?
    ){
        mapper.updateOne(projectId, projectName, periodFrom,periodTo)
    }

    /** プロジェクト削除（１件） */
    override fun deleteProjectOne(projectId: Int?) {
        val count = mapper.deleteOne(projectId)
    }

}