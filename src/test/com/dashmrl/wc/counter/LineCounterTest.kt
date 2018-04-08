package test.com.dashmrl.wc.counter

import com.dashmrl.wc.counter.LineCounter
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Author    dashmrl
 * Time      10:25
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
class LineCounterTest : CounterTest() {
    private val results = arrayOf(
            4,
            1,
            2,
            1,
            2,
            3,
            4,
            2,
            2,
            1,
            1,
            1,
            5,
            3,
            1,
            3,
            1,
            1,
            1,
            4)

    @Test
    fun count() {
        inputs.forEach {
            val c = LineCounter().count(createIntputFile(it, "inputs.txt"))
            assertEquals(results[inputs.indexOf(it)],c,"error,exit!!")
        }
    }
}