package com.dashmrl.wc

import java.io.File

/**
 * Author    dashmrl
 * Time      10:14
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
class FilePrinter {
    fun print(input: String, cc: Int, wc: Int, lc: Int, of: File){
        val sb = StringBuilder(input)
        if (cc != -1) {
            sb.append(",").append(Options.C.value).append(":").append(cc)
        }
        if (wc != -1) {
            sb.append(",").append(Options.W.value).append(":").append(wc)
        }
        if (lc != -1) {
            sb.append(",").append(Options.L.value).append(":").append(lc)
        }
        if (of.exists() && of.isFile) {
            of.delete()
        }

        println("write the result to ${of.absolutePath}")
        of.writeText(sb.toString())
    }
}