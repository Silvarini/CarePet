package com.example.carepet.medication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carepet.databinding.FragmentMedicationListBinding
import com.example.carepet.model.Medication
import com.example.carepet.model.Weekdays
import com.example.carepet.user.UserApplication
import kotlinx.android.synthetic.main.fragment_medication_list.*
import java.util.*
import kotlin.math.log

class MedicationListFragment: Fragment() {


    private val medicationViewModel: MedicationViewModel by viewModels {
        MedicationViewModelFactory((requireActivity().application as UserApplication).repository)
    }

    private lateinit var mBinding : FragmentMedicationListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMedicationListBinding.inflate(inflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.rvMedicationList.layoutManager = LinearLayoutManager(requireActivity())
        val medicationAdapter = MedicationAdapter(this@MedicationListFragment)

        mBinding.rvMedicationList.adapter = medicationAdapter



        //procurar rvBinding... no video


        medicationViewModel.getAllMedication.observe(viewLifecycleOwner) {
            medications ->
                medications.let{
                    //if (it.isNotEmpty()){
                        mBinding.rvMedicationList.visibility = View.VISIBLE
                        // mBinding.something.visibility = View.GONE -> for when the list is empty make UI

                        Log.i("BATMAN",it.toString())
                        medicationAdapter.medicationsList(it)
                   // }else{
                        //mBinding.rvMedicationList.visibility = View.GONE
                        // mBinding.something.visibility = View.VISIBLE  -> for when the list is empty make UI
                  //  }
            }
        }


    }

}