package com.example.kadai.form.member

import com.example.kadai.Data
import org.springframework.stereotype.Component

@Component
@Data
data class MemberListForm (
    var memberId: Int?,
    var memberName: String?
)