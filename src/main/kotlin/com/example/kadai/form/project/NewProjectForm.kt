package com.example.kadai.form.project

import com.example.kadai.Data
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Component
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Data
@Component
class NewProjectForm (
    @field:NotBlank
    var projectName: String?,

    @field:NotNull
    @field:DateTimeFormat(pattern = "yyyy/MM/dd")
    var periodFrom: Date?,

    @field:NotNull
    @field:DateTimeFormat(pattern = "yyyy/MM/dd")
    var periodTo: Date?

    )
