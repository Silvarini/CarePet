package com.example.carepet.medication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.carepet.databinding.FragmentMedicationAddDosesBinding
import com.example.carepet.model.Medication
import com.example.carepet.user.UserApplication
import kotlinx.android.synthetic.main.fragment_medication_doses.view.*


class MedicationAddDosesAdapter()
 /*       private val fragment: Fragment
        ) : RecyclerView.Adapter<MedicationAddDosesAdapter.ViewHolder>() {

    private val takingQuantity = 0

    //private var medications: List<> = listOf()


    class ViewHolder(view:FragmentMedicationAddDosesBinding): RecyclerView.ViewHolder(view.root) {
        val buttonDecrement = view.medicationDosesFragment.button_decrement_quantity!!
        val buttonIncrement = view.medicationDosesFragment.button_increment_quantity!!
        val textViewQuantity = view.recycleViewMedicationDoses.textView_quantity_value!!
        val buttonDecrementHour = view.medicationDosesFragment.button_decrement_hours!!
        val buttonIncrementHour = view.medicationDosesFragment.button_increment_hours!!
        val buttonDecrementMinutes = view.medicationDosesFragment.button_decrement_minutes!!
        val buttonIncrementMinutes = view.medicationDosesFragment.button_increment_minutes!!
        val textViewHours = view.medicationDosesFragment.textView_schedule_hours_value!!
        val textViewMinutes = view.medicationDosesFragment.textView_schedule_minutes_value!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: FragmentMedicationAddDosesBinding = FragmentMedicationAddDosesBinding.inflate(
                LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 2
    }



*/
//}