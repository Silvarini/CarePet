package com.example.carepet.medication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carepet.R
import com.example.carepet.databinding.FragmentMedicationAddDosesBinding
import com.example.carepet.model.Medication
import com.example.carepet.user.UserApplication
import kotlinx.android.synthetic.main.fragment_medication_add_doses.view.*
import kotlinx.android.synthetic.main.fragment_medication_doses.view.*
import kotlinx.android.synthetic.main.fragment_medication_list.*

class MedicationAddDosesFragment : Fragment() {

    private var _binding: FragmentMedicationAddDosesBinding? = null
    private val binding get() = _binding!!

    private val medicationViewModel: MedicationViewModel by activityViewModels {
        MedicationViewModelFactory((requireActivity().application as UserApplication).repository)
    }


    val takingQuantity = medicationViewModel.takingQuantity

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMedicationAddDosesBinding.inflate(inflater, container, false)
        return binding.root.medication_add_doses_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = binding.listViewDoses
        listView.adapter = MyCustomAdapter(this.requireContext())

    }

     private class MyCustomAdapter(context: Context): BaseAdapter() {

        private val mContext: Context

        init{
            mContext = context
        }
        override fun getCount(): Int {
            return 2
        }

        override fun getItem(position: Int): Any {
            return position.toLong()
        }

        override fun getItemId(position: Int): Long {
            return 5
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.fragment_medication_doses, parent, false)
            return rowMain
        }

    }

}