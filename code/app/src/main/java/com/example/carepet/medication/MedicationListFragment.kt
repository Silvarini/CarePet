package com.example.carepet.medication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carepet.databinding.FragmentMedicationListBinding
import com.example.carepet.user.UserApplication
import kotlinx.android.synthetic.main.fragment_medication_list.*
import java.util.*

class MedicationListFragment: Fragment() {


    private val medicationViewModel: MedicationViewModel by viewModels {
        MedicationViewModelFactory((requireActivity().application as UserApplication).repository)
    }


    private var _binding: FragmentMedicationListBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedicationListBinding.inflate(inflater, container, false)

        binding.buttonNewMedication.setOnClickListener{
            it.findNavController().navigate(MedicationListFragmentDirections.actionMedicationListFragmentToMedicationAddFragment())
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMedicationList.layoutManager = LinearLayoutManager(requireActivity())
        val medicationAdapter = MedicationAdapter(this@MedicationListFragment)

        binding.rvMedicationList.adapter = medicationAdapter



        //procurar rvBinding... no video


        medicationViewModel.getAllMedication.observe(viewLifecycleOwner) {
            medications ->
                medications.let{
                    //if (it.isNotEmpty()){
                        binding.rvMedicationList.visibility = View.VISIBLE
                        // mBinding.something.visibility = View.GONE -> for when the list is empty make UI
                        medicationAdapter.medicationsList(it)
                   // }else{
                        //mBinding.rvMedicationList.visibility = View.GONE
                        // mBinding.something.visibility = View.VISIBLE  -> for when the list is empty make UI
                  //  }
            }
        }


    }

}