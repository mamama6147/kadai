package com.example.kadai.controller

import com.example.kadai.Data
import org.springframework.stereotype.Component

@Component
@Data
class RestResult (
    /** リターンコード  */
    private val result: Int?=0,
    /** エラーマップ
     * key: フィールド名
     * value: エラーメッセージ
     */
    private val errors: Map<String, String>?=null
)