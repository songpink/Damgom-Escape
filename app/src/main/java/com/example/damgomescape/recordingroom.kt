package com.example.damgomescape

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class recordingroom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordingroom)
        val dg: ImageView = findViewById(R.id.dg_veryexciting)
        val anbur: ImageView = findViewById(R.id.angelic_buster)
        val script: TextView = findViewById(R.id.script)
        val next_button: Button = findViewById(R.id.next_button)
        val memo: TextView = findViewById(R.id.memo)

        val bgm_button1: Button = findViewById(R.id.rain_drop_flower)
        val bgm_button2: Button = findViewById(R.id.the_eyes_of_the_ishfira)
        val bgm_button3: Button = findViewById(R.id.the_tune_of_azure_light)
        val bgm_button4: Button = findViewById(R.id.whrever_you_are)

        val hidden: Button = findViewById(R.id.hidden)

        var bgm_grand_finale = MediaPlayer.create(this, R.raw.grandfinalestarbubble)
        var bgm_raindrop = MediaPlayer.create(this, R.raw.raindropflower)
        var bgm_ishfira = MediaPlayer.create(this, R.raw.theeyesoftheishfira)
        var bgm_paradox = MediaPlayer.create(this, R.raw.fourauspiciousbeasts)
        var bgm_wherever = MediaPlayer.create(this, R.raw.whereveryouare)

        var count = 0
        next_button.setOnClickListener {
            if (count == 0) {
                script.text = "녹음실? 여기는 또 무엇이 있을까.."
            }
            if (count == 1) {
                script.text = "다양한 음악 기기들이 있군!"
            }
            if (count == 2) {
                script.text = "핑크빈이 아이돌에 데뷔하고 싶다고 한 소문이 사실이었나..!"
            }
            if (count == 3) {
                bgm_grand_finale.start()

                script.text = "오 엔젤릭버스터 포스터다!"
                anbur.visibility = View.VISIBLE
                dg.setImageResource(R.drawable.dg_jumping)
            }
            if (count == 4) {
                script.text = "예쁘다~~"
            }
            if (count == 5) {
                script.text = "자세히 보니 아래에 뭐라고 적혀있네?"
                dg.setImageResource(R.drawable.ndgnotforgive)
            }
            if (count == 6) {
                memo.visibility = View.VISIBLE
                dg.setImageResource(R.drawable.ndgnotforgive)
            }
            if (count == 7) {
                script.text = "음~ 절대 만지지 말라고? 오케이.."
            }
            if (count == 8) {
                script.text = "이 방에서 얻을 수 있는 단서 뭐 없을까.."
                next_button.visibility = View.INVISIBLE
                hidden.visibility = View.VISIBLE
            }
            if (count == 9) {
                script.text = "뭔가 쪽지가 나왔는데 읽어봐야지~~"
            }
            if (count == 10) {
                next_button.text = "다음"
                script.text = "\"만지지 말라고 했더니 만지고있네 정말.. ㅡ.ㅡ\""
            }
            if (count == 11) {
                script.text = "\"청개구리도 아니고 말이야.. 암튼..\""
            }
            if (count == 12) {
                script.text = "\"그래도 이거 하나는 기억해!\""
            }
            if (count == 13) {
                script.text = "\"핑크빈귀여워\""
            }
            if (count == 14) {
                dg.setImageResource(R.drawable.dgseatdown)
                script.text = "이게 뭐람.."
            }
            if (count == 15) {
                dg.setImageResource(R.drawable.dgseatdown)
                script.text = "지가 귀여워서 뭐 어쨌다는거여? 쩝.."
            }
            if (count == 16) {
                script.text = "그래도 아래에 보니까 핑크빈이 듣는 음악이 있다. 들어볼까?"
                bgm_button1.visibility = View.VISIBLE
                bgm_button2.visibility = View.VISIBLE
                bgm_button3.visibility = View.VISIBLE
                bgm_button4.visibility = View.VISIBLE
                next_button.textSize = 12F
                next_button.text = "쪽지다시읽기"
                count = 9
            }
            count++
        }

        bgm_button1.setOnClickListener {
            bgm_grand_finale.stop()
            bgm_raindrop.stop()
            bgm_ishfira.stop()
            bgm_paradox.stop()
            bgm_wherever.stop()
            bgm_raindrop = MediaPlayer.create(this, R.raw.raindropflower)

            bgm_raindrop.start()
        }

        bgm_button2.setOnClickListener {
            bgm_grand_finale.stop()
            bgm_raindrop.stop()
            bgm_ishfira.stop()
            bgm_paradox.stop()
            bgm_wherever.stop()
            bgm_ishfira = MediaPlayer.create(this, R.raw.theeyesoftheishfira)

            bgm_ishfira.start()
        }

        bgm_button3.setOnClickListener {
            bgm_grand_finale.stop()
            bgm_raindrop.stop()
            bgm_ishfira.stop()
            bgm_paradox.stop()
            bgm_wherever.stop()
            bgm_paradox = MediaPlayer.create(this, R.raw.fourauspiciousbeasts)

            bgm_paradox.start()
        }

        bgm_button4.setOnClickListener {
            bgm_grand_finale.stop()
            bgm_raindrop.stop()
            bgm_ishfira.stop()
            bgm_paradox.stop()
            bgm_wherever.stop()
            bgm_wherever = MediaPlayer.create(this, R.raw.whereveryouare)

            bgm_wherever.start()
        }

        hidden.setOnClickListener {
            script.text = "아니?? 여기 손 부분에 뭔가 있다!"
            next_button.visibility = View.VISIBLE
        }

        val exit_button: Button = findViewById(R.id.exit_button)
        exit_button.setOnClickListener {
            bgm_grand_finale.stop()
            bgm_raindrop.stop()
            bgm_ishfira.stop()
            bgm_paradox.stop()
            bgm_wherever.stop()

            val intent = Intent(this@recordingroom, livingroom::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}