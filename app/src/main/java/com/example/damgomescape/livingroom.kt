package com.example.damgomescape

import android.content.Intent
import android.graphics.Color
import android.media.Image
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

var myflag = 0

class livingroom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livingroom)

        var catcount = 0
        val nonamedcat: ImageView = findViewById(R.id.nonamedcat)

        val next_button: Button = findViewById(R.id.next_button)
        val dg_image: ImageView = findViewById(R.id.dg_image)
        val text_box: TextView = findViewById(R.id.textbox)
        val script: TextView = findViewById(R.id.script)

        val bed_room: ImageButton = findViewById(R.id.bedRoom)
        val recording_room: ImageButton = findViewById(R.id.recordingRoom)
        val arcade_room: ImageButton = findViewById(R.id.arcade)
        val movie_room: ImageButton = findViewById(R.id.movieRoom)
        val scriptbutton: Button = findViewById(R.id.script_button)
        val script_dg: TextView = findViewById(R.id.script_dg)
        val script_cat: TextView = findViewById(R.id.script_cat)

        val answer: EditText = findViewById(R.id.answer)

        val submit: Button = findViewById(R.id.submit)

        val new_button: Button = findViewById(R.id.new_button)

        fun nonamedcat() {  // 이름없는고양이 등장
            myflag = 1 // myflag가 1인 동안에는 catcount가 증가하지 않게 하기

            nonamedcat.visibility = View.VISIBLE
            text_box.visibility = View.GONE
            next_button.visibility = View.GONE
            dg_image.x = 100f
            dg_image.setImageResource(R.drawable.what)
            scriptbutton.visibility = View.VISIBLE
            script_cat.visibility = View.VISIBLE

            var count2 = 0
            scriptbutton.setOnClickListener {
                if (count2 == 0) {
                    script_dg.visibility = View.VISIBLE
                } else if (count2 == 1) {
                    script_dg.text = "게다가 말을 한다??"
                } else if (count2 == 2) {
                    script_cat.text = "너도 곰인데 말 하고 있잖냥?"
                } else if (count2 == 3) {
                    dg_image.setImageResource(R.drawable.ndgstanding)
                    script_dg.text = "음.. 뭐 그렇긴 하넹.."
                } else if (count2 == 4) {
                    script_cat.text = "보아하니 핑크빈이 또 장난을 치고있는 모양이다냥."
                } else if (count2 == 5) {
                    script_cat.text = "내가 내는 문제를 풀면 도와주겠다."
                } else if (count2 == 6) {
                    script_cat.text = "지금까지 잘 조사했다면 풀 수 있는 문제다냥."
                } else if (count2 == 7) {
                    script_dg.bringToFront()
                    script_dg.text = "음.. 그냥 도와주면 안돼요?"
                    dg_image.setImageResource(R.drawable.ndgbboo)
                } else if (count2 == 8) {
                    script_dg.visibility = View.INVISIBLE
                    script_cat.text = "핑크빈이 맨 처음에 두 명 있었다면 1024명이 되는 데 몇 년이 걸릴까냥? (무시)"
                    answer.visibility = View.VISIBLE
                    submit.visibility = View.VISIBLE
                    scriptbutton.visibility = View.INVISIBLE
                    submit.setOnClickListener {
                        var correct = answer.text.toString()
                        if (correct == "9") {
                            script_cat.text = "정답이다냥. 잘 조사했구만. 그럼 다음문제를 내겠다."
                            submit.visibility = View.INVISIBLE
                            answer.visibility = View.INVISIBLE
                            scriptbutton.visibility = View.VISIBLE
                            scriptbutton.setOnClickListener {
                                submit.visibility = View.VISIBLE
                                answer.visibility = View.VISIBLE
                                scriptbutton.visibility = View.INVISIBLE
                                script_cat.text = "LOVE를 숫자로 나타내면 무슨 숫자일까냥?."
                                submit.setOnClickListener {
                                    var correct = answer.text.toString()
                                    if (correct == "1001") {
                                        script_cat.text = "두 번째 문제도 정답이다. 그럼 마지막 문제다냥."
                                        submit.visibility = View.INVISIBLE
                                        answer.visibility = View.INVISIBLE
                                        scriptbutton.visibility = View.VISIBLE
                                        scriptbutton.setOnClickListener {
                                            submit.visibility = View.VISIBLE
                                            answer.visibility = View.VISIBLE
                                            scriptbutton.visibility = View.INVISIBLE
                                            script_cat.text = "몰래 왕갈비를 먹은 사람은 누구냥?"
                                            submit.setOnClickListener {
                                                var correct = answer.text.toString()
                                                if (correct == "yeti" || correct == "예티") {
                                                    script_cat.text = "마지막 문제까지 풀다니, 꽤 똑똑하다냥?"
                                                    dg_image.setImageResource(R.drawable.dg_proud)
                                                    submit.visibility = View.INVISIBLE
                                                    answer.visibility = View.INVISIBLE
                                                    scriptbutton.visibility = View.VISIBLE
                                                    scriptbutton.setOnClickListener {
                                                        script_cat.text =
                                                            "그럼 약속대로 도와주겠다냥. 누군가를 불러올테니 좀만 기다려라."
                                                        nonamedcat.visibility = View.INVISIBLE
                                                        new_button.visibility = View.VISIBLE
                                                        scriptbutton.visibility = View.INVISIBLE
                                                    }
                                                } else
                                                    script_cat.text = "틀렸다냥. 이것만 맞히면 된다냥."
                                            }
                                        }
                                    } else
                                        script_cat.text = "좀 어렵냥? 틀렸다냥."
                                }
                            }
                        } else
                            script_cat.text = "틀렸다냥. 다시 생각해 보라냥."
                    }
                }
                count2++
            }
        }

        val minibean: ImageView = findViewById(R.id.minibean)
        val script_mb: TextView = findViewById(R.id.script_mb)
        val next_button_mb: Button = findViewById(R.id.next_button_mb)
        val choose1: Button = findViewById(R.id.choose1)
        val choose2: Button = findViewById(R.id.choose2)
        val choose3: Button = findViewById(R.id.choose3)
        val choose4: Button = findViewById(R.id.choose4)
        val mb_button_2: Button = findViewById(R.id.mb_button_2)
        val mb_button_3: Button = findViewById(R.id.mb_button_3)
        fun minibean() {
            myflag = 1
            dg_image.setImageResource(R.drawable.what)
            minibean.visibility = View.VISIBLE
            next_button_mb.visibility = View.VISIBLE
            script_dg.text = "너는 또 뭐냐!?"

            var correct1 = 0
            var correct2 = 0
            var correct3 = 0
            var correct4 = 0
            var correct5 = 0
            var correct6 = 0
            var count = 0
            next_button_mb.setOnClickListener {
                if (count == 0) {
                    script_mb.visibility = View.VISIBLE
                }
                if (count == 1) {
                    script_mb.text = "핑크빈님이 초대했다고 하신 녀석이 너로군."
                }
                if (count == 2) {
                    script_mb.text = "핑크빈님이 보내서 왔다."
                }
                if (count == 3) {
                    dg_image.setImageResource(R.drawable.ndgbboo)
                    script_dg.text = "거 참 귀찮게 하네.. 이번엔 뭐냐?"
                }
                if (count == 4) {
                    script_mb.text = "이제부터 내가 메이플스토리에 관련된 문제를 내겠다."
                }
                if (count == 5) {
                    script_mb.text = "총 6문제를 연속으로 낼 것이며 모두 맞히면 탈출을 도와주겠다."
                }
                if (count == 6) {
                    script_mb.text = "한 문제라도 틀릴 시 탈출 시켜주지 않는다."
                }
                if (count == 7) {
                    script_mb.text = "쉽지 않을 거다. 준비 됐나?"
                }
                if (count == 8) {
                    script_dg.text = "(메이플 안해봤는데..) 뭐 함 내보쇼."
                }
                if (count == 9) {
                    script_mb.text = "그럼 문제 들어간다."
                    next_button_mb.visibility = View.INVISIBLE
                    mb_button_3.visibility = View.VISIBLE
                }
                count++

                var count_3 = 0
                mb_button_3.setOnClickListener {
                    if (count_3 == 0) {
                        script_mb.text = "1. 다음 중 올스탯 10, 공/마 5, 보스데미지 10%을 올려주는 칭호는 무엇이냐?"
                        choose1.visibility = View.VISIBLE
                        choose2.visibility = View.VISIBLE
                        choose3.visibility = View.VISIBLE
                        choose4.visibility = View.VISIBLE
                        choose1.text = "쑥쑥 새싹"
                        choose2.text = "난 항상 헤이스트"
                        choose3.text = "핑아일체"
                        choose4.text = "진 악마"
                        choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose1.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct1 = 0
                        }
                        choose2.setOnClickListener {
                            choose2.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct1 = 0
                        }
                        choose3.setOnClickListener {
                            choose3.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct1 = 1
                        }
                        choose4.setOnClickListener {
                            choose4.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct1 = 0
                        }
                    }
                    if (count_3 == 1) {
                        script_mb.text = "2. 다음 중 노블레스 길드스킬로 향상시킬 수 있는 능력치는?"
                        choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose1.text = "아케인포스"
                        choose2.text = "이동속도"
                        choose3.text = "상태이상 내성"
                        choose4.text = "크리티컬 데미지"
                        choose1.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct2 = 0
                        }
                        choose2.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct2 = 0
                        }
                        choose3.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct2 = 0
                        }
                        choose4.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            correct2 = 1
                        }
                    }
                    if (count_3 == 2) {
                        script_mb.text = "3. 다음 중 메이플스토리에 존재하지 않는 몬스터는 무엇이냐?"
                        choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose1.text = "어센시온"
                        choose2.text = "빈스토크"
                        choose3.text = "뉴트 주니어"
                        choose4.text = "홍화사"
                        choose1.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct3 = 0
                        }
                        choose2.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct3 = 1
                        }
                        choose3.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct3 = 0
                        }
                        choose4.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            correct3 = 0
                        }
                    }
                    if (count_3 == 3) {
                        script_mb.text = "4. 다음 중 메이플스토리에 존재하는 스킬은?"
                        choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose1.text = "귀참"
                        choose2.text = "헬름 샷"
                        choose3.text = "뮤즈 어퍼"
                        choose4.text = "잭 스파이크"
                        choose1.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct4 = 1
                        }
                        choose2.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct4 = 0
                        }
                        choose3.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct4 = 0
                        }
                        choose4.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            correct4 = 0
                        }
                    }
                    if (count_3 == 4) {
                        script_mb.text = "5. 다음 중 메이플스토리에서 육성 불가능한 캐릭터는?"
                        choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose1.text = "덱스 제논"
                        choose2.text = "해방 호영"
                        choose3.text = "여 미하일"
                        choose4.text = "럭 섀도어"
                        choose1.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct5 = 0
                        }
                        choose2.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct5 = 0
                        }
                        choose3.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct5 = 1
                        }
                        choose4.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            correct5 = 0
                        }
                    }
                    if (count_3 == 5) {
                        script_mb.text = "6. 다음 중 메이플스토리에 존재하는 아이템은?"
                        choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                        choose1.text = "세인트 혼"
                        choose2.text = "베헤모스"
                        choose3.text = "워리어 실드"
                        choose4.text = "어비스 스크림"
                        choose1.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct6 = 0
                        }
                        choose2.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct6 = 0
                        }
                        choose3.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            choose4.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            correct6 = 1
                        }
                        choose4.setOnClickListener {
                            choose1.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose2.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose3.setBackgroundColor(Color.rgb(0xc7, 0xec, 0xc8))
                            choose4.setBackgroundColor(Color.rgb(0xc0, 0xc0, 0xf0))
                            correct6 = 0
                        }
                    }
                    if (count_3 == 6) {
                        if (correct1 == 1 && correct2 == 1 && correct3 == 1 && correct4 == 1 && correct5 == 1 && correct6 == 1) {
                            choose1.visibility = View.INVISIBLE
                            choose2.visibility = View.INVISIBLE
                            choose3.visibility = View.INVISIBLE
                            choose4.visibility = View.INVISIBLE
                            script_mb.text = "호오.. 이 문제들을 모두 맞히다니.. 너는 메잘알이군."
                            script_dg.visibility = View.INVISIBLE
                            dg_image.setImageResource(R.drawable.dg_proud)
                            mb_button_3.visibility = View.INVISIBLE
                            mb_button_2.visibility = View.VISIBLE
                            var count2 = 0
                            mb_button_2.setOnClickListener {
                                if (count2 == 0) {
                                    script_dg.visibility = View.VISIBLE
                                    script_dg.text = "(킥킥 메이플 하나도 모르는데 ㅋㅋ)"
                                }
                                if (count2 == 1) {
                                    script_dg.text = "(핑크빈이 준 힌트로 풀었다 ㅋㅋ)"
                                }
                                if (count2 == 2) {
                                    script_mb.text = "그럼 약속대로 탈출을 도와주지. 따라와라."
                                    mb_button_3.visibility = View.VISIBLE
                                    mb_button_2.visibility = View.INVISIBLE
                                    myflag = 0
                                }
                                count2++
                            }
                        } else {
                            choose1.visibility = View.INVISIBLE
                            choose2.visibility = View.INVISIBLE
                            choose3.visibility = View.INVISIBLE
                            choose4.visibility = View.INVISIBLE
                            dg_image.setImageResource(R.drawable.dgmussleangry)
                            dg_image.scaleX = -1f
                            script_dg.visibility = View.INVISIBLE
                            script_mb.text = "모든 문제를 맞히지 못했다."
                            mb_button_2.visibility = View.VISIBLE
                            mb_button_3.visibility = View.INVISIBLE
                            var count2 = 0
                            mb_button_2.setOnClickListener {
                                if (count2 == 0) {
                                    script_dg.visibility = View.VISIBLE
                                    script_dg.text = "아니 내가 이걸 어케알어"
                                }
                                if (count2 == 1) {
                                    script_dg.text = "문제가 너무 어렵잖아~~!"
                                }
                                if (count2 == 2) {
                                    dg_image.setImageResource(R.drawable.dgpiing)
                                    dg_image.scaleX = 1f
                                    script_dg.text = "(음.. 혹시 핑크빈이 뭔가 힌트를 줬던가?)"
                                }
                                if (count2 == 3) {
                                    script_dg.text = "(다시 잘 떠올려보자..)"
                                }
                                if (count2 == 4) {
                                    script_dg.text = "(메이플을 몰라도 풀 수 있을거야.)"
                                }
                                if (count2 == 5) {
                                    script_mb.text = "다시 도전해 보겠나?"
                                    mb_button_3.visibility = View.VISIBLE
                                    count_3 = 0
                                }
                                count2++
                            }
                        }
                    }
                    if (count_3 == 7) {
                        val intent = Intent(this@livingroom, pbtemp::class.java)
                        startActivity(intent)
                    }
                    count_3++
                }
            }
        }


        var new_count = 0
        new_button.setOnClickListener {
            if (new_count == 0) {
                script_dg.visibility = View.VISIBLE
                script_dg.text = "?"
                script_cat.visibility = View.GONE
            } else if (new_count == 1) {
                dg_image.setImageResource(R.drawable.ndgstanding)
                script_dg.text = "머징..?"
            } else if (new_count == 2) {
                script_dg.text = "하던거나 계속 해야겠다.."
                new_button.visibility = View.INVISIBLE
                next_button.visibility = View.INVISIBLE
                myflag = 0
            }
            new_count++
        }

        var count = 0
        next_button.setOnClickListener {
            if (count == 0) {
                text_box.setText("핑크빈의 집은 방이 4개나 있는 것 같아요!")
                dg_image.setImageResource(R.drawable.ndgnothinking)
            } else if (count == 1) {
                dg_image.setImageResource(R.drawable.ndglying)
                script.visibility = View.VISIBLE
            } else if (count == 2) {
                script.setText("귀찮은데.. 그냥 여기서 살까?")
            } else if (count == 3) {
                text_box.setText("안됩니다! 당신이 담곰이를 도와줘야겠어요")
            } else if (count == 4) {
                script.visibility = View.GONE
                text_box.setText("위에서 방을 골라 들어갈 수 있습니다!")
                bed_room.visibility = View.VISIBLE
                recording_room.visibility = View.VISIBLE
                movie_room.visibility = View.VISIBLE
                arcade_room.visibility = View.VISIBLE
            } else if (count == 5) {
                text_box.setText("최대한 단서를 모아 핑크빈의 집에서 탈출해 주세요~~")
                next_button.visibility = View.GONE
            }
            count++
        }

        bed_room.setOnClickListener {
            bgm_fantastic = MediaPlayer.create(this, R.raw.fantasticthinkinginmirror)
            bgm_fantastic.isLooping = true
            bgm_fantastic.start()
            val intent = Intent(this@livingroom, bedroom::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)

            overridePendingTransition(0, 0)
            if (myflag == 0) {
                catcount++
            }
            if (catcount == 5) {
                nonamedcat()
                catcount++
            }
            if (catcount == 9) {
                minibean()
                catcount++
            }
        }


        recording_room.setOnClickListener {
            val intent = Intent(this@livingroom, recordingroom::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
            overridePendingTransition(0, 0)
            if (myflag == 0) {
                catcount++
            }
            if (catcount == 5) {
                nonamedcat()
                catcount++
            }
            if (catcount == 9) {
                minibean()
                catcount++
            }
        }

        arcade_room.setOnClickListener {
            val intent = Intent(this@livingroom, arcade::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
            bgm_arcade = MediaPlayer.create(this, R.raw.fantasia)
            bgm_arcade.isLooping = true
            bgm_arcade.start()
            overridePendingTransition(0, 0)
            if (myflag == 0) {
                catcount++
            }
            if (catcount == 5) {
                nonamedcat()
                catcount++
            }
            if (catcount == 9) {
                minibean()
                catcount++
            }
        }

        movie_room.setOnClickListener {
            val intent = Intent(this@livingroom, movieroom::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
            bgm_movieroom = MediaPlayer.create(this, R.raw.funnytimemaker)
            bgm_movieroom.isLooping = true
            bgm_movieroom.start()
            overridePendingTransition(0, 0)
            if (myflag == 0) {
                catcount++
            }
            if (catcount == 5) {
                nonamedcat()
                catcount++
            }
            if (catcount == 9) {
                minibean()
                catcount++
            }
        }
    }
}

