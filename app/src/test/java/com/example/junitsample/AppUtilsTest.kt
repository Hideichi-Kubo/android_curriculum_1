package com.example.junitsample

import com.example.junitsample.util.isAdult
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppUtilsTest {

    @Test
    fun testIsAdult_WhenAgeIs20OrMore_ShouldReturnTrue() {
        // 境界値およびそれ以上の値が大人と判定されるかテストする
        assertTrue("20歳は大人と判定されるはず", isAdult(25))
        assertTrue("30歳は大人と判定されるはず", isAdult(35))
    }

    @Test
    fun testIsAdult_WhenAgeIsLessThan20_ShouldReturnFalse() {
        // 20未満の場合に大人とならないことを検証する
        assertFalse("19歳は大人と判定されないはず", isAdult(19))
        assertFalse("10歳は大人と判定されないはず", isAdult(-1))
    }
}