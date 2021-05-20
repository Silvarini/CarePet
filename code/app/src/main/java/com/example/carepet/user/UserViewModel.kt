package com.example.carepet.user

import android.app.Application
import androidx.lifecycle.*
import com.example.carepet.enum.AffectionLevelEnum
import com.example.carepet.enum.AffectionLevelEnum.*
import com.example.carepet.model.User
import kotlinx.coroutines.launch


class UserViewModel(
        private val repository: UserRepository
): ViewModel() {

    fun insertOrUpdateUser(user: User) = viewModelScope.launch {
        repository.insertOrUpdateUser(user)
    }

    val getAllUserData: LiveData<List<User>> = repository.getAllUserData.asLiveData()



     fun calculateAffectionScore(petting_score : Int, task_score: Int): AffectionLevelEnum {
        val affectionLevel = petting_score + task_score

        if (affectionLevel <= 20){ return ONE
        }else if(affectionLevel in 21..50){ return TWO
        }else{ return THREE }
    }

     fun choosePettingMessage(affectionLevel: AffectionLevelEnum): String{
        var message = ""
        message = when (affectionLevel){
            ONE -> ONE.PETTING
            TWO -> TWO.PETTING
            THREE -> THREE.PETTING
        }
        return message
    }

    fun increasePettingScore(pettingScore: Int): Int {
        return pettingScore + 10
    }

     fun savePettingScores(id: Int, name: String, pettingScore: Int, taskScore: Int){
        val user: User = User(
                id,
                name,
                pettingScore,
                taskScore
        )
         insertOrUpdateUser(user)
    }



}




