package com.dashmrl.wc.counter

import java.io.File

/**
 * Author    dashmrl
 * Time      10:12
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
class LineCounter : Counter {
    override fun count(file: File): Int {
        println("start calculating line count")
        return file.readLines().size
    }
}