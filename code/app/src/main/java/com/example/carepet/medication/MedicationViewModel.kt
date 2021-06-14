package com.example.carepet.medication

import android.util.Log
import androidx.lifecycle.*
import com.example.carepet.enum.DurationTypes
import com.example.carepet.model.Medication
import com.example.carepet.model.User
import com.example.carepet.model.Weekdays
import com.example.carepet.model.relations.UserWithMedication
import com.example.carepet.user.UserRepository
import kotlinx.coroutines.launch

class MedicationViewModel(
    private val repository: UserRepository
): ViewModel() {

    var takingQuantity = 1
    var weeklyQuantity = 1
    var monday = false
    var tuesday = false
    var wednesday = false
    var thursday = false
    var friday = false
    var saturday = false
    var sunday = false

    var textViewDoseQuantity = ""
    var textViewSchedule = ""
    var doseQuantityValue = 0
    var doseScheduleValue = 0


    fun insertOrUpdateMedication(medication: Medication) = viewModelScope.launch {
      repository.insertOrUpdateMedication(medication)
   }

    val getAllMedication: LiveData<List<Medication>> = repository.getAllMedication.asLiveData()


     fun incrementQuantity(): Int {
         return takingQuantity++
    }

     fun incrementQuantityWeekly(): Int{
         return weeklyQuantity++
     }

     fun decrementQuantity(): Int{
         if(takingQuantity >= 1){
             return takingQuantity--
         }else{
             return takingQuantity
         }
    }

     fun decrementQuantityWeekly(): Int{
         if(weeklyQuantity >= 1){
            return weeklyQuantity--
         }else{
             return weeklyQuantity
         }
    }

    fun selectedWeekly():String{
        return DurationTypes.WEEKLY.duration
    }

    fun selectedMonthly():String{
        return DurationTypes.MONTHLY.duration
    }

    fun selectedAnualy():String{
    return DurationTypes.ANUALY.duration
    }

    fun selectedForever():String{
    return DurationTypes.FOREVER.duration
    }



    fun selectedMonday(){
        monday = !monday
    }


    fun selectedTuesday(){
        tuesday = !tuesday
    }


    fun selectedWednesday(){
        wednesday = !wednesday
    }


    fun selectedThursday() {
        thursday = !thursday
    }


    fun selectedFriday(){
        friday = !friday
    }


    fun selectedSaturday(){
        saturday = !saturday
    }


    fun selectedSunday(){
        sunday = !sunday
    }



    fun confirmMedicationTaking() {
        val weekdays: Weekdays = Weekdays(
                monday,
                tuesday,
                wednesday,
                thursday,
                friday,
                saturday,
                sunday
        )
        Log.i("WWWWWEEEEKDAY", "WEEEEEK : $weekdays")
    }


    fun incrementDose(doseQuantity: Int): Int{
        var aux = doseQuantity
        return aux++
    }

    fun decrementDose(doseQuantity: Int): Int{
        var aux = doseQuantity
        return aux--
    }




}
