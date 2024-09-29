package com.assnippet.unittestpractice.utils

import java.lang.StringBuilder

class Helper {
    fun isPalindrome(s: String): Boolean {
        if(s.length <= 1) return true

        for(i in 0 until s.length / 2) {
            if(s[i] != s[s.length - 1 - i]) return false
        }
        return true
    }

    fun validatePassword(s: String?) : Boolean {
        if (!s.isNullOrBlank()) {
            return !(s.length < 6 || s.length > 15)
        }
        return false
    }

    fun stringReverse(s: String?): String {
        if (s==null) {
            throw IllegalArgumentException("Input string cannot be null")
        }
        val chars = s.toCharArray()
        var start = 0
        var end = chars.size - 1
        while(start < end) {
            val temp = chars[start]
            chars[start] = chars[end]
            chars[end] = temp
            start++
            end--
        }
        return String(chars)
    }
}