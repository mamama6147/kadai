package com.example.kadai.controller

import com.example.kadai.model.Member
import com.example.kadai.service.CompanyService
import com.example.kadai.service.MemberService
import com.example.kadai.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HomeController(
    @Autowired private val memberService: MemberService,
    @Autowired private val projectService: ProjectService,
) {
    /** ホーム画面を表示  */
    @GetMapping("/home")
    fun getLogin(): String {
        return "/home"
    }

    /**ホーム画面にリダイレクト**/
    @PostMapping("/home")
    fun postLogin():String{
        //ユーザー一覧画面を表示
        return "redirect:/home"
    }
    /** アサイン画面を表示 **/
    @GetMapping("/assign")
    fun getAssignList(
        model: Model,
        @ModelAttribute member: Member
    ): String {

        val memberList = memberService.getMembers(member)
        model.addAttribute("memberList", memberList)

        val projectList = projectService.getProjects()
        model.addAttribute("projectList", projectList)
        return "/assign"
    }
}