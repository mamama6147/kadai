package com.example.kadai.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HomeController {
    /** ホーム画面を表示  */
    @GetMapping("/home")
    fun getLogin(): String {
        return "/home"
    }

    /**ホーム画面にリダイレクト**/
    @PostMapping("/home")
    fun postLogin():String{
        //ユーザー一覧画面を表示
        return "redirect:/home"
    }
}