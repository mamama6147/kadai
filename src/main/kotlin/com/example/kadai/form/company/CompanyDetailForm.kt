package com.example.kadai.form.company

import com.example.kadai.Data
import org.springframework.stereotype.Component

@Component
@Data
class CompanyDetailForm {
    var companyId: Int?=null
    var companyName: String?=null
    var companyAlias: String?=null
}
