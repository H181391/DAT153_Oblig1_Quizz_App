package com.example.sondre.oblig_1_name_quizz

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var userDao: PersonDao

    // val db = AppDatabase.getInstance(InstrumentationRegistry.getTargetContext())
    var dbTest: TestDatabase = TestDatabase.getInstance(InstrumentationRegistry.getTargetContext())!!

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.sondre.oblig_1_name_quizz", appContext.packageName)
    }

    @Test
    fun addAndDeletePerson() {

        val Atle = Person(1, "atle", "picPath")
        val Sondre = Person(2, "Sondre", "picPath")

        dbTest?.personDao()?.insertPerson(Atle)
        dbTest?.personDao()?.insertPerson(Sondre)
        var personFromDatabase = dbTest?.personDao()?.findById(1)
        var personFromDatabase2 = dbTest?.personDao()?.findById(2)

        //Check to see if person added to database
        assertEquals(Atle, personFromDatabase)
        assertEquals(Sondre, personFromDatabase2)

        var personList = dbTest.personDao().getAll()
        assertEquals(2, personList.size)

        //Delete the persons from the database
        dbTest?.personDao()?.delete(Atle)
        dbTest?.personDao()?.delete(Sondre)

        personFromDatabase = dbTest?.personDao()?.findById(1)
        personFromDatabase2 = dbTest?.personDao()?.findById(2)

        personList = dbTest?.personDao()?.getAll()
        //Check if the persons are deleted
        assertEquals(null, personFromDatabase)
        assertEquals(null, personFromDatabase2)
        assertEquals(0, personList.size)

    }


}
