package com.dashmrl.wc.counter

import java.io.File

/**
 * Author    dashmrl
 * Time      09:58
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
class WordCounter : Counter {
    override fun count(file: File): Int {
        println("start calculating word count")
        return file.readLines().sumBy {
            it.split(
                    ' ', ',', '.',
                    ignoreCase = false,
                    limit = 0).filter { it.isNotEmpty() }.size
        }
    }
}