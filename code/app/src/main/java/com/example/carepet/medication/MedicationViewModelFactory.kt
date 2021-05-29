package com.example.carepet.medication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carepet.model.User
import com.example.carepet.user.UserRepository
import com.example.carepet.user.UserViewModel
import java.lang.IllegalArgumentException

class MedicationViewModelFactory(
    private val repository: UserRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MedicationViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MedicationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}

