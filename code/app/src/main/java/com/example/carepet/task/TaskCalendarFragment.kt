package com.example.carepet.task

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carepet.MainFragmentDirections
import com.example.carepet.databinding.FragmentMedicationAddTakingBinding
import com.example.carepet.databinding.FragmentTaskCalendarBinding
import com.example.carepet.medication.MedicationAdapter
import com.example.carepet.medication.MedicationViewModel
import com.example.carepet.medication.MedicationViewModelFactory
import com.example.carepet.user.UserApplication
import java.util.*

class TaskCalendarFragment: Fragment()  {

    private val taskViewModel: TaskViewModel by activityViewModels {
        TaskViewModelFactory((requireActivity().application as UserApplication).repository)
    }

    private var _binding: FragmentTaskCalendarBinding? = null
    private val binding get() = _binding!!

    //Task Attributes
    var day: Int = 0
    var month: Int = 0
    var year: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleViewTasks.layoutManager = LinearLayoutManager(requireActivity())
        val taskAdapter = TaskListAdapter(this@TaskCalendarFragment)

        binding.recycleViewTasks.adapter = taskAdapter

        taskViewModel.getAllTasks.observe(viewLifecycleOwner) {
                tasks ->
            tasks.let{
                //if (it.isNotEmpty()){
                binding.recycleViewTasks.visibility = View.VISIBLE
                // mBinding.something.visibility = View.GONE -> for when the list is empty make UI
                taskAdapter.tasksList(it)
                // }else{
                //mBinding.rvMedicationList.visibility = View.GONE
                // mBinding.something.visibility = View.VISIBLE  -> for when the list is empty make UI
                //  }
            }
        }

        binding.calendarView.setOnDateChangeListener { p0, p1, p2, p3 ->
            Log.i(
                "DATESELECTED",
                "$p3.${p2 + 1}.$p1"
            )
            taskViewModel.chosenDate(p3, p2, p1)
        }
        binding.buttonNewTask.setOnClickListener{
            it.findNavController().navigate(TaskCalendarFragmentDirections.actionTaskCalendarFragmentToTaskCreateFragment())
        }
    }


}