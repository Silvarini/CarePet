package com.example.carepet.medication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.carepet.model.Medication
import com.example.carepet.model.User
import com.example.carepet.model.relations.UserWithMedication
import com.example.carepet.user.UserRepository
import kotlinx.coroutines.launch

class MedicationViewModel(
    private val repository: UserRepository
): ViewModel() {

    fun insertOrUpdateMedication(medication: Medication) = viewModelScope.launch {
      repository.insertOrUpdateMedication(medication)
   }

    val getAllMedication: LiveData<List<UserWithMedication>> = repository.getAllMedication.asLiveData()

}