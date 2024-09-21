package com.assnippet.unittestpractice.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class ParametrizedTest(val input: String, val expected: Boolean) {

    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isPalindrome(input)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: {0} is Palindrome = {1}")
        fun data(): List<Array<Any>>{
            return listOf(
                arrayOf("hello", false),
                arrayOf("racecar", true),
                arrayOf("r", true),
                arrayOf("", true),
            )
        }
    }
}