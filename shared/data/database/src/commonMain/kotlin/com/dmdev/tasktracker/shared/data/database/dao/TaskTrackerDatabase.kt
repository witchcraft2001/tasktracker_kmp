package com.dmdev.tasktracker.shared.data.database.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dmdev.tasktracker.shared.data.database.model.CategoryEntity
import com.dmdev.tasktracker.shared.data.database.model.PeriodEntity
import com.dmdev.tasktracker.shared.data.database.model.TaskEntity

@Database(
    entities = [TaskEntity::class, PeriodEntity::class, CategoryEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class TaskTrackerDatabase : RoomDatabase() {
}