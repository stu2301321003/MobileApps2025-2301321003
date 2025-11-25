package com.example.tiptracker.data

class TipRepository(private val dao: TipDao) {

    val tips = dao.getAllTips()

    suspend fun addTip(amount: Double) {
        dao.insertTip(Tip(amount = amount))
    }
}
