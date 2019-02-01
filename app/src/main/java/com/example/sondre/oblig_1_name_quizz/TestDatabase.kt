package com.example.sondre.oblig_1_name_quizz

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context



    @Database(entities = arrayOf(Person::class), version = 1)
    abstract class TestDatabase : RoomDatabase() {
        abstract fun personDao(): PersonDao


        companion object {

            private var INSTANCE: TestDatabase? = null

            fun getInstance(context: Context): TestDatabase? {

                if (INSTANCE == null) {
                    synchronized(AppDatabase::class) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),

                            //AllowMainThreadQueries er dårlig valg, børr byttes ut...
                            TestDatabase::class.java, "TestDatabase.db").allowMainThreadQueries().build()
                    }
                }
                return INSTANCE
            }

        }
    }

