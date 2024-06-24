package com.geeks.lovec_mvvm_mvp.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoveViewModel : ViewModel() {

    private val _loveScore = MutableLiveData<Int>()
    val loveScore: LiveData<Int> get() = _loveScore

    fun calculateLovePercentage(person1: String, person2: String) {
        val score = calculateScore(person1, person2)
        _loveScore.value = score
    }

    private fun calculateScore(name1: String, name2: String): Int {
        val commonChars = name1.lowercase().toSet().intersect(name2.lowercase().toSet())
        val totalUniqueChars = (name1.lowercase().toSet().union(name2.lowercase().toSet())).size

        return if (totalUniqueChars == 0) {
            0
        } else {
            (commonChars.size * 100) / totalUniqueChars
        }
    }
}
