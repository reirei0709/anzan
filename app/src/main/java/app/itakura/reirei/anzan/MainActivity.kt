package app.itakura.reirei.anzan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import app.itakura.reirei.anzan.AnswerActivity
import app.itakura.reirei.anzan.AnswerActivity as AnswerActivity1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomNumber1 = Random.nextInt(1000)
        val randomNumber2 = Random.nextInt(1000)

        number1Text.text = randomNumber1.toString()
        number2Text.text = randomNumber2.toString()

        val randomOperator = Random.nextInt(3)
        var operatorText = ""
        var correctAnswer = 0
        var correct = 0
        var hiku = "0"

        if(randomOperator == 0){
            operatorText = "+"
            signText.text = operatorText
            correctAnswer = randomNumber1 + randomNumber2

        }else if(randomOperator == 1){
            operatorText = "-"
            signText.text = operatorText
                 correct = randomNumber1 - randomNumber2
            if (randomNumber1>randomNumber2){
                 hiku = correct.toString()
            }else if (randomNumber1<randomNumber2){
                 hiku = "ー$correct"
            }


        }else{
            operatorText = "×"
            signText.text = operatorText
            correctAnswer = randomNumber1 * randomNumber2
        }

        checkButton.setOnClickListener {

            val yourAnswer = inputText.text.toString()

            if(yourAnswer.isNotEmpty()) {

                val answerPage = Intent(this, AnswerActivity::class.java)

                val questionText = number1Text.text.toString() + operatorText + number2Text.text.toString() + "="

                answerPage.putExtra("question", questionText)
                answerPage.putExtra("yourAnswer", yourAnswer)
                answerPage.putExtra("correct", correctAnswer.toString())
                answerPage.putExtra("hiku",hiku)
                answerPage.putExtra("operator",operatorText)


                startActivity(answerPage)
                finish()

            }




        }






    }
}