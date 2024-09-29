package com.assnippet.unittestpractice

import android.content.Context
import com.google.gson.Gson

class QuoteManager {

    var quotesList = emptyArray<Quote>()
    var currentQuoteIndex = 0

    fun getQuotesFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        quotesList = Gson().fromJson(json, Array<Quote>::class.java)
    }

    fun populateQuote(quotes: Array<Quote>) {
        quotesList = quotes
    }

    fun getCurrentQuote(): Quote {
        return quotesList[currentQuoteIndex]
    }

    fun getNextQuote(): Quote {
        if (currentQuoteIndex == quotesList.size - 1) return quotesList[currentQuoteIndex]
        return quotesList[++currentQuoteIndex]
    }

    fun getPreviousQuote(): Quote {
        if (currentQuoteIndex == 0) return quotesList[currentQuoteIndex]
        return quotesList[--currentQuoteIndex]
    }
}