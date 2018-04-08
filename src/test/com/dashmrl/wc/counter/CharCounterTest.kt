package test.com.dashmrl.wc.counter

import com.dashmrl.wc.counter.CharCounter
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

/**
 * Author    dashmrl
 * Time      10:25
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
class CharCounterTest : CounterTest() {
    private val results = arrayOf(
            282,
            83,
            53,
            57,
            62,
            127,
            87,
            157,
            73,
            38,
            62,
            46,
            162,
            100,
            69,
            65,
            47,
            35,
            9,
            139
    )

    @Test
    fun count() {
        inputs.forEach {
            val c = CharCounter().count(createIntputFile(it, "input.txt"))
            assertEquals(results[inputs.indexOf(it)],c,"not equals,exit!!")
        }
    }
}