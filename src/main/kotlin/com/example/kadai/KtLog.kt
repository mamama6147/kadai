package com.example.kadai

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import kotlin.reflect.KProperty

class KtLog {
    var log: Logger? = null

    operator fun getValue(thisRef:Any,property: KProperty<*>): Logger {
        return log?: LogManager.getLogger(thisRef.javaClass.name.let {
            val matchIndex = it.length - 10
            when (it.lastIndexOf("\$Companion")) {
                matchIndex -> it.substring(0, matchIndex)
                else -> it
            }
        }).apply { this@KtLog.log = this }
    }
}