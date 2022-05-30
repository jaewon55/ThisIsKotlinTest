package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoomMemo::class], version = 1, exportSchema = false)
abstract class RoomHelper : RoomDatabase() {
    abstract fun roomMemoDao(): RoomMemoDao
}