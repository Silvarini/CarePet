package com.example.carepet.medication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.carepet.databinding.FragmentMedicationAddDosesBinding
import com.example.carepet.user.UserApplication

class MedicationAddDosesFragment : Fragment() {

    private var _binding: FragmentMedicationAddDosesBinding? = null
    private val binding get() = _binding!!

    private val medicationViewModel: MedicationViewModel by activityViewModels {
        MedicationViewModelFactory((requireActivity().application as UserApplication).repository)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMedicationAddDosesBinding.inflate(inflater, container, false)
        return binding.root
    }


}