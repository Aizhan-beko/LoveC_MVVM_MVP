package com.geeks.lovec_mvvm_mvp.MVP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.geeks.lovec_mvvm_mvp.R
import com.geeks.lovec_mvvm_mvp.databinding.FragmentLoveCalculBinding

class LoveCalculFragment : Fragment() , LoveCalculatorContract.View {

    private lateinit var binding: FragmentLoveCalculBinding
    private lateinit var presenter: LoveCalculatorContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveCalculBinding.inflate(inflater, container, false)
        presenter = LoveCalculatorPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculateBtn.setOnClickListener {
            val name1 = binding.name1Edit.text.toString()
            val name2 = binding.name2Edit.text.toString()
            presenter.calculateLove(name1, name2)
        }
    }

    override fun showResult(result: LoveResultModel) {
        binding.resultTextView.text = "Love Percentage: ${result.percentage}%\n${result.message}"
    }

    override fun showError(error: String) {
        binding.resultTextView.text = error
    }
}
