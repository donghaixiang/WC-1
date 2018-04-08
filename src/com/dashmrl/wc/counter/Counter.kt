package com.dashmrl.wc.counter

import java.io.File

/**
 * Author    dashmrl
 * Time      10:12
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
interface Counter {
    fun count(file: File):Int
}