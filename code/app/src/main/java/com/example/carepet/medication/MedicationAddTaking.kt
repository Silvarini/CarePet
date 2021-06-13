package com.example.carepet.medication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        }

        binding.buttonTuesday.setOnClickListener {
            medicationViewModel.selectedTuesday()
        }

        binding.buttonWednesday.setOnClickListener {
            medicationViewModel.selectedWednesday()
        }

        binding.buttonThursday.setOnClickListener {
            medicationViewModel.selectedThursday()
        }

        binding.buttonFriday.setOnClickListener {
            medicationViewModel.selectedFriday()
        }

        binding.buttonSaturday.setOnClickListener {
            medicationViewModel.selectedSaturday()
        }

        binding.buttonSunday.setOnClickListener {
            medicationViewModel.selectedSunday()
            Log.i("CLIIICK", "CLIKSSKS")
        }

    }


}