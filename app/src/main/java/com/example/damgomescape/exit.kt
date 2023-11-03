package com.example.damgomescape

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class exit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)

        var bgm_exit: MediaPlayer = MediaPlayer.create(this, R.raw.newbeginningnottheend)
        bgm_exit.isLooping = true
        bgm_exit.start()

        val music_button: Button = findViewById(R.id.music)
        music_button.setOnClickListener {
            bgm_exit.stop()
            bgm_exit = MediaPlayer.create(this, R.raw.newbeginningnottheend)
            bgm_exit.isLooping = true
            bgm_exit.start()
        }

        val letter: TextView = findViewById(R.id.letter)
        val next_button: Button = findViewById(R.id.button)
        val dg_image: ImageView = findViewById(R.id.dg_image)
        val dg_script: TextView = findViewById(R.id.dg_script)
        val heartheart: ImageView = findViewById(R.id.heartheart)
        val pb_script: TextView = findViewById(R.id.pb_script)
        val pb_image: ImageView = findViewById(R.id.pb_image)

        var count = 0
        next_button.setOnClickListener {
            if (count == 0) {
                letter.text = "소연아 22번째 생일 축하해~~ 드디어 이 날이 왔구나~~!!\n"
            }
            if (count == 1) {
                letter.append("후후 내가 만들어본 게임 어땠으려나?? ㅋㅋㅋ 어려웠을까? 쉬웠을까?\n")
            }
            if (count == 2) {
                letter.append("농담곰 게임같은건 없으니까.. 있으면 너가 얼마나 좋아할까? 라는 생각에 한번 만들어 봤어.. ㅎ\n")
            }
            if (count == 3) {
                letter.append("2달정도 준비한 거지만 그래도 해보니까 재밌기도 하고! 그래서 힘들지 않았어\n")
            }
            if (count == 4) {
                letter.append("물론 마지막에 넣은 포커게임은 계속 원인을 모르겠는 오류가 발생해서..\n")
            }
            if (count == 5) {
                letter.append("그부분은 완성하지 못한게 조금 아쉬워.. ㅠ 시간만 있었으면 완성했을텐데.. 양해부탁해..\n")
            }
            if (count == 6) {
                letter.append("오잉? 밑에 담곰이가 나왔다 ㅋㅋㅋ\n")
                dg_image.visibility = View.VISIBLE
                dg_script.visibility = View.VISIBLE
                heartheart.visibility = View.INVISIBLE
            }
            if (count == 7) {
                letter.setText("사실 그동안 집이나 학교 열람실에서 이거 만든적 많았는데\n")
            }
            if (count == 8) {
                letter.append("너가 나중에 만나서 뭐했냐고 물어봤을 때 이거 했다고 말 못하니까 졸프나 다른 공부 했다고 얼버무린 적 많았당 ㅋㅋ..\n")
            }
            if (count == 9) {
                letter.append("저번에 너네 집에서 너가 먼저 잤을때도 사실 이거 하고 있었어 ㅎ..\n")
                dg_script.text = "호와왓 제욱오빠가 소연언니한테 보내는 편지인가보다~~ 부끄러워~~"
                dg_image.setImageResource(R.drawable.dg_heart)
            }
            if (count == 10) {
                letter.append("담곰아 부끄러우니까 조용히좀 해봐라~~! ㅋㅋㅋ\n")
            }
            if (count == 11) {
                letter.append("아무튼 재밌었으면 좋겠다!!\n")
            }
            if (count == 12) {
                letter.setText("작년에 너 생일날 같이 도시락 만들어서 한강 갔던거 진짜 얼마 안된 것 같은데\n")
            }
            if (count == 13) {
                letter.append("이게 벌써 1년이 됐네.. 시간 빠르다..!\n")
            }
            if (count == 14) {
                letter.append("그때도 참 재밌었는데! 그치?\n")
            }
            if (count == 15) {
                pb_script.text = "제욱님 깜짝 선물도 있잖아요! 그것도 얘기해야죠~~"
                pb_image.visibility = View.VISIBLE
                pb_script.visibility = View.VISIBLE
            }
            if (count == 16) {
                letter.setText("아 맞아 핑크빈아 고맙다~~\n")
            }
            if (count == 17) {
                letter.append("책상 위 선반에 있는 선물상자(내가 작년에 줬던거!) 거기 안에 열어보면 깜짝 선물이 있을거야~~\n")
                pb_image.setImageResource(R.drawable.pinkbeanheart)
            }
            if (count == 18) {
                letter.append("내가 미리 넣어뒀지롱 킥킥\n")
            }
            if (count == 19) {
                dg_image.setImageResource(R.drawable.ndgbboo)
                dg_script.text = "뭐야 핑크빈!! 너때매 고생했잖아~ 얼른 소연언니랑 놀고 싶었는데"
            }
            if (count == 20) {
                pb_script.text = "킥킥 그래도 재밌었지??"
                pb_image.setImageResource(R.drawable.pbmerongkatok)
                pb_image.scaleX = -1f
            }
            if (count == 21) {
                letter.text = "아 맞아! 최근에 졸프나 취업 걱정때문에 많이 힘들어 했는데\n"
            }
            if (count == 22) {
                letter.append("그때마다 자기 일처럼 걱정해줘서 너무 고마웠어.. 감동..\n")
            }
            if (count == 23) {
                letter.append("꼭 좋은 곳에 취업해볼게!!\n")
            }
            if (count == 24) {
                letter.append("2023.09.09 제욱오빠가~~!!\n")
                next_button.visibility = View.INVISIBLE
            }
            count++
        }

    }
}