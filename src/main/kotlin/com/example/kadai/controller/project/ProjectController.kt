package com.example.kadai.controller.project

import com.example.kadai.KtLog
import com.example.kadai.form.company.CompanyDetailForm
import com.example.kadai.form.company.NewCompanyForm
import com.example.kadai.form.member.MemberDetailForm
import com.example.kadai.form.project.NewProjectForm
import com.example.kadai.form.project.ProjectDetailForm
import com.example.kadai.model.Member
import com.example.kadai.service.CompanyService
import com.example.kadai.service.MemberService
import com.example.kadai.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
@RequestMapping("/project")
class ProjectController(
    @Autowired private val projectService: ProjectService
) {
    companion object {
        private val log by KtLog()
    }
    /** プロジェクト登録画面を表示  */
    @GetMapping("/new")
    fun getSignup(
        model: Model,
        locale: Locale,
        @ModelAttribute("newProjectForm") form: NewProjectForm
    ): String {
        // プロジェクト登録画面に遷移
        return "project/new"
    }

    /** プロジェクト一覧画面を表示 **/
    @GetMapping("/list")
    fun getProjectList(
        model: Model): String {

        //プロジェクト検索
        val projectList = projectService.getProjects()

        // Modelに登録
        model.addAttribute("projectList", projectList)

        return "project/list"
    }

    /** プロジェクト詳細画面を表示  */
    @GetMapping("/{projectId:.+}")
    fun getUser(
        form: ProjectDetailForm,
        model: Model,
        @PathVariable("projectId") projectId: Int
    ): String{
        // プロジェクトを1件取得
        val project = projectService.getProjectOne(projectId)

        // Projectをformに変換
        val form = ProjectDetailForm()
        form.projectId = project.projectId
        form.projectName = project.projectName
        form.periodFrom = project.periodFrom
        form.periodTo = project.periodTo

        // Modelに登録
        model.addAttribute("projectDetailForm", form)

        // プロジェクト詳細画面を表示
        return "project/detail"
    }

}