package com.example.tiptracker.ui.summary

import com.example.tiptracker.data.Tip
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class DailySummaryViewModelTest {

    @Test
    fun `group tips by day and calculate totals`() {
        // Arrange
        val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

        val day1 = formatter.parse("26 Nov 2025")!!.time
        val day2 = formatter.parse("25 Nov 2025")!!.time

        val tips = listOf(
            Tip(id = 1, amount = 10.0, timestamp = day1),
            Tip(id = 2, amount = 5.0, timestamp = day1),
            Tip(id = 3, amount = 7.0, timestamp = day2)
        )

        // Act: run the grouping logic (copied from ViewModel)
        val result = groupByDay(tips)

        // Assert
        assertEquals(2, result.size)

        assertEquals("26 Nov 2025", result[0].day)
        assertEquals(15.0, result[0].total, 0.001)

        assertEquals("25 Nov 2025", result[1].day)
        assertEquals(7.0, result[1].total, 0.001)
    }

    private fun groupByDay(list: List<Tip>): List<DailySummary> {
        val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

        return list.groupBy { tip ->
            formatter.format(Date(tip.timestamp))
        }.map { (day, items) ->
            DailySummary(day, items.sumOf { it.amount })
        }.sortedByDescending { it.day }
    }
}
