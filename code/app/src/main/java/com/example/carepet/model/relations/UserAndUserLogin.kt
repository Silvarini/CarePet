package com.example.carepet.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.carepet.model.User
import com.example.carepet.model.UserLogin

data class UserAndUserLogin (
        @Embedded val user: User,
        @Relation(
                parentColumn = "user_id",
                entityColumn = "userLogin_user_id"
        )
        val userLogin: UserLogin

)