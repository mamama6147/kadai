package com.example.kadai.controller.member

import com.example.kadai.controller.RestResult
import com.example.kadai.form.member.MemberDetailForm
import com.example.kadai.form.member.MemberListForm
import com.example.kadai.form.member.NewMemberForm
import com.example.kadai.model.Member
import com.example.kadai.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/member")
class MemberRestController(
    @Autowired private val memberService: MemberService,
) {
    /** ユーザーを検索  */
    @GetMapping("/get/list")
    fun getUserList(form: MemberListForm): List<Member> {

        //formをMUserクラスに変換
        val member = Member()
        member.memberId = form.memberId
        member.memberName = form.memberName

        // ユーザー一覧取得
        return memberService.getMembers(member)
    }

    /** ユーザーを更新  */
    @PutMapping("/update")
    fun updateUser(form: MemberDetailForm): Int {
        // ユーザーを更新
        memberService.updateUserOne(
            form.memberId,
            form.memberName,
            form.memberRank,
            form.companyId
        )
        return 0
    }

    /** ユーザーを削除  */
    @DeleteMapping("/delete")
    fun deleteUser(form: MemberDetailForm): Int {
        // ユーザーを削除
        memberService.deleteMemberOne(form.memberId)
        return 0
    }

    /** ユーザーを登録  */
    @PostMapping("/new/rest")
    fun postInsert(
        form: NewMemberForm,
        bindingResult: BindingResult,
        locale: Locale
    ): RestResult {

//        // 入力チェック結果
//        if (bindingResult.hasErrors()) {
//            // チェック結果:NG
//            val errors = HashMap<String, String>()
//
//            // エラーメッセージ取得
//            for (error in bindingResult.fieldErrors) {
//                val message = messageSource.getMessage(error, locale)
//                errors[error.field] = message
//            }
//            // エラー結果の返却
//            return RestResult(90, errors)
//        }

        // formをMUserクラスに変換
        val member  = Member()
        member.memberName = form.memberName
        member.memberRank = form.memberRank
        member.companyId = form.companyId

        // ユーザー登録
        memberService.insert(member)

        // 結果の返却
        return RestResult(0, null)
    }
}