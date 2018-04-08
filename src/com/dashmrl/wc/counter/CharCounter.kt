package com.dashmrl.wc.counter

import java.io.File

/**
 * Author    dashmrl
 * Time      10:11
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
class CharCounter : Counter {
    override fun count(file: File): Int {
        println("start calculating char count")
        return file.readText().length
    }
}