package com.jdmccormack.mobile.android.numberflow.services.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numberfacts")
data class NumberFact @JvmOverloads constructor(
    @PrimaryKey @ColumnInfo(name = "number") var number: Int,
    @ColumnInfo(name = "text") var text: String = ""
)
