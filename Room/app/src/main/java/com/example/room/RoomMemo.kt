package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_memo")
data class RoomMemo(
    @PrimaryKey(autoGenerate = true)
    var no: Long? = null,

    @ColumnInfo
    var content: String = "",

    @ColumnInfo
    var datetime: Long = 0
)