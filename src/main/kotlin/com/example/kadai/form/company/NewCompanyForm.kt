package com.example.kadai.form.company

import com.example.kadai.Data
import org.springframework.stereotype.Component
import javax.validation.constraints.NotBlank

@Data
@Component
class NewCompanyForm (
    @field:NotBlank
    var companyName: String?,

    @field:NotBlank
    var companyAlias: String?,

    )
