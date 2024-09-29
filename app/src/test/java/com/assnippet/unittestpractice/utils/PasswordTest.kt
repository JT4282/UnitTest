package com.assnippet.unittestpractice.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class PasswordTest(private val input: String, private val expected: Boolean) {
    @Test
    fun isPasswordValid() {
        val helper = Helper()
        val result = helper.validatePassword(input)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: {0} is Password Valid = {1}")
        fun data(): List<Array<Any>>{
            return listOf(
                arrayOf("          ", false),
                arrayOf("raceca", true),
                arrayOf("r", false),
                arrayOf("", false),
                arrayOf("123456@###", true),
                arrayOf("123456789qwertyu", false)
            )
        }
    }
}