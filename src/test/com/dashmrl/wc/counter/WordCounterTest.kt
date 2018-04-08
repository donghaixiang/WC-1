package test.com.dashmrl.wc.counter

import com.dashmrl.wc.counter.WordCounter
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Author    dashmrl
 * Time      10:26
 * Date      2018/4/8
 * Email     xinliugm@gmail.com
 */
class WordCounterTest : CounterTest() {
    private val results = arrayOf(
            42,
            11,
            8,
            9,
            11,
            21,
            14,
            27,
            10,
            7,
            12,
            7,
            26,
            17,
            8,
            9,
            7,
            5,
            1,
            20
    )

    @Test
    fun count() {
        inputs.forEach {
            val c = WordCounter().count(createIntputFile(it, "input.txt"))
            assertEquals(results[inputs.indexOf(it)], c, "error,exit!!")
        }
    }
}