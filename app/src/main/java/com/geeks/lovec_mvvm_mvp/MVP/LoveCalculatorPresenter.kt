package com.geeks.lovec_mvvm_mvp.MVP

class LoveCalculatorPresenter (private val view: LoveCalculatorContract.View) : LoveCalculatorContract.Presenter {

    override fun calculateLove(name1: String, name2: String) {
        if (name1.isBlank() || name2.isBlank()) {
            view.showError("Both names must be provided")
            return
        }

        val percentage = (name1.length + name2.length) * 5 % 100
        val message = when {
            percentage > 80 -> "You are made for each other!"
            percentage > 50 -> "You have a good chance!"
            percentage > 30 -> "There might be some challenges!"
            else -> "It might be tough!"
        }

        val result = LoveResultModel(percentage, message)
        view.showResult(result)
    }
}
