package com.example.carepet.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.carepet.enum.AffectionLevelEnum
import com.example.carepet.model.User
import com.example.carepet.storage.UserDao
import com.example.carepet.storage.UserDatabase


class UserViewModel(application: Application): AndroidViewModel(application) {
    var message = ""

    private val getAllUserData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        getAllUserData = repository.getAllUserData
    }
    private var userLiveData: LiveData<User>? = null


    fun addPettingScore() {
        val addNumber = 10
        pettingScore += addNumber
        calculateAffectionLevel(pettingScore)
    }

    fun calculateAffectionLevel(pettingScore: Int): AffectionLevelEnum {
        var affectionLevel = 0

        affectionLevel = pettingScore + taskScore

        if (affectionLevel <= 20){ message = AffectionLevelEnum.ONE
        }else if(affectionLevel in 21..50){ return AffectionLevelEnum.TWO
        }else{ return AffectionLevelEnum.THREE }
    }

}