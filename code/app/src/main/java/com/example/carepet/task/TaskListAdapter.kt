package com.example.carepet.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.carepet.databinding.FragmentTaskListItemBinding
import com.example.carepet.model.Task

class TaskListAdapter(
    private val fragment: Fragment
) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    private var tasks: List<Task> = listOf()

    class ViewHolder(view: FragmentTaskListItemBinding): RecyclerView.ViewHolder(view.root) {
        val taskTime = view.textViewTime
        val taskTitle = view.textViewTitle
        val taskDate = view.textViewDate
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListAdapter.ViewHolder {
        val binding: FragmentTaskListItemBinding = FragmentTaskListItemBinding.inflate(
            LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskListAdapter.ViewHolder, position: Int) {
        holder.taskTime.text = "${tasks[position].taskInitialHour}:${tasks[position].taskInitialMinutes}"
        holder.taskTitle.text = tasks[position].taskTitle
        holder.taskDate.text = "${tasks[position].taskDateDay}/${tasks[position].taskDateMonth}/${tasks[position].taskDateYear}"
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun tasksList(list: List<Task>){ //notify registered observes, let them know to adjust accordingly UI
        tasks = list
        notifyDataSetChanged()
    }
}