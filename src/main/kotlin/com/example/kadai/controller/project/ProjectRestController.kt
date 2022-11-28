package com.example.kadai.controller.project

import com.example.kadai.controller.RestResult
import com.example.kadai.form.company.CompanyDetailForm
import com.example.kadai.form.company.NewCompanyForm
import com.example.kadai.form.member.MemberDetailForm
import com.example.kadai.form.project.NewProjectForm
import com.example.kadai.form.project.ProjectDetailForm
import com.example.kadai.model.Company
import com.example.kadai.model.Project
import com.example.kadai.service.CompanyService
import com.example.kadai.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/project")
class ProjectRestController(
    @Autowired private val projectService: ProjectService
) {
    /** 会社を登録  */
    @PostMapping("/new/rest")
    fun postInsert(
        form: NewProjectForm,
    ): RestResult {

        // formをProjectクラスに変換
        val project  = Project()
        project.projectName = form.projectName
        project.periodFrom = form.periodFrom
        project.periodTo = form.periodTo

        // ユーザー登録
        projectService.insert(project)

        // 結果の返却
        return RestResult(0, null)
    }

    /** 会社を更新  */
    @PutMapping("/update")
    fun updateProject(form: ProjectDetailForm): Int {
        // ユーザーを更新
        projectService.updateProjectOne(
            form.projectId,
            form.projectName,
            form.periodFrom,
            form.periodTo
        )
        return 0
    }

    /** ユーザーを削除  */
    @DeleteMapping("/delete")
    fun deleteProject(form: ProjectDetailForm): Int {
        // ユーザーを削除
        projectService.deleteProjectOne(form.projectId)
        return 0
    }
}