package com.example.damgomescape

import android.content.Intent
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

lateinit var question_bedroom : ImageView
lateinit var next_button : Button
lateinit var script : TextView

lateinit var bgm_fantastic : MediaPlayer

class bedroom : AppCompatActivity() {
    fun number_baseball() {
        question_bedroom.setImageResource(R.drawable.questionmovieroom)
        next_button.visibility = View.VISIBLE
        script.text = "오옷! 그림이 바뀌었다!"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bedroom)

        script = findViewById(R.id.script)
        next_button = findViewById(R.id.next_button)
        val ndgimage : ImageView = findViewById(R.id.ndg)
        val image : ImageView = findViewById(R.id.pb_bedroom)
        question_bedroom = findViewById(R.id.question_bedroom)

        var count = 0
        next_button.setOnClickListener {
            if (count == 0){
                script.text = "방 엄청 좋고 예쁘네.. 부럽당"
            }
            else if (count == 1){
                script.text = "한 번 자세히 들여다볼까?"
            }
            else if (count == 2){
                script.text = "오 뭔가 있다??!"
                ndgimage.setImageResource(R.drawable.ndgnotforgive)
                question_bedroom.visibility = View.VISIBLE
            }
            else if (count == 3){
                script.text = "흠 이걸 어떻게 하라는 걸까.."
                next_button.visibility = View.GONE
            }
            else if (count == 4){
                script.text = "이건 또 뭐지??"
            }
            else if (count == 5){
                ndgimage.setImageResource(R.drawable.ndgnotforgive)
                script.text = "생각해보자.."
                next_button.visibility = View.INVISIBLE
            }
            count++
        }
        val exit_button : Button = findViewById(R.id.exit_button)
        exit_button.setOnClickListener {
            bgm_fantastic.stop()
            val intent = Intent(this@bedroom, livingroom::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}