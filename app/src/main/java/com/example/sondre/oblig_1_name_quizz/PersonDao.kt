package com.example.sondre.oblig_1_name_quizz

import android.arch.persistence.room.*


@Dao
interface PersonDao {
        @Query("SELECT * FROM person")
        fun getAll(): List<Person>

        @Query("SELECT * FROM person WHERE uid IN (:userIds)")
        fun loadAllByIds(userIds: IntArray): List<Person>


        @Query("SELECT * FROM person WHERE uid LIKE :Id")
        fun findByName(Id: Int) : Person

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertPerson(person: Person)

        /*
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertAll(vararg persons: Person)
*/
        @Delete
        fun delete(person: Person)

    }


