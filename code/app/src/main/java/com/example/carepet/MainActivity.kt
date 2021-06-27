package com.example.carepet


import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.carepet.R
import com.example.carepet.databinding.FragmentMainBinding
import com.example.carepet.dialog.AlarmReceiver
import com.example.carepet.medication.MedicationViewModel
import com.example.carepet.medication.MedicationViewModelFactory
import com.example.carepet.task.TaskViewModel
import com.example.carepet.task.TaskViewModelFactory
import com.example.carepet.user.UserApplication
import com.example.carepet.user.UserRepository
import com.example.carepet.user.UserViewModel
import com.example.carepet.user.UserViewModelFactory
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds


class MainActivity : AppCompatActivity() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    private val userViewModel: UserViewModel by viewModels{
        UserViewModelFactory((application as UserApplication).repository)
    }

    private val medicationViewModel: MedicationViewModel by viewModels {
        MedicationViewModelFactory((application as UserApplication).repository)
    }

    private val taskViewModel: TaskViewModel by viewModels{
        TaskViewModelFactory((application as UserApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }






}

