package com.dashmrl.wc

import com.dashmrl.wc.counter.CharCounter
import com.dashmrl.wc.counter.LineCounter
import com.dashmrl.wc.counter.WordCounter
import java.io.File

/**
 * Author    dashmrl
 * Time      22:01
 * Date      15/03/2018
 * Email     xinliugm@gmail.com
 */

fun main(args: Array<String>) {
    val pc = args.size
    if (pc < 2) {
        throw IllegalArgumentException("at least two arguments required")
    }
    val checker = ArgChecker()
    var cc = -1
    var wc = -1
    var lc = -1
    val ifile = File(args[pc - 1])
    if (!ifile.exists() || ifile.isDirectory) {
        throw IllegalArgumentException("invalid input file(${ifile.absolutePath}),not exits or not a file")
    }
    for (value in Options.values()) {
        val index = args.indexOf(value.value)
        if (index == -1) {

            continue
        }
        when (value) {
            Options.C -> {
                checker.check(index, pc, "-c error")
                cc = CharCounter().count(ifile)
            }
            Options.W -> {
                checker.check(index, pc, "-w error")
                wc = WordCounter().count(ifile)
            }
            Options.L -> {
                checker.check(index, pc, "-l error")
                lc = LineCounter().count(ifile)
            }
            else -> {

            }
        }
    }
    val oindex = args.indexOf(Options.O.value)
    val of: File
    if (checker.check(oindex - 1, pc, "-c error")) {
        checker.checkOutputArg(oindex, args)
        of = File(args[oindex + 1])
    } else {
        of = File("result.txt")
    }
    FilePrinter().print(ifile.name, cc, wc, lc, of)
}



