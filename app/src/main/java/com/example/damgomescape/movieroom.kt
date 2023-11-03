package com.example.damgomescape

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

lateinit var bgm_movieroom: MediaPlayer

class movieroom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movieroom)

        val glide_pb: Animation =
            AnimationUtils.loadAnimation(this, R.anim.glide_pinkbean_movieroom)
        val glide_pb2: Animation =
            AnimationUtils.loadAnimation(this, R.anim.glide_pinkbean2_movieroom)

        val dg_image: ImageView = findViewById(R.id.dg_image)
        val script: TextView = findViewById(R.id.script)
        val next_button: Button = findViewById(R.id.next_button)
        val pb_image: ImageView = findViewById(R.id.pb_image)
        val pb_default: ImageView = findViewById(R.id.pb_default)
        val script_pb: TextView = findViewById(R.id.script_pb)
        val change_text: TextView = findViewById(R.id.change_text)
        val change_button_1: Button = findViewById(R.id.change_button_1)
        val change_button_2: Button = findViewById(R.id.change_button_2)
        val change_button_3: Button = findViewById(R.id.change_button_3)
        val movie_1: TextView = findViewById(R.id.movie_1)
        val movie_2: TextView = findViewById(R.id.movie_2)
        val movie_3: TextView = findViewById(R.id.movie_3)

        var count = 0
        next_button.setOnClickListener {
            if (count == 0) {
                script.text = "여기도 한 번 둘러볼까.."
            }
            if (count == 1) {
                pb_image.visibility = View.VISIBLE
            }
            if (count == 2) {
                script.text = "아니 이 숭한 영화는 뭐야!!?"
                dg_image.setImageResource(R.drawable.what)
            }
            if (count == 3) {
                script.text = "이런 영화를 틀어놓으면 어떡해!!"
                dg_image.setImageResource(R.drawable.dgveryangry)
            }
            if (count == 4) {
                pb_default.visibility = View.VISIBLE
                script_pb.visibility = View.VISIBLE
                script_pb.bringToFront()
                pb_default.startAnimation(glide_pb)
                script_pb.startAnimation(glide_pb)
            }
            if (count == 5) {
                script.text = "뭐야 핑크빈! 너 어디 숨어있었어!"
                dg_image.setImageResource(R.drawable.dgmussleangry)
                dg_image.scaleX = -1f
            }
            if (count == 6) {
                script.text = "너 변태야? 저런 영화는 언제 찍은거야?"
            }
            if (count == 7) {
                script_pb.text = "뭔소리냐? 그냥 운동하고있는 장면일 뿐인데."
            }
            if (count == 8) {
                script_pb.text = "팔굽혀펴기 하고있는걸 뒤에서 봐주고 있는 것 뿐이다."
            }
            if (count == 9) {
                dg_image.setImageResource(R.drawable.dgpiing)
                dg_image.scaleX = 1f
                script.text = "앗.. 그런가?"
            }
            if (count == 10) {
                script_pb.text = "대체 뭘 생각한거야? 킥킥"
            }
            if (count == 11) {
                dg_image.setImageResource(R.drawable.ndgbboo)
                script.text = "머쓱.."
            }
            if (count == 12) {
                script_pb.text = "그럼 난 이만 다시 들어가볼게~ 메이플 해야돼서"
            }
            if (count == 13) {
                script_pb.text = "수고~"
                pb_default.setImageResource(R.drawable.pbmerong)
                pb_default.startAnimation(glide_pb2)
                script_pb.startAnimation(glide_pb2)
            }
            if (count == 14) {
                script.text = "아오.."
            }
            if (count == 15) {
                script.text = "단서나 찾아보자.."
            }
            if (count == 16) {
                script.text = "자세히 보니 아래에 뭐가 있는 것 같네?"
            }
            if (count == 17) {
                change_text.visibility = View.VISIBLE
            }
            if (count == 18) {
                change_text.text = "아래에서 영화를 선택하세요~"
                change_button_1.visibility = View.VISIBLE
                change_button_2.visibility = View.VISIBLE
                change_button_3.visibility = View.VISIBLE
            }
            if (count == 19) {
                dg_image.setImageResource(R.drawable.dgseatdown)
                script.text = "오 다른 영화도 볼 수 있나보다"
            }
            if (count == 20) {
                dg_image.setImageResource(R.drawable.dgseatdown)
                script.text = "어디보자.."
                next_button.visibility = View.INVISIBLE
                change_text.visibility = View.INVISIBLE

                var movie_count_1 = 0
                var movie_count_2 = 0
                var movie_count_3 = 0
                change_button_1.setOnClickListener {
                    pb_image.visibility = View.INVISIBLE
                    movie_1.visibility = View.VISIBLE
                    movie_2.visibility = View.INVISIBLE
                    movie_3.visibility = View.INVISIBLE
                    movie_count_1 = 1
                    if (movie_count_1 == 1 && movie_count_2 == 1 && movie_count_3 == 1) {
                        next_button.visibility = View.VISIBLE
                    }
                }
                change_button_2.setOnClickListener {
                    pb_image.visibility = View.INVISIBLE
                    movie_1.visibility = View.INVISIBLE
                    movie_2.visibility = View.VISIBLE
                    movie_3.visibility = View.INVISIBLE
                    movie_count_2 = 1
                    if (movie_count_1 == 1 && movie_count_2 == 1 && movie_count_3 == 1) {
                        next_button.visibility = View.VISIBLE
                    }
                }
                change_button_3.setOnClickListener {
                    pb_image.visibility = View.INVISIBLE
                    movie_1.visibility = View.INVISIBLE
                    movie_2.visibility = View.INVISIBLE
                    movie_3.visibility = View.VISIBLE
                    movie_count_3 = 1
                    if (movie_count_1 == 1 && movie_count_2 == 1 && movie_count_3 == 1) {
                        next_button.visibility = View.VISIBLE
                    }
                }
            }
            if (count == 21) {
                script.text = "뭐지..?"
            }
            if (count == 22) {
                script.text = "이게 영화..? ㅇㅅ는 또 뭐야??"
            }
            if (count == 23) {
                script.text = "기대했는뎅.. 쩝.."
                dg_image.setImageResource(R.drawable.ndglying)
            }
            if (count == 24) {
                script.text = "그래도 단서가 있을 수 있으니 꼼꼼히 봐보자.."
                next_button.visibility = View.INVISIBLE
            }
            count++
        }

        val exit_button: Button = findViewById(R.id.exit_button)
        exit_button.setOnClickListener {
            bgm_movieroom.stop()
            val intent = Intent(this@movieroom, livingroom::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}