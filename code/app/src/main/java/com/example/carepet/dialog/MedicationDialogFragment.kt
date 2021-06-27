package com.example.carepet.dialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.carepet.databinding.FragmentMedicationDialogBinding
import com.example.carepet.databinding.FragmentPetDialogBinding
import com.example.carepet.medication.MedicationAddFragmentDirections


class MedicationDialogFragment : Fragment() {


    private var _binding: FragmentMedicationDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMedicationDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.imageViewCompleted.setOnClickListener{
            it.findNavController().navigate(MedicationDialogFragmentDirections.actionMedicationDialogFragmentToDestinationMain())
        }

        binding.imageViewSnooze.setOnClickListener{
            it.findNavController().navigate(MedicationDialogFragmentDirections.actionMedicationDialogFragmentToDestinationMain())
        }

        binding.imageViewSkip.setOnClickListener{
            it.findNavController().navigate(MedicationDialogFragmentDirections.actionMedicationDialogFragmentToDestinationMain())
        }
    }

}