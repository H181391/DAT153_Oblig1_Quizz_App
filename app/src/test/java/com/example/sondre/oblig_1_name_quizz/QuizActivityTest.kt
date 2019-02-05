package com.example.sondre.oblig_1_name_quizz

import org.junit.Test
import kotlin.test.assertEquals


class QuizActivityTest {


    @Test
    fun checkAnswerInQuiz() {
        val correctName = "Atle"
        val wrongName = "Sondre"

        val testTrue = QuizActivity().checkAnswer(correctName, "Atle")
        val testFalse = QuizActivity().checkAnswer(wrongName, "Atle")
        assertEquals(testTrue, true)
        assertEquals(testFalse, false)
    }

    @Test
    fun checkScoreUpdate() {
        //var quizActivity : QuizActivity().
        var score = QuizActivity().updateScore()
        assertEquals(1, score, "1 and 1")
    }

    @Test
    fun addAndDeletePerson() {

    }


}