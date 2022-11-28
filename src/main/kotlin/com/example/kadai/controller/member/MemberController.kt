package com.example.kadai.controller.member

import com.example.kadai.KtLog
import com.example.kadai.form.member.MemberDetailForm
import com.example.kadai.form.member.MemberListForm
import com.example.kadai.form.member.MemberSearchForm
import com.example.kadai.form.member.NewMemberForm
import com.example.kadai.model.Member
import com.example.kadai.service.CompanyService
import com.example.kadai.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*


@Controller
@RequestMapping("/member")
class MemberController(
    @Autowired private val memberService: MemberService,
    @Autowired private val companyService: CompanyService
) {
    companion object {
        private val log by KtLog()
    }


    /** メンバー登録画面を表示  */
    @GetMapping("/new")
    fun getSignup(
        model: Model,
        locale: Locale,
        @ModelAttribute("newMemberForm") form: NewMemberForm
    ): String {
        val companyList = companyService.getCompanies()

        model.addAttribute("companyList", companyList)

        // ユーザー登録画面に遷移
        return "member/new"
    }

    /** メンバー検索画面を表示  */
    @GetMapping("/search")
    fun getSearchMember(
        model: Model,
        @ModelAttribute("memberSearchForm") form: MemberSearchForm
    ): String {
        // メンバー検索画面に遷移
        return "member/search"
    }

    /**ユーザー一覧画面を表示**/
    @GetMapping("/list")
    fun getMemberList(
        @ModelAttribute form: MemberListForm,
        model: Model): String {

        //formをMemberクラスに変換
        val member = Member()
        member.memberId = form.memberId
        member.memberName = form.memberName

        //ユーザー検索
        val memberList = memberService.getMembers(member)

        // Modelに登録
        model.addAttribute("memberList", memberList)

        return "member/list"
    }

    /** ユーザー詳細画面を表示  */
    @GetMapping("/{memberId:.+}")
    fun getUser(
        form: MemberDetailForm,
        model: Model,
        @PathVariable("memberId") memberId: Int
    ): String{
        // ユーザーを1件取得
        val member = memberService.getMemberOne(memberId)

        // Memberをformに変換
        val form = MemberDetailForm()
        form.memberId = member.memberId
        form.memberName = member.memberName
        form.memberRank = member.memberRank
        form.companyId = member.companyId
        form.company = member.company

        // Modelに登録
        model.addAttribute("memberDetailForm", member)

        val companyList = companyService.getCompanies()

        model.addAttribute("companyList", companyList)

        // ユーザー詳細画面を表示
        return "member/detail"
    }

}