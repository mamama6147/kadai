package com.example.kadai.controller

import com.example.kadai.KtLog
import com.example.kadai.form.NewMemberForm
import com.example.kadai.model.Member
import com.example.kadai.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*


@Controller
@RequestMapping("/member")
class MemberController(
    @Autowired private val memberService: MemberService
) {
    companion object {
        private val log by KtLog()
    }


        /** member登録画面を表示  */
    @GetMapping("/new")
    fun getSignup(
        model: Model,
        locale: Locale,
        @ModelAttribute("newMemberForm") form: NewMemberForm
    ): String {
        // ユーザー登録画面に遷移
        return "member/new"
    }

    /** ユーザー登録処理  */
    @PostMapping("/new")
    fun postSignup(
        model: Model,
        locale: Locale,
        @ModelAttribute  form: NewMemberForm,
        bindingResult: BindingResult
    ): String {

        // 入力チェック結果
        if (bindingResult.hasErrors()) {
            // NG:ユーザー登録画面に戻ります
            return getSignup(model, locale, form)
        }

        log.info(form.toString())

        // formをMemberクラスに変換
        val member  = Member()
        member.memberName = form.memberName
        member.memberRank = form.memberRank
        member.companyId = form.companyId

        // 登録
        memberService.insert(member)

        // ホーム画面にリダイレクト
        return "redirect:/home"
    }

    /**ユーザー一覧画面を表示**/
    @GetMapping("/list")
    fun getMemberList(model: Model): String {

        //ユーザー検索
        val memberList = memberService.getMembers()

        // Modelに登録
        model.addAttribute("memberList", memberList)

        return "member/list"
    }

}