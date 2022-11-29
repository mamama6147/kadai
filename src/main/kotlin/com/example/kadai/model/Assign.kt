package com.example.kadai.model

import com.example.kadai.Data
import org.springframework.stereotype.Component

@Component
@Data
class Assign {
    var memberId: Member?=null
    var projectId: Company?=null
    var stepNumber: Double?=null
}