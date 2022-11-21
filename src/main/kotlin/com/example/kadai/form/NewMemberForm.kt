package com.example.kadai.form


import com.example.kadai.Data
import org.springframework.stereotype.Component
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Data
@Component
class NewMemberForm (
    @field:NotBlank
    var memberName: String?,

    @field:NotBlank
    var memberRank: String?,

    @field:NotNull
    var companyId: Int?

)