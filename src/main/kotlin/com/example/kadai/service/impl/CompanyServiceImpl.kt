package com.example.kadai.service.impl

import com.example.kadai.model.Company
import com.example.kadai.model.Member
import com.example.kadai.repository.CompanyMapper
import com.example.kadai.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl(
    @Autowired private val mapper: CompanyMapper
) : CompanyService {
    /** 会社登録  */
    override fun insert(company: Company) {

        mapper.insertOne(company)
    }
    /** 会社取得  */
    override fun getCompanies(): List<Company> {
        return mapper.findMany()
    }

    /** 会社取得（１件） */
    override fun getCompanyOne(companyId: Int?): Company {
        return mapper.findOne(companyId)
    }

    /** 会社更新（１件） */
    override fun updateCompanyOne(
        companyId: Int?,
        companyName: String?,
        companyAlias: String?
    ){
        mapper.updateOne(companyId, companyName, companyAlias)
    }

    /** ユーザー削除（１件） */
    override fun deleteCompanyOne(companyId: Int?) {
        val count = mapper.deleteOne(companyId)
    }

}