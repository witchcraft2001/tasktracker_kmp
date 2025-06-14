package com.dmdev.tasktracker.shared.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dmdev.tasktracker.shared.data.database.model.PeriodEntity

@Dao
interface PeriodsDao {
    @Insert
    suspend fun add(entity: PeriodEntity): Long

    @Update
    suspend fun update(entity: PeriodEntity)

    @Query("SELECT * from ${PeriodEntity.TABLE_NAME}")
    suspend fun getAll(): List<PeriodEntity>

    @Query("SELECT * FROM ${PeriodEntity.TABLE_NAME} WHERE id = :id")
    fun getById(id: Long): PeriodEntity?

    @Query("SELECT * FROM ${PeriodEntity.TABLE_NAME} WHERE ${PeriodEntity.PERIOD_TASK_ID_FIELD} = :taskId")
    fun getByTaskId(taskId: Long): List<PeriodEntity>

    @Query("SELECT * FROM ${PeriodEntity.TABLE_NAME} WHERE ${PeriodEntity.PERIOD_ENDED_AT_FIELD} is null")
    fun getAllUnfinished(): List<PeriodEntity>
}