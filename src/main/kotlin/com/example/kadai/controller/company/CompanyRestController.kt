package com.example.kadai.controller.company

import com.example.kadai.controller.RestResult
import com.example.kadai.form.company.CompanyDetailForm
import com.example.kadai.form.company.NewCompanyForm
import com.example.kadai.form.member.MemberDetailForm
import com.example.kadai.model.Company
import com.example.kadai.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/company")
class CompanyRestController(
    @Autowired private val companyService: CompanyService
) {
    /** 会社を登録  */
    @PostMapping("/new/rest")
    fun postInsert(
        form: NewCompanyForm,
    ): RestResult {

        // formをCompanyクラスに変換
        val company  = Company()
        company.companyName = form.companyName
        company.companyAlias = form.companyAlias

        // ユーザー登録
        companyService.insert(company)

        // 結果の返却
        return RestResult(0, null)
    }

    /** 会社を更新  */
    @PutMapping("/update")
    fun updateCompany(form: CompanyDetailForm): Int {
        // ユーザーを更新
        companyService.updateCompanyOne(
            form.companyId,
            form.companyName,
            form.companyAlias
        )
        return 0
    }

    /** ユーザーを削除  */
    @DeleteMapping("/delete")
    fun deleteCompany(form: CompanyDetailForm): Int {
        // ユーザーを削除
        companyService.deleteCompanyOne(form.companyId)
        return 0
    }
}