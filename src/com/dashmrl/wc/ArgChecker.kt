package com.dashmrl.wc

/**
 * Author    dashmrl
 * Time      10:16
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
class ArgChecker {
    fun check(pindex: Int, pc: Int, msg: String): Boolean {
        if (pindex <= -1) return false
        if (pindex + 1 == pc) {
            throw IllegalArgumentException(msg)
        }

        return true
    }

    fun checkOutputArg(oindex: Int, args: Array<String>): Boolean {
        val ofname = args[oindex + 1]
        if (Options.values().map { it.value }.contains(ofname)) {
            throw IllegalArgumentException("invalid output file name")
        }
        return true
    }
}