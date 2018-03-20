import java.io.File
import java.util.*

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
                checkArgs(index, pc, "-c error")
                cc = calCharCount(ifile)
            }
            Options.W -> {
                checkArgs(index, pc, "-w error")
                wc = calWordCount(ifile)
            }
            Options.L -> {
                checkArgs(index, pc, "-l error")
                lc = calLineCount(ifile)
            }
            else -> {

            }
        }
    }
    val oindex = args.indexOf(Options.O.value)
    val of: File
    if (checkArgs(oindex - 1, pc, "-c error")) {
        checkOutputArg(oindex, args)
        of = File(args[oindex + 1])
    } else {
        of = File("result.txt")
    }
    outputResult(ifile.name, cc, wc, lc, of)
}

fun checkArgs(pindex: Int, pc: Int, msg: String): Boolean {
    if (pindex <= -1) return false
    if (pindex + 1 == pc) {
        throw IllegalArgumentException(msg)
    }

    return true
}

fun checkOutputArg(oindex: Int, args: Array<String>) {
    val ofname = args[oindex + 1]
    if (Options.values().map { it.value }.contains(ofname)) {
        throw IllegalArgumentException("invalid output file name")
    }
}

fun calCharCount(ifile: File): Int {
    println("start calculating char count")
    return ifile.readText().length
}

fun calWordCount(ifile: File): Int {
    println("start calculating word count")
    return ifile.readLines().sumBy {
        it.split(
                ' ', ',', '.',
                ignoreCase = false,
                limit = 0).filter { it.isNotEmpty() }.size
    }
}

fun calLineCount(ifile: File): Int {
    println("start calculating line count")
    return ifile.readLines().size
}

fun outputResult(input: String, cc: Int, wc: Int, lc: Int, of: File) {
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