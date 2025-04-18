package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile

@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun busScheduleDao() : BusScheduleDao

    companion object{
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabace(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}

