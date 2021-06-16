package com.example.carepet


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.carepet.R
import com.example.carepet.databinding.FragmentMainBinding
import com.example.carepet.medication.MedicationViewModel
import com.example.carepet.medication.MedicationViewModelFactory
import com.example.carepet.user.UserApplication
import com.example.carepet.user.UserViewModel
import com.example.carepet.user.UserViewModelFactory


class MainActivity : AppCompatActivity() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val userViewModel: UserViewModel by viewModels{
        UserViewModelFactory((application as UserApplication).repository)
    }

    private val medicationViewModel: MedicationViewModel by viewModels {
        MedicationViewModelFactory((application as UserApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }



}

