package com.example.carepet.medication

import androidx.lifecycle.*
import com.example.carepet.enum.DurationTypes
import com.example.carepet.model.Doses
import com.example.carepet.model.Medication
import com.example.carepet.model.Weekdays
import com.example.carepet.user.UserRepository
import kotlinx.coroutines.launch

class MedicationViewModel(
    private val repository: UserRepository
): ViewModel() {


    //Medication Attributes
    var medicationId: Int = 0 // for the auto_increment to work, this needs to be 0
    var mImagePath: String = ""
    var takingQuantity = 1
    var medicationDurationType: String = DurationTypes.WEEKLY.duration
    var weeklyQuantity = 1
    var userId: Int = 1

    var lastMedicationId: Int = 0

    //Dose Attributes
    var doseQuantity: Int = 0
    var scheduleDoseHour: Int = 0
    var scheduleDoseMinutes: Int = 0

    var dosePosition: Int = 0

    //Weekdays
    var monday = false
    var tuesday = false
    var wednesday = false
    var thursday = false
    var friday = false
    var saturday = false
    var sunday = false


    ///////////////////////////////// DAO /////////////////////////////////
    fun insertOrUpdateMedication(medication: Medication) = viewModelScope.launch {
      repository.insertOrUpdateMedication(medication)
   }

    fun insertOrUpdateDoses(doses: Doses) = viewModelScope.launch {
        repository.insertOrUpdateDoses(doses)
    }

    val getAllMedication: LiveData<List<Medication>> = repository.getAllMedication.asLiveData()

    val getMedicationId: LiveData<Int> = repository.getMedicationId.asLiveData()

    ///////////////////////////////// MEDICATION CREATION SAVE /////////////////////////////////
    fun saveMedication(){
        val medication = Medication(0, mImagePath, takingQuantity, medicationDurationType, weeklyQuantity, confirmMedicationTaking(), 1)
        val doses = Doses(0, doseQuantity, scheduleDoseHour,scheduleDoseMinutes,lastMedicationId)
        insertOrUpdateMedication(medication)
        insertOrUpdateDoses(doses)
    }

    fun getLastMedicationId(id: Int){
        lastMedicationId = id + 1
    }




    ///////////////////////////////// MEDICATION CREATION TAKING /////////////////////////////////

    // MEDICATION IMAGE
    fun getMedicationImage(image: String){
        mImagePath = image
    }


    // DAILY REPETITIONS QUANTITY
     fun incrementQuantity(): Int {
         return takingQuantity++
    }


     fun decrementQuantity(): Int{
         if(takingQuantity >= 1){
             return takingQuantity--
         }else{
             return takingQuantity
         }
    }

    // DURATION TYPE
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

    fun getDurationType(durationType: String){
        medicationDurationType = durationType
    }


    // DURATION QUANTITY
    fun incrementQuantityWeekly(): Int{
        return weeklyQuantity++
    }

    fun decrementQuantityWeekly(): Int{
         if(weeklyQuantity >= 1){
            return weeklyQuantity--
         }else{
             return weeklyQuantity
         }
    }


    // WEEKDAYS
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

    // SAVE WEEKDAYS
    fun confirmMedicationTaking(): Weekdays {
        val weekdays = Weekdays(
                monday,
                tuesday,
                wednesday,
                thursday,
                friday,
                saturday,
                sunday
        )
        return weekdays
    }

    ///////////////////////////////// MEDICATION CREATION DOSES /////////////////////////////////

    // DOSE QUANTITY
    fun getDosePosition(position: Int){

    }

    fun getDoseQuantity(quantity: Int){
        doseQuantity = quantity
    }

    // DOSE SCHEDULE
    fun getDoseHour(hour: Int){
        scheduleDoseHour = hour
    }

    fun getDoseMinutes(minutes: Int){
        scheduleDoseMinutes = minutes
    }

}
