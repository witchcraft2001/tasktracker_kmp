package com.dmdev.tasktracker.shared.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.dmdev.tasktracker.shared.data.database.model.PeriodEntity.Companion.PERIOD_TASK_ID_FIELD
import com.dmdev.tasktracker.shared.data.database.model.PeriodEntity.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = TaskEntity::class,
            parentColumns = arrayOf(TaskEntity.TASK_ID_FIELD),
            childColumns = arrayOf(PERIOD_TASK_ID_FIELD),
            onDelete = ForeignKey.CASCADE,
        )
    ],
    indices = [
        Index(PERIOD_TASK_ID_FIELD)
    ]
)
data class PeriodEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = PERIOD_ID_FIELD)
    val id: Long = 0L,
    @ColumnInfo(name = PERIOD_TASK_ID_FIELD)
    val taskId: Long,
    @ColumnInfo(name = PERIOD_STARTED_AT_FIELD)
    val startedAt: Long,
    @ColumnInfo(name = PERIOD_ENDED_AT_FIELD)
    val endedAt: Long?
) {
    companion object {
        const val TABLE_NAME = "periods"
        const val PERIOD_ID_FIELD = "id"
        const val PERIOD_TASK_ID_FIELD = "task_id"
        const val PERIOD_STARTED_AT_FIELD = "started_at"
        const val PERIOD_ENDED_AT_FIELD = "ended_at"
    }
}
