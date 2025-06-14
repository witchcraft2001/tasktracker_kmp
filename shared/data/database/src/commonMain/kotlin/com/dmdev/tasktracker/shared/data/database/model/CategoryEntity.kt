package com.dmdev.tasktracker.shared.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.dmdev.tasktracker.shared.data.database.model.CategoryEntity.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = arrayOf(CategoryEntity.CATEGORY_ID_FIELD),
            childColumns = arrayOf(CategoryEntity.CATEGORY_CATEGORY_ID_FIELD),
            onDelete = ForeignKey.CASCADE,
        )
    ],
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = CATEGORY_ID_FIELD)
    val id: Long,
    @ColumnInfo(name = CATEGORY_CATEGORY_ID_FIELD)
    val categoryId: Long?,
    @ColumnInfo(name = CATEGORY_NAME_FIELD)
    val name: String,
    @ColumnInfo(name = CATEGORY_COLOR_FIELD)
    val color: Long,
    @ColumnInfo(name = CATEGORY_ICON_FIELD)
    val icon: String?
) {
    companion object {
        const val TABLE_NAME = "categories"
        const val CATEGORY_ID_FIELD = "id"
        const val CATEGORY_CATEGORY_ID_FIELD = "category_id"
        const val CATEGORY_NAME_FIELD = "name"
        const val CATEGORY_COLOR_FIELD = "color"
        const val CATEGORY_ICON_FIELD = "icon"
    }

    constructor() : this(0L, null, "", 0L, null)
}
