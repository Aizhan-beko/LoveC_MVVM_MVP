package com.geeks.lovec_mvvm_mvp.MVVM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geeks.lovec_mvvm_mvp.R
import com.geeks.lovec_mvvm_mvp.databinding.FragmentLoveCalculatorBinding


class LoveCalculatorFragment : Fragment() {

    private var _binding: FragmentLoveCalculatorBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loveScore.observe(viewLifecycleOwner, { score ->
            binding.textViewResult.text = "Love Score: $score%"
        })

        binding.buttonCalculate.setOnClickListener {
            val person1 = binding.editTextPerson1.text.toString()
            val person2 = binding.editTextPerson2.text.toString()

            if (person1.isEmpty() || person2.isEmpty()) {
                binding.textViewResult.text = "Please enter names for both persons."
            } else {
                viewModel.calculateLovePercentage(person1, person2)
            }
            binding.btnDirection.setOnClickListener{
                findNavController().navigate(R.id.action_loveCalculatorFragment_to_loveCalculFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}