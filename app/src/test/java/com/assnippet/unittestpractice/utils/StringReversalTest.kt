package com.assnippet.unittestpractice.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class StringReversalTest(val input: String, val expected: String) {

    @Test
    fun stringReverse() {
        val helper = Helper()
        val result = helper.stringReverse(input)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: {0} is reversed = {1}")
        fun data(): List<Array<Any>>{
            return listOf(
                arrayOf("hello", "olleh"),
                arrayOf("racecar", "racecar"),
                arrayOf("r", "r"),
                arrayOf("", ""),
                arrayOf("123_456789", "987654_321")
            )
        }
    }
}

class StringReversalTestExceptionHandler{
    @Test(expected = IllegalArgumentException::class)
    fun stringReversal_nullValue_expectedException() {
        val helper = Helper()
        val result = helper.stringReverse(null)
    }
}