package com.example.carepet.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.carepet.databinding.FragmentTaskCalendarBinding
import com.example.carepet.databinding.FragmentTaskCreateBinding
import com.example.carepet.medication.MedicationListFragmentDirections
import com.example.carepet.user.UserApplication


class TaskCreateFragment : Fragment() {

    private val taskViewModel: TaskViewModel by activityViewModels {
        TaskViewModelFactory((requireActivity().application as UserApplication).repository)
    }

    private var _binding: FragmentTaskCreateBinding? = null
    private val binding get() = _binding!!

    //Task Attributes
    var title: String = ""
    var initialHour: Int = 0
    var initialMinutes: Int = 0
    var finalHour: Int = 0
    var finalMinutes: Int = 0

    //Date Attributes
    var day: Int = 0
    var month: Int = 0
    var year: Int = 0
    var dayWeek: String = ""
    var finalDay: Int = 0
    var finalMonth: Int = 0
    var finalYear: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentTaskCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTextViewInitialSchedule()

        binding.buttonIncrementInitialHours.setOnClickListener{
            taskViewModel.incrementInitialHour()
            binding.textViewScheduleInitialHoursValue.text = taskViewModel.initialHour.toString()
        }

        binding.buttonDecrementInitialHours.setOnClickListener{
            taskViewModel.decrementInitialHour()
            binding.textViewScheduleInitialHoursValue.text = taskViewModel.initialHour.toString()
        }

        binding.buttonIncrementInitialMinutes.setOnClickListener{
            taskViewModel.incrementInitialMinutes()
            binding.textViewScheduleInitialMinutesValue.text = taskViewModel.initialMinutes.toString()
        }

        binding.buttonDecrementInitialMinutes.setOnClickListener{
            taskViewModel.decrementInitialMinutes()
            binding.textViewScheduleInitialMinutesValue.text = taskViewModel.initialMinutes.toString()
        }

        binding.buttonIncrementFinalHours.setOnClickListener{
            taskViewModel.incrementFinalHour()
            binding.textViewScheduleFinalHoursValue.text = taskViewModel.finalHour.toString()
        }

        binding.buttonDecrementFinalHours.setOnClickListener{
            taskViewModel.decrementFinalHour()
            binding.textViewScheduleFinalHoursValue.text = taskViewModel.finalHour.toString()
        }

        binding.buttonIncrementFinalMinutes.setOnClickListener{
            taskViewModel.incrementFinalMinutes()
            binding.textViewScheduleFinalMinutesValue.text = taskViewModel.finalMinutes.toString()
        }

        binding.buttonDecrementFinalMinutes.setOnClickListener{
            taskViewModel.decrementFinalMinutes()
            binding.textViewScheduleFinalMinutesValue.text = taskViewModel.finalMinutes.toString()
        }

        binding.buttonConfirmNewTask.setOnClickListener{
            title = binding.inputTitle.text.toString()
            taskViewModel.saveTitle(title)
            taskViewModel.createNewTask()
            it.findNavController().navigate(TaskCreateFragmentDirections.actionTaskCreateFragmentToDestinationMain())
        }
    }

    fun initTextViewInitialSchedule(){
        day = taskViewModel.day
        month = taskViewModel.month
        year = taskViewModel.year
        dayWeek = taskViewModel.dayWeek
        binding.textViewInitialScheduleTitle.text = "Inicio: $day/$month/$year"
    }

}