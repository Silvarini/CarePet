package com.example.carepet.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.carepet.model.Task
import com.example.carepet.model.User
import kotlinx.coroutines.flow.Flow

data class UserWithTasks (
        @Embedded val user: User,
        @Relation(
                parentColumn = "user_id",
                entityColumn = "task_user_id"
        )
        val tasks: List<Task>
)