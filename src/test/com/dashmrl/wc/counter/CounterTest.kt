package test.com.dashmrl.wc.counter

import java.io.File

/**
 * Author    dashmrl
 * Time      10:32
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
open class CounterTest {
    protected val inputs = arrayOf(
            "Go is \n expressive, concise, clean, and efficient. Its concurrency mechanisms make it easy to write \n  programs that get the most out of multicore and networked machines, while its novel type system enables \n flexible and modular program construction. Go compiles quickly to machine",
            "Instructions for downloading and installing the Go compilers, tools, and libraries.",
            "An interactive introduction \n to Go in three sections",
            "The first section covers basic syntax and data structures",
            "with a few exercises so \n you can practice what you've learned",
            "Also available as a screencast, this \n doc explains how to use \n the go command to fetch, build, and install packages, commands",
            "A document that \n summarizes commonly \n used editor plug \n ins and IDEs with Go support",
            "A document that gives tips for writing clear, idiomatic Go code. A must \n read for any new Go programmer. It augments the tour and the language specification",
            "Summarizes tools and methodologies \n to diagnose problems in Go programs.",
            "A wiki maintained by the Go community.",
            "See the Learn page at the Wiki for more Go learning resources.",
            "The documentation for the Go standard library.",
            "document that \n specifies the conditions under \n which reads of a variable \n in one goroutine can be guaranteed to \n observe values produced by writes to the same",
            "official blog of the \n Go project, featuring news and \n in-depth articles by the Go team and guests.",
            "expressive, concise, clean, and efficient. Its concurrency mechanisms",
            "multicore and networked \n machines, while \n its novel type system",
            "compiled language that feels like a dynamically",
            "installing the Go compilers, tools,",
            "libraries",
            "and interfaces; and the \n third introduces Go's concurrency \n primitives. Each section concludes with \n a few exercises so you can practice"
    )

    protected fun createIntputFile(text:String,file:String): File {
        val of = File(file)
        of.writeText(text)
        return of
    }

}