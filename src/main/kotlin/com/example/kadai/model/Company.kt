package com.example.kadai.model

import com.example.kadai.Data
import org.springframework.stereotype.Component

@Component
@Data
class Company {
    var companyId: Int?=0
    var companyName: String?=null
    var companyAlias: String?=null
}