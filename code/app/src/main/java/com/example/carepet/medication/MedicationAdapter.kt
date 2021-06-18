package com.example.carepet.medication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carepet.R
import com.example.carepet.databinding.FragmentMedicationBinding
import com.example.carepet.model.Medication
import com.example.carepet.model.User
import com.example.carepet.model.relations.UserWithMedication

class MedicationAdapter(
        private val fragment: Fragment
        ) : RecyclerView.Adapter<MedicationAdapter.ViewHolder>() {

    private var medications: List<Medication> = listOf()

    class ViewHolder(view: FragmentMedicationBinding): RecyclerView.ViewHolder(view.root) {
        val medicationImage = view.imageViewMedication
        val medicationText = view.textViewMedication
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: FragmentMedicationBinding = FragmentMedicationBinding.inflate(
                LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(fragment)
                .load(medications[position].medicationPhoto)
                .into(holder.medicationImage);
        holder.medicationText.text = medications[position].medicationDailyRepetitions.toString() +" vezes por dia"
    }

    override fun getItemCount(): Int {
        return medications.size
    }

    fun medicationsList(list: List<Medication>){ //notify registered observes, let them know to adjust accordingly UI
        medications = list
        notifyDataSetChanged()
    }

}