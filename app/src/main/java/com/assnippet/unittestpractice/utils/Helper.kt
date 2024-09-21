package com.assnippet.unittestpractice.utils

class Helper {
    fun isPalindrome(s: String): Boolean {
        if(s.length <= 1) return true

        for(i in 0 until s.length / 2) {
            if(s[i] != s[s.length - 1 - i]) return false
        }
        return true
    }
}