package com.example.carepet.medication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.blue
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.carepet.databinding.FragmentMedicationAddTakingBinding
import com.example.carepet.user.UserApplication

class MedicationAddTaking: Fragment() {

    private var _binding: FragmentMedicationAddTakingBinding? = null
    private val binding get() = _binding!!

    private val medicationViewModel: MedicationViewModel by activityViewModels {
        MedicationViewModelFactory((requireActivity().application as UserApplication).repository)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMedicationAddTakingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonIncrementQuantity.setOnClickListener {
            medicationViewModel.incrementQuantity()
            binding.textViewQuantityValue.text = medicationViewModel.takingQuantity.toString()
        }

        binding.buttonDecrementQuantity.setOnClickListener {
            medicationViewModel.decrementQuantity()
            binding.textViewQuantityValue.text = medicationViewModel.takingQuantity.toString()
        }


        binding.buttonIncrementQuantityWeekly.setOnClickListener {
            medicationViewModel.incrementQuantityWeekly()
            binding.textViewQuantityValueWeekly.text = medicationViewModel.weeklyQuantity.toString()
        }

        binding.buttonDecrementQuantityWeekly.setOnClickListener {
            medicationViewModel.decrementQuantityWeekly()
            binding.textViewQuantityValueWeekly.text = medicationViewModel.weeklyQuantity.toString()
        }

        binding.buttonWeek.setOnClickListener {
            binding.textViewQuantityTitleWeekly.text = medicationViewModel.selectedWeekly()
        }

        binding.buttonMonth.setOnClickListener {
            binding.textViewQuantityTitleWeekly.text = medicationViewModel.selectedMonthly()
        }

        binding.buttonYear.setOnClickListener {
            binding.textViewQuantityTitleWeekly.text = medicationViewModel.selectedAnualy()
        }

        binding.buttonForever.setOnClickListener {
            binding.textViewQuantityTitleWeekly.text = medicationViewModel.selectedForever()
        }


        binding.buttonMonday.setOnClickListener {
            medicationViewModel.selectedMonday()
            if(medicationViewModel.monday)
                binding.buttonMonday.setBackgroundColor(0xff60a0e0.toInt())
            if(!medicationViewModel.monday)
                binding.buttonMonday.setBackgroundColor(Color.BLACK)
        }

        binding.buttonTuesday.setOnClickListener {
            medicationViewModel.selectedTuesday()
            if(medicationViewModel.tuesday)
                binding.buttonTuesday.setBackgroundColor(0xff60a0e0.toInt())
            if(!medicationViewModel.tuesday)
                binding.buttonTuesday.setBackgroundColor(Color.BLACK)
        }

        binding.buttonWednesday.setOnClickListener {
            medicationViewModel.selectedWednesday()
            if(medicationViewModel.wednesday)
                binding.buttonWednesday.setBackgroundColor(0xff60a0e0.toInt())
            if(!medicationViewModel.wednesday)
                binding.buttonWednesday.setBackgroundColor(Color.BLACK)
        }

        binding.buttonThursday.setOnClickListener {
            medicationViewModel.selectedThursday()
            if(medicationViewModel.thursday)
                binding.buttonThursday.setBackgroundColor(0xff60a0e0.toInt())
            if(!medicationViewModel.thursday)
                binding.buttonThursday.setBackgroundColor(Color.BLACK)
        }

        binding.buttonFriday.setOnClickListener {
            medicationViewModel.selectedFriday()
            if(medicationViewModel.friday)
                binding.buttonFriday.setBackgroundColor(0xff60a0e0.toInt())
            if(!medicationViewModel.friday)
                binding.buttonFriday.setBackgroundColor(Color.BLACK)
        }

        binding.buttonSaturday.setOnClickListener {
            medicationViewModel.selectedSaturday()
            if(medicationViewModel.saturday)
                binding.buttonSaturday.setBackgroundColor(0xff60a0e0.toInt())
            if(!medicationViewModel.saturday)
                binding.buttonSaturday.setBackgroundColor(Color.BLACK)
        }

        binding.buttonSunday.setOnClickListener {
            medicationViewModel.selectedSunday()
            if(medicationViewModel.sunday)
                binding.buttonSunday.setBackgroundColor(0xff60a0e0.toInt())
            if(!medicationViewModel.sunday)
                binding.buttonSunday.setBackgroundColor(Color.BLACK)
        }

    }


}