package com.assnippet.unittestpractice

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Test(expected = FileNotFoundException::class)
    fun getQuotesFromAssets() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.getQuotesFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun getQuotesFromAssetsInvalidJSON() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.getQuotesFromAssets(context, "malformed.json")
    }

    @Test
    fun getQuotesFromAssetsValidJSON() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.getQuotesFromAssets(context, "quotes.json")
        assertEquals(10, quoteManager.quotesList.size)
    }

    @Test
    fun testPreviousQuote_expectedCorrectQuote(){
        val quoteManager = QuoteManager()
        quoteManager.populateQuote(arrayOf(
            Quote("hello first", "1"),
            Quote("hello second", "2"),
            Quote("hello third", "3"),
        ))

        val previousQuote = quoteManager.getPreviousQuote()

        assertEquals( "1", previousQuote.author)
    }

    @Test
    fun testNextQuote_expectedCorrectQuote(){
        val quoteManager = QuoteManager()
        quoteManager.populateQuote(arrayOf(
            Quote("hello first", "1"),
            Quote("hello second", "2"),
            Quote("hello third", "3"),
        ))

        val nextQuote = quoteManager.getNextQuote()

        assertEquals( "2", nextQuote.author)
    }
}