package com.example.kadai.model

import com.example.kadai.Data
import org.springframework.stereotype.Component
import java.util.*

@Component
@Data
class Project {
    var projectId: Int?=null
    var projectName: String?=null
    var periodFrom: Date?=null
    var periodTo: Date?=null
}