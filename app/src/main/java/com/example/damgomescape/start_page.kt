package com.example.damgomescape

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class start_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        val start_page_bgm = MediaPlayer.create(this, R.raw.urbanstreet)
        start_page_bgm.isLooping = true
        start_page_bgm.start()

        val poker_error : Button = findViewById(R.id.poker_error)

        poker_error.setOnClickListener {
            var intent = Intent(this, exit::class.java)
            startActivity(intent)
            start_page_bgm.stop()
        }

        val jump_button : Button = findViewById(R.id.jump_button)
        val jump_password : EditText = findViewById(R.id.jump_password)
        val jump_submit : Button = findViewById(R.id.jump_submit)

        val glide_dg : Animation = AnimationUtils.loadAnimation(this, R.anim.glide)
        val glide_pb : Animation = AnimationUtils.loadAnimation(this, R.anim.glide_pinkbean)
        val glide_pb2 : Animation = AnimationUtils.loadAnimation(this, R.anim.glide_pinkbean2)

        val game_start : Button = findViewById(R.id.GameStart)
        val game_title : TextView = findViewById(R.id.GameTitle)
        val start_damgom : ImageView = findViewById(R.id.start_damgom)
        val start_pinkbean : ImageView = findViewById(R.id.start_pinkbean)

        val next_button : Button = findViewById(R.id.next_button)
        val textbox1 : TextView = findViewById(R.id.textbox1)
        val textbox2 : TextView = findViewById(R.id.textbox2)
        val textbox3 : TextView = findViewById(R.id.textbox3)
        val textbox4 : TextView = findViewById(R.id.textbox4)
        val textbox5 : TextView = findViewById(R.id.textbox5)

        val script1 : TextView = findViewById(R.id.script1)
        val script2 : TextView = findViewById(R.id.script2)
        val script3 : TextView = findViewById(R.id.script3)
        val script4 : TextView = findViewById(R.id.script4)
        val script5 : TextView = findViewById(R.id.script5)
        val script6 : TextView = findViewById(R.id.script6)

        val maker_script : TextView = findViewById(R.id.maker_script)

        val dg_happydance_1 : ImageView = findViewById(R.id.dg_happydance_1)
        val dg_handon_2 : ImageView = findViewById(R.id.dg_handon_2)
        val dg_ssang_3 : ImageView = findViewById(R.id.dg_ssang)
        val dg_what_4 : ImageView = findViewById(R.id.dg_what)

        val pb_default : ImageView = findViewById(R.id.pb_default)

        var count = 0

        jump_button.setOnClickListener {
            jump_password.visibility = View.VISIBLE
            jump_submit.visibility = View.VISIBLE
        }

        jump_submit.setOnClickListener {
            if (jump_password.text.toString() == "9453"){
                val intent = Intent(this@start_page, pbtemp::class.java)
                startActivity(intent)
                start_page_bgm.stop()
            }
        }

        game_start.setOnClickListener {
            poker_error.visibility = View.INVISIBLE
            start_damgom.visibility = View.GONE
            start_pinkbean.visibility = View.GONE
            game_start.visibility = View.GONE
            game_title.visibility = View.GONE
            next_button.visibility = View.VISIBLE
            textbox1.visibility = View.VISIBLE
            dg_happydance_1.visibility = View.VISIBLE
        }

        next_button.setOnClickListener {        // 1 -> 2
            if (count == 0) {
                textbox1.visibility = View.GONE
                textbox2.visibility = View.VISIBLE
                dg_happydance_1.setImageResource(R.drawable.ndghandon)
                script1.visibility = View.VISIBLE   // 여긴 어디지..
            }

            else if (count == 1) {                      // 2 -> 3
                textbox2.visibility = View.GONE
                textbox3.visibility = View.VISIBLE
                script1.visibility = View.GONE
                dg_happydance_1.setImageResource(R.drawable.ssang)
            }

            else if (count == 2){                       // 3 -> 4
                textbox3.visibility = View.GONE
                textbox4.visibility = View.VISIBLE
                dg_happydance_1.setImageResource(R.drawable.what)
            }

            else if (count == 3){
                pb_default.visibility = View.VISIBLE
                pb_default.startAnimation(glide_pb)
                Handler(Looper.getMainLooper()).postDelayed({
                    dg_happydance_1.startAnimation(glide_dg)
                }, 1000)
                script2.visibility = View.VISIBLE       // 킥킥 환영한다
            }

            else if (count == 4){
                dg_happydance_1.setImageResource(R.drawable.ndgbboo)
                script2.visibility = View.GONE
                script3.visibility = View.VISIBLE       // 너는 누구냐?
            }

            else if (count == 5) {
                script3.visibility = View.GONE
                script4.visibility = View.VISIBLE       // 나는 핑크빈이다
            }

            else if (count == 6) {
                script4.visibility = View.GONE
                script5.visibility = View.VISIBLE       //탈출하면 된다 그럼 난 이만
            }

            else if (count == 7) {
                pb_default.setImageResource(R.drawable.pbmerong)
                pb_default.startAnimation(glide_pb2)
            }

            else if (count == 8) {
                script5.visibility = View.GONE
                script6.visibility = View.VISIBLE
            }
            else if (count == 9) {
                script6.visibility = View.INVISIBLE
                textbox1.visibility = View.INVISIBLE
                maker_script.visibility = View.VISIBLE
            }
            else if (count == 10) {
                maker_script.text = "짧은 게임이지만.. 처음 해보는 거다보니 생각보다 오래 걸렸습니다. 2달정도.."
            }
            else if (count == 11) {
                maker_script.text = "그래도 재밌게 즐겨주셨으면 합니다! 게임을 클리어하면 깜짝 선물이 있을 지도?? 킥킥"
            }
            else if (count == 12) {
                maker_script.text = "게임을 시작하기 전에 몇 가지 주의사항을 말씀드리려 합니다."
            }
            else if (count == 13) {
                maker_script.text = "첫 번째로, 게임 중에는 뒤로가기 버튼을 누르지 않는 것을 추천합니다."
            }
            else if (count == 14) {
                maker_script.text = "뒤로가기 버튼을 누르면 게임이 개발자의 의도에 맞지 않게 동작할 우려가 있습니다"
            }
            else if (count == 15) {
                maker_script.text = "ㅠㅠ.. 이건 제 실력이 부족해서 그런거니 이해해 주세요.."
            }
            else if (count == 16) {
                maker_script.text = "두 번째로 게임 내 모든 수수께끼는 게임 내에서 해결 가능합니다."
            }
            else if (count == 17) {
                maker_script.text = "웹 검색 등으로 정보를 얻어야 하는 문제는 없으니 게임을 잠시 멈추고 나갔다 올 필요는 없습니다."
            }
            else if (count == 18) {
                maker_script.text = "게임을 잠깐 나갔다 오면 세이브가 안돼서 진행상황이 다 날아갈 수도 있어요..! 그러니 하지 않는게 좋습니다."
            }
            else if (count == 19) {
                maker_script.text = "세 번째로 만약 수수께끼가 너무 어려워서 진행이 막혔다면 이 게임 개발자에게 힌트를 달라고 하시면 됩니다."
            }
            else if (count == 20) {
                maker_script.text = "그리고 마지막으로 위에 중간세이브 지점으로 건너뛰기 버튼을 만들어 놓았으니 중간지점에서 게임을 이어하고 싶을 땐 저 버튼을 누르세요."
            }
            else if (count == 21) {
                maker_script.text = "중간세이브 지점에서 알려주는 세이브 코드를 입력하면 그 지점으로 건너뛸 수 있습니다."
            }
            else if (count == 22) {
                maker_script.text = "그럼 시작해 볼까요?"
            }

            else if (count == 23) {
                textbox4.visibility = View.GONE
                textbox5.visibility = View.VISIBLE
                next_button.setText("탈출하러 가기")
            }

            else if (count == 24) {
                val intent = Intent(this@start_page, livingroom::class.java)
                //intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                start_page_bgm.stop()
                startActivity(intent)
                finish()
            }
            count++
        }

    }

}
