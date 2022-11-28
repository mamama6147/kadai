package com.example.kadai.service

import com.example.kadai.model.Company
import com.example.kadai.model.Member

interface CompanyService {
    /** 会社登録  */
    fun insert(company: Company)

    /** 会社取得  */
    fun getCompanies(): List<Company>

    /** 会社取得（１件） */
    fun getCompanyOne(companyId: Int?): Company

    /** 会社更新(1件)  */
    fun updateCompanyOne(
        companyId: Int?,
        companyName: String?,
        companyAlias: String?
    )

    /** 会社削除(1件)  */
    fun deleteCompanyOne(companyId: Int?)
}