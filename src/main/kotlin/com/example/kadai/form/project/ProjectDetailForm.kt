package com.example.kadai.form.project

import com.example.kadai.Data
import org.springframework.stereotype.Component
import java.util.*

@Component
@Data
class ProjectDetailForm {
    var projectId: Int?=null
    var projectName: String?=null
    var periodFrom: Date?=null
    var periodTo: Date?=null
}
