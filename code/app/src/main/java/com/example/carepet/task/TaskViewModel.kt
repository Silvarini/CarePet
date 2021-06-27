package com.example.carepet.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.carepet.model.Medication
import com.example.carepet.model.Task
import com.example.carepet.user.UserRepository
import kotlinx.coroutines.launch
import java.util.*

class TaskViewModel(
    private val repository: UserRepository
): ViewModel() {

    //Task Attributes
    var title: String = ""
    var initialHour: Int = 0
    var initialMinutes: Int = 0
    var finalHour: Int = 0
    var finalMinutes: Int = 0
    var day: Int = 0
    var month: Int = 0
    var year: Int = 0


    var dayWeek: String = ""

    fun insertOrUpdateTask(task: Task) = viewModelScope.launch {
        repository.insertOrUpdateTask(task)
    }

    val getAllTasks: LiveData<List<Task>> = repository.getAllTasks.asLiveData()


    ///////////////////////////////// DATE SELECTION /////////////////////////////////
    fun chosenDate(_day: Int, _month: Int, _year: Int){
        day = _day
        month = _month
        year = _year
    }


    ///////////////////////////////// TASK CREATION  /////////////////////////////////
    fun createNewTask(){
        val task = Task(0,title, day, month, year, initialHour, initialMinutes, finalHour, finalMinutes, "Incomplete",1)
        insertOrUpdateTask(task)
    }


    fun saveTitle(_title: String){
        title = _title
    }


    fun incrementInitialHour(): Int {
        return initialHour++
    }

    fun decrementInitialHour(): Int {
        if(initialHour >= 1){
            return initialHour--
        }else{
            return initialHour
        }
    }

    fun incrementInitialMinutes(): Int {
        return initialMinutes++
    }

    fun decrementInitialMinutes(): Int {
        if(initialMinutes >= 1){
            return initialMinutes--
        }else{
            return initialMinutes
        }
    }

    fun incrementFinalHour(): Int {
        return finalHour++
    }

    fun decrementFinalHour(): Int {
        if(finalHour >= 1){
            return finalHour--
        }else{
            return finalHour
        }
    }

    fun incrementFinalMinutes(): Int {
        return finalMinutes++
    }

    fun decrementFinalMinutes(): Int {
        if(finalMinutes >= 1){
            return finalMinutes--
        }else{
            return finalMinutes
        }
    }

}