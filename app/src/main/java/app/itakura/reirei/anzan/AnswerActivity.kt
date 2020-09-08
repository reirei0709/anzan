package app.itakura.reirei.anzan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val displayQuestion = intent.getStringExtra("question")
        val yourAnswer = intent.getStringExtra("yourAnswer")
        val correctAnswer = intent.getStringExtra("correct")

        textView.text = displayQuestion
        textView2.text = yourAnswer.toString()

        if (yourAnswer == correctAnswer){
            imageView.setImageResource(R.drawable.correct_image)
            reactionImage.setImageResource(R.drawable.randy_happy_image)
        }else{
            imageView.setImageResource(R.drawable.miss_image)
            reactionImage.setImageResource(R.drawable.randy_sad_image)
        }

        backButton.setOnClickListener {
            val questionPage = Intent(this,MainActivity::class.java)
            startActivity(questionPage)
            finish()
        }



    }
}