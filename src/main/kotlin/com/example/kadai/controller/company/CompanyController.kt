package com.example.kadai.controller.company

import com.example.kadai.KtLog
import com.example.kadai.form.company.CompanyDetailForm
import com.example.kadai.form.company.NewCompanyForm
import com.example.kadai.form.member.MemberDetailForm
import com.example.kadai.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
@RequestMapping("/company")
class CompanyController(
    @Autowired private val companyService: CompanyService
) {
    companion object {
        private val log by KtLog()
    }
    /** 会社登録画面を表示  */
    @GetMapping("/new")
    fun getSignup(
        model: Model,
        locale: Locale,
        @ModelAttribute("newCompanyForm") form: NewCompanyForm
    ): String {
        // 会社登録画面に遷移
        return "company/new"
    }

    /** 所属会社一覧画面を表示 **/
    @GetMapping("/list")
    fun getCompanyList(
        model: Model): String {

        //ユーザー検索
        val companyList = companyService.getCompanies()

        // Modelに登録
        model.addAttribute("companyList", companyList)

        return "company/list"
    }

    /** ユーザー詳細画面を表示  */
    @GetMapping("/{companyId:.+}")
    fun getUser(
        form: CompanyDetailForm,
        model: Model,
        @PathVariable("companyId") companyId: Int
    ): String{
        // ユーザーを1件取得
        val company = companyService.getCompanyOne(companyId)

        // Memberをformに変換
        val form = CompanyDetailForm()
        form.companyId = company.companyId
        form.companyName = company.companyName
        form.companyAlias = company.companyAlias

        // Modelに登録
        model.addAttribute("companyDetailForm", form)

        // ユーザー詳細画面を表示
        return "company/detail"
    }




}