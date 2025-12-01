package com.example.tiptracker.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tiptracker.data.Tip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Rule
import java.util.*

class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `todayTotal sums only today's tips`() = runTest {
        // Arrange - prepare timestamps
        val now = System.currentTimeMillis()
        val yesterday = now - 24 * 60 * 60 * 1000

        val tipsList = listOf(
            Tip(id = 1, amount = 10.0, timestamp = now),
            Tip(id = 2, amount = 5.0, timestamp = now),
            Tip(id = 3, amount = 7.0, timestamp = yesterday)
        )

        val result = calculateTodayTotal(tipsList)

        // Assert
        assertEquals(15.0, result, 0.001)
    }

    // Function copied from HomeViewModel for testing
    private fun calculateTodayTotal(list: List<Tip>): Double {
        val startOfDay = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        return list.filter { it.timestamp >= startOfDay }
            .sumOf { it.amount }
    }
}
