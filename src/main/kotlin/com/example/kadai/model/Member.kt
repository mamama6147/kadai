package com.example.kadai.model

import com.example.kadai.Data
import com.example.kadai.model.Company
import org.springframework.stereotype.Component

@Component
@Data
class Member {
    var memberId: Int?=null
    var memberName: String?=null
    var memberRank: String?=null
    var companyId: Int?=0
    var company: Company?=null
}
