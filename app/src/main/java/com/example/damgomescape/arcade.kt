package com.example.damgomescape

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

var open_coffer = 0
lateinit var bgm_arcade: MediaPlayer

class arcade : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arcade)

        val exit_button: Button = findViewById(R.id.exit_button)
        exit_button.setOnClickListener {
            bgm_arcade.stop()
            val intent = Intent(this@arcade, livingroom::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
        val script: TextView = findViewById(R.id.script)
        val dg_image: ImageView = findViewById(R.id.dg_image)
        val next_button: Button = findViewById(R.id.next_button)
        val statue: ImageView = findViewById(R.id.statue)
        val statue2: ImageView = findViewById(R.id.statue2)
        val statue3: ImageView = findViewById(R.id.statue3)
        val statue4: ImageView = findViewById(R.id.statue4)

        val password: EditText = findViewById(R.id.password)
        val text_password: TextView = findViewById(R.id.text_password)
        val answer_button: Button = findViewById(R.id.answer)
        val cup: ImageView = findViewById(R.id.cup)

        var count = 0
        next_button.setOnClickListener {
            if (count == 0) {
                script.text = "노는거 좋아하는 핑크빈 답게 집에 오락실도 있군"
            }
            if (count == 1) {
                script.text = "한 번 볼까.."
            }
            if (count == 2) {
                statue.visibility = View.VISIBLE
            }
            if (count == 3) {
                statue2.visibility = View.VISIBLE
                dg_image.setImageResource(R.drawable.ndgbboo)
            }
            if (count == 4) {
                statue3.visibility = View.VISIBLE
            }
            if (count == 5) {
                statue4.visibility = View.VISIBLE
            }
            if (count == 6) {
                script.text = "뭐냐 이건.."
            }
            if (count == 7) {
                script.text = "킹받네.."
            }
            if (count == 8) {
                script.text = "오락실이라면서 왜 이런거밖에 없어?"
            }
            if (count == 9) {
                password.visibility = View.VISIBLE
                text_password.visibility = View.VISIBLE
                answer_button.visibility = View.VISIBLE
                password.bringToFront()
                text_password.bringToFront()
                script.text = "..."
                next_button.visibility = View.INVISIBLE
                answer_button.setOnClickListener {
                    if (password.text.toString() == "2451") {
                        password.visibility = View.INVISIBLE
                        answer_button.visibility = View.INVISIBLE
                        text_password.visibility = View.INVISIBLE
                        dg_image.setImageResource(R.drawable.what)
                        script.text = "\"콰과광!!\""
                        bedroom().number_baseball()
                        next_button.visibility = View.VISIBLE
                    }
                }
            }
            if (count == 10) {
                script.text = "아닛??"
            }
            if (count == 11) {
                script.text = "여기에 비밀번호를 칠 수가 있었네?"
            }
            if (count == 12) {
                dg_image.setImageResource(R.drawable.ndgnotforgive)
                script.text = "근데 방금 무슨 큰 소리가 들렸는데!?"
            }
            if (count == 13) {
                script.text = "무슨 소리였을까.."
                cup.visibility = View.INVISIBLE
                next_button.visibility = View.INVISIBLE
                open_coffer = 1
            }
            count++
        }
    }
}