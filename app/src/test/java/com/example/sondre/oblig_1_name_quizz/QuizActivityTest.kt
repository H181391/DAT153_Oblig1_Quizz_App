package com.example.sondre.oblig_1_name_quizz
import org.junit.Test
import kotlin.test.assertEquals


class QuizActivityTest {

    //val db: AppDatabase? = AppDatabase.getInstance(this)

    @Test
    fun checkAnswerInQuiz() {
        val navn = "Atle"
        val navn2 = "Sondre"

    val testTrue = QuizActivity().checkAnswer(navn, "Atle")
        val testFalse = QuizActivity().checkAnswer(navn2, "Atle")
        assertEquals(testTrue, true)
        assertEquals(testFalse,  false)
}

    @Test
    fun checkScoreUpdate() {

       //var quizActivity : QuizActivity().
        var score = QuizActivity().updateScore()
        assertEquals(1, score, "1 and 1")
    }

    @Test
    fun addAndDeletePerson() {
        val person = Person(4, "atle", "")
       // db?.personDao()?.insertPerson(person)
    }


}