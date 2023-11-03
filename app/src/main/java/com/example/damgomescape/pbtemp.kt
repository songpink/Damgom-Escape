package com.example.damgomescape

import android.content.Intent
import android.graphics.Color
import android.graphics.ColorSpace.Rgb
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class pbtemp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pbtemp)

        var poker_bgm = MediaPlayer.create(this, R.raw.fightingpinkbeen)
        var point_120_bgm = MediaPlayer.create(this, R.raw.trainheadingnowhere)

        val dg_script: TextView = findViewById(R.id.dg_script)
        val pb_script: TextView = findViewById(R.id.pb_script)
        val dg_image: ImageView = findViewById(R.id.dg_image)
        val pb_image: ImageView = findViewById(R.id.pb_image)
        val next_button: Button = findViewById(R.id.next_button)
        val game_rule: TextView = findViewById(R.id.game_rule)
        val as_image: ImageView = findViewById(R.id.as_image)
        val as_script: TextView = findViewById(R.id.as_script)
        val submit_point: EditText = findViewById(R.id.submit_number)
        val submit_button: Button = findViewById(R.id.submit_button)
        val text_remain_point : TextView = findViewById(R.id.text_remain_point)
        val remain_point : TextView = findViewById(R.id.remain_point)
        val text_dg : TextView = findViewById(R.id.text_dg)
        val text_pb : TextView = findViewById(R.id.text_pb)
        val colon : TextView = findViewById(R.id.colon)
        val dg_point : TextView = findViewById(R.id.dg_point)
        val pb_point : TextView = findViewById(R.id.pb_point)
        val point_120_next_button2 : Button = findViewById(R.id.point_120_next_button2)
        val point_120_next_button3 : Button = findViewById(R.id.point_120_next_button3)
        val point_120_next_button4 : Button = findViewById(R.id.point_120_next_button4)

        val point_120_next_button: Button = findViewById(R.id.point_120_next_button)
        val poker_next_button : Button = findViewById(R.id.poker_nextbutton)
        val your_card : TextView = findViewById(R.id.your_card)
        val your_card_var : TextView = findViewById(R.id.your_card_var)
        val dg_betting_chip : TextView = findViewById(R.id.dg_betting_chip)
        val pb_betting_chip : TextView = findViewById(R.id.pb_betting_chip)
        val dg_betting_chip_text : TextView = findViewById(R.id.dg_betting_chip_text)
        val pb_betting_chip_text : TextView = findViewById(R.id.pb_betting_chip_text)
        val poker_nextbutton2 : Button = findViewById(R.id.poker_nextbutton2)
        val pb_card : TextView = findViewById(R.id.pb_card)
        val pb_card_var : TextView = findViewById(R.id.pb_card_var)
        val poker_next_button3 : Button = findViewById(R.id.poker_nextbutton3)
        val poker_next_button4 : Button = findViewById((R.id.poker_nextbutton4))

        var dg_betting_chip_var = 0
        var pb_betting_chip_var = 0
        var dg_number_of_chips = 30
        var pb_number_of_chips = 30
        var poker_count = 0
        var card_index = 0

        var card_array = Array(20) { 0 }
        for (i in (0..9)) {
            card_array[i] = i + 1
        }
        for (i in (10..19)) {
            card_array[i] = i - 9
        }
        card_array.shuffle()

        fun poker_pb_action(dg_submit_chip : Int, dg_chip : Int, pb_chip : Int, dg_card : Int, pb_card : Int, dg_betting : Int, pb_betting : Int)  {
            poker_nextbutton2.visibility = View.VISIBLE

            var poker_count2 = 0
            poker_nextbutton2.setOnClickListener {
                if (poker_count2 == 0) {
                    as_script.text = "핑크빈님, 베팅해주십시오."
                    if (dg_chip == 0){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "내가 이기겠는데? 킥킥"
                        pb_betting_chip_var += (dg_betting-pb_betting)
                        pb_number_of_chips -= pb_betting_chip_var - pb_betting
                    }
                    else if (pb_chip < 10){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "음 위험하다.."
                        pb_betting_chip_var += (dg_betting-pb_betting)
                        pb_number_of_chips -= pb_betting_chip_var - pb_betting
                    }
                    else if (dg_submit_chip > 9){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "너무 많이 내는데? 무섭다.."
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += listOf((dg_betting-pb_betting+2), 0).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (dg_submit_chip < 2){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "왤케 조금 내~ 더 내봐~"
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += listOf((dg_betting-pb_betting+4), (dg_betting-pb_betting+1)).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (pb_card == 10){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "음.. 나는 이만큼 베팅할게!"
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += listOf((dg_betting-pb_betting+2), (dg_betting-pb_betting+6)).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (pb_card == 9){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "오~ 카드가 높은데? 많이 베팅해야지~~"
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += (dg_betting-pb_betting) + (4..5).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (pb_card == 8){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "음 이 숫자라.. 나는 이만큼 낼게!"
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += (dg_betting-pb_betting) + (0..3).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (pb_card < dg_card - 7){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "이번엔 다이!"
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += 0
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (dg_betting_chip_var > 10){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "음.. 이번엔 다이해야겠다"
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += 0
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (pb_card == 3 || pb_card == 4){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "카드 완전 높네 ㅋㅋ 엄청 베팅해야지"
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += ((dg_betting - pb_betting)..(dg_betting - pb_betting)+1).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (pb_card == 7 || pb_card > dg_card){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "이번엔 이만큼만~"
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += ((dg_betting - pb_betting)..(dg_betting - pb_betting)+4).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (pb_card == 5){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "음 고민이네.."
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += ((dg_betting - pb_betting)..(dg_betting - pb_betting)+1).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else if (pb_card == 1 || pb_card == 2){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "음 고민이네.."
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += (0..1).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting != 0) && (pb_betting_chip_var < dg_betting_chip_var)))
                    }
                    else if (pb_card == 6){
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "음.. 담곰이가 몇을 들고있을까.."
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += ((dg_betting - pb_betting)..(dg_betting - pb_betting)+4).random()
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                    else {
                        pb_script.setTextColor(Color.BLUE)
                        pb_script.text = "음.. 딱 두개만 더 가야겠다"
                        var temp_b = pb_betting_chip_var
                        var temp_n = pb_number_of_chips
                        do {
                            pb_betting_chip_var = temp_b
                            pb_number_of_chips = temp_n
                            pb_betting_chip_var += (dg_betting - pb_betting)+2
                            pb_number_of_chips -= pb_betting_chip_var - pb_betting
                        } while(pb_number_of_chips < 0 || ((pb_betting_chip_var-pb_betting) > dg_number_of_chips+dg_betting_chip_var-pb_number_of_chips))
                    }
                }
                if (poker_count2 == 1) {
                    as_script.text = "핑크빈님 ${pb_betting_chip_var-pb_betting}개 베팅하셨습니다."
                    pb_point.text = "${pb_number_of_chips}"
                    pb_betting_chip.text = "$pb_betting_chip_var"
                }
                if (poker_count2 == 2) {
                    if ((pb_betting_chip_var == dg_betting_chip_var) || (dg_number_of_chips == 0)) {
                        as_script.text = "핑크빈님 콜을 하셨으므로 카드를 공개합니다!"
                        poker_next_button3.visibility = View.VISIBLE
                        var poker_count4 = 0
                        poker_next_button3.setOnClickListener{
                            if (poker_count4 == 0) {
                                pb_card_var.text = "$pb_card"
                            }
                            if (poker_count4 == 1) {
                                if (dg_card == pb_card){
                                    as_script.text = "아 같은 카드가 나왔군요! 이러면 베팅된 칩을 그대로 두고 다음 라운드로 갑니다."
                                    poker_next_button.visibility = View.VISIBLE
                                    poker_next_button3.visibility = View.INVISIBLE
                                    poker_nextbutton2.visibility = View.INVISIBLE
                                    poker_count = 1
                                    card_index += 2
                                    if (card_index >= 20){
                                        as_script.append("카드를 다 써서 다시 섞겠습니다.")
                                        card_array.shuffle()
                                        card_index = 0
                                    }
                                }
                                if (dg_card > pb_card){
                                    as_script.text = "담곰님의 카드가 더 높습니다! 담곰님이 칩을 다 가져갑니다."
                                    dg_number_of_chips += dg_betting_chip_var + pb_betting_chip_var
                                    dg_point.text = "$dg_number_of_chips"
                                    poker_next_button.visibility = View.VISIBLE
                                    poker_next_button3.visibility = View.INVISIBLE
                                    poker_nextbutton2.visibility = View.INVISIBLE
                                    dg_betting_chip_var = 0
                                    pb_betting_chip_var = 0
                                    dg_betting_chip.text = "0"
                                    pb_betting_chip.text = "0"
                                    poker_count = 1
                                    card_index += 2
                                    if (dg_number_of_chips == 0 || pb_number_of_chips == 0){
                                        as_script.append("게임이 끝났군요!")
                                        poker_next_button.visibility = View.INVISIBLE
                                        poker_next_button4.visibility = View.VISIBLE
                                    }
                                    else if (card_index >= 20){
                                        as_script.append("카드를 다 써서 다시 섞겠습니다.")
                                        card_array.shuffle()
                                        card_index = 0
                                    }
                                }
                                if (dg_card < pb_card){
                                    as_script.text = "핑크빈님의 카드가 더 높습니다! 핑크빈님이 칩을 다 가져갑니다."
                                    pb_number_of_chips += dg_betting_chip_var + pb_betting_chip_var
                                    pb_point.text = "$pb_number_of_chips"
                                    poker_next_button.visibility = View.VISIBLE
                                    poker_next_button3.visibility = View.INVISIBLE
                                    poker_nextbutton2.visibility = View.INVISIBLE
                                    dg_betting_chip_var = 0
                                    pb_betting_chip_var = 0
                                    dg_betting_chip.text = "0"
                                    pb_betting_chip.text = "0"
                                    poker_count = 1
                                    card_index += 2
                                    if (dg_number_of_chips == 0 || pb_number_of_chips == 0){
                                        as_script.append("게임이 끝났군요!")
                                        poker_next_button.visibility = View.INVISIBLE
                                        poker_next_button4.visibility = View.VISIBLE
                                    }
                                    else if (card_index >= 20){
                                        as_script.append("카드를 다 써서 다시 섞겠습니다.")
                                        card_array.shuffle()
                                        card_index = 0
                                    }
                                }
                            }
                            poker_count4++
                        }
                    }
                    else if (pb_betting_chip_var > dg_betting_chip_var) {
                        as_script.text = "핑크빈님이 레이즈 하셨습니다."
                        poker_nextbutton2.visibility = View.INVISIBLE
                        poker_next_button.visibility = View.VISIBLE
                        poker_count = 2
                    }
                    if (pb_betting_chip_var-pb_betting == 0) {
                        as_script.text = "핑크빈님 다이 하셨습니다. 담곰님이 칩을 가져갑니다."
                        pb_card_var.text = "$pb_card"
                        dg_number_of_chips += dg_betting_chip_var + pb_betting_chip_var
                        dg_point.text = "$dg_number_of_chips"
                        poker_next_button.visibility = View.VISIBLE
                        poker_nextbutton2.visibility = View.INVISIBLE
                        dg_betting_chip_var = 0
                        pb_betting_chip_var = 0
                        dg_betting_chip.text = "0"
                        pb_betting_chip.text = "0"
                        poker_count = 1
                        card_index += 2
                        if (dg_number_of_chips == 0 || pb_number_of_chips == 0){
                            as_script.append("게임이 끝났군요!")
                            poker_next_button.visibility = View.INVISIBLE
                            poker_next_button4.visibility = View.VISIBLE
                        }
                        else if (card_index >= 20){
                            as_script.append("카드를 다 써서 다시 섞겠습니다.")
                            card_array.shuffle()
                            card_index = 0
                        }
                    }
                }
                poker_count2++
            }
        }

        fun poker() {
            point_120_bgm.stop()
            poker_bgm.stop()

            poker_bgm = MediaPlayer.create(this, R.raw.fightingpinkbeen)
            poker_bgm.isLooping = true
            poker_bgm.start()

            game_rule.visibility = View.INVISIBLE
            text_remain_point.visibility = View.VISIBLE
            text_remain_point.text = "남은 칩 개수"
            text_dg.visibility = View.VISIBLE
            text_pb.visibility = View.VISIBLE
            colon.visibility = View.VISIBLE
            dg_point.visibility = View.VISIBLE
            pb_point.visibility = View.VISIBLE
            dg_point.text = "30"
            pb_point.text = "30"
            dg_betting_chip.visibility = View.VISIBLE
            pb_betting_chip.visibility = View.VISIBLE
            dg_betting_chip_text.visibility = View.VISIBLE
            pb_betting_chip_text.visibility = View.VISIBLE
            dg_betting_chip.text = "0"
            pb_betting_chip.text = "0"
            poker_next_button.visibility = View.VISIBLE


            var dg_card_value = 0
            var pb_card_value = 0

            poker_next_button.setOnClickListener {
                if (poker_count == 0){
                    as_script.text = "게임을 시작하죠. 지금 카드를 섞겠습니다."
                }
                if (poker_count == 1){
                    as_script.text = "자. 카드를 나눠드리겠습니다."
                    your_card.visibility = View.VISIBLE
                    your_card_var.visibility = View.VISIBLE
                    your_card_var.text = "${card_array[card_index]}"
                    pb_card.visibility = View.VISIBLE
                    pb_card_var.visibility = View.VISIBLE
                    pb_card_var.text = "?"
                    dg_card_value = card_array[card_index]
                    pb_card_value = card_array[card_index+1]
                }
                if (poker_count == 2){
                    as_script.text = "담곰님. 칩을 베팅해 주시죠. 다이를 하시려면 0을 입력하시면 됩니다."
                    submit_point.visibility = View.VISIBLE
                    submit_button.visibility = View.VISIBLE
                    poker_next_button.visibility = View.INVISIBLE
                    submit_button.setOnClickListener {
                        if (submit_point.text.toString().isEmpty()){
                            as_script.text = "빈칸으로 제출하시면 안 됩니다!"
                        }
                        else if (submit_point.text.toString().toInt() == 0){
                            as_script.text = "농담곰님이 다이를 선택하셨습니다. 다음 라운드로 넘어가죠."
                            pb_card_var.text = "$pb_card_value"
                            pb_number_of_chips += dg_betting_chip_var + pb_betting_chip_var
                            pb_point.text = "$pb_number_of_chips"
                            dg_betting_chip_var = 0
                            pb_betting_chip_var = 0
                            dg_betting_chip.text = "0"
                            pb_betting_chip.text = "0"
                            poker_next_button.visibility = View.VISIBLE
                            poker_count = 1
                            card_index += 2
                            if (dg_number_of_chips == 0 || pb_number_of_chips == 0){
                                as_script.append("게임이 끝났군요!")
                                poker_next_button.visibility = View.INVISIBLE
                                poker_next_button4.visibility = View.VISIBLE
                            }
                            else if (card_index >= 20){
                                as_script.append("카드를 다 써서 다시 섞겠습니다.")
                                card_array.shuffle()
                                card_index = 0
                            }
                        }
                        else if (submit_point.text.toString().toInt() > dg_number_of_chips){
                            as_script.text = "가지고 있는 칩 개수보다 더 많이 내실 수 없습니다."
                        }
                        else if (submit_point.text.toString().toInt() > pb_number_of_chips+pb_betting_chip_var-dg_betting_chip_var){
                            as_script.text = "핑크빈님이 최소한 콜은 할 수 있게 베팅하셔야 합니다."
                        }
                        else if (submit_point.text.toString().toInt() < (pb_betting_chip_var - dg_betting_chip_var)){
                            as_script.text = "핑크빈님과 담곰님의 베팅된 칩수 차이보다 적게 내시면 안 됩니다."
                        }
                        else if (submit_point.text.toString().toInt() == (pb_betting_chip_var - dg_betting_chip_var)){
                            as_script.text = "담곰님이 콜을 하셨군요. 카드를 공개하겠습니다."
                            dg_betting_chip_var += submit_point.text.toString().toInt()
                            dg_betting_chip.text = "$dg_betting_chip_var"
                            dg_number_of_chips -= submit_point.text.toString().toInt()
                            dg_point.text = "${dg_number_of_chips}"
                            poker_next_button3.visibility = View.VISIBLE
                            var poker_count4 = 0
                            poker_next_button3.setOnClickListener{
                                if (poker_count4 == 0) {
                                    pb_card_var.text = "$pb_card_value"
                                }
                                if (poker_count4 == 1) {
                                    if (dg_card_value == pb_card_value){
                                        as_script.text = "아 같은 카드가 나왔군요! 이러면 베팅된 칩을 그대로 두고 다음 라운드로 갑니다."
                                        poker_next_button.visibility = View.VISIBLE
                                        poker_next_button3.visibility = View.INVISIBLE
                                        poker_count = 1
                                        card_index += 2
                                        if (dg_number_of_chips == 0 || pb_number_of_chips == 0){
                                            as_script.append("게임이 끝났군요!")
                                            poker_next_button.visibility = View.INVISIBLE
                                            poker_next_button4.visibility = View.VISIBLE
                                        }
                                        else if (card_index >= 20){
                                            as_script.append("카드를 다 써서 다시 섞겠습니다.")
                                            card_array.shuffle()
                                            card_index = 0
                                        }
                                    }
                                    if (dg_card_value > pb_card_value){
                                        as_script.text = "담곰님의 카드가 더 높습니다! 담곰님이 칩을 다 가져갑니다."
                                        dg_number_of_chips += dg_betting_chip_var + pb_betting_chip_var
                                        dg_point.text = "$dg_number_of_chips"
                                        poker_next_button.visibility = View.VISIBLE
                                        poker_next_button3.visibility = View.INVISIBLE
                                        dg_betting_chip_var = 0
                                        pb_betting_chip_var = 0
                                        dg_betting_chip.text = "0"
                                        pb_betting_chip.text = "0"
                                        poker_count = 1
                                        card_index += 2
                                        if (dg_number_of_chips == 0 || pb_number_of_chips == 0){
                                            as_script.append("게임이 끝났군요!")
                                            poker_next_button.visibility = View.INVISIBLE
                                            poker_next_button4.visibility = View.VISIBLE
                                        }
                                        else if (card_index >= 20){
                                            as_script.append("카드를 다 써서 다시 섞겠습니다.")
                                            card_array.shuffle()
                                            card_index = 0
                                        }
                                    }
                                    if (dg_card_value < pb_card_value){
                                        as_script.text = "핑크빈님의 카드가 더 높습니다! 핑크빈님이 칩을 다 가져갑니다."
                                        pb_number_of_chips += dg_betting_chip_var + pb_betting_chip_var
                                        pb_point.text = "$pb_number_of_chips"
                                        poker_next_button.visibility = View.VISIBLE
                                        poker_next_button3.visibility = View.INVISIBLE
                                        dg_betting_chip_var = 0
                                        pb_betting_chip_var = 0
                                        dg_betting_chip.text = "0"
                                        pb_betting_chip.text = "0"
                                        poker_count = 1
                                        card_index += 2
                                        if (dg_number_of_chips == 0 || pb_number_of_chips == 0){
                                            as_script.append("게임이 끝났군요!")
                                            poker_next_button.visibility = View.INVISIBLE
                                            poker_next_button4.visibility = View.VISIBLE
                                        }
                                        else if (card_index >= 20){
                                            as_script.append("카드를 다 써서 다시 섞겠습니다.")
                                            card_array.shuffle()
                                            card_index = 0
                                        }
                                    }
                                }
                                poker_count4++
                            }
                        }
                        else {
                            var a = submit_point.text.toString().toInt()
                            as_script.text = "좋습니다. ${a}개 베팅하셨습니다."
                            dg_number_of_chips -= submit_point.text.toString().toInt()
                            dg_point.text = "${dg_number_of_chips}"
                            dg_betting_chip_var += submit_point.text.toString().toInt()
                            dg_betting_chip.text = "${dg_betting_chip_var}"
                            submit_point.visibility = View.INVISIBLE
                            submit_button.visibility = View.INVISIBLE
                            poker_pb_action(a, dg_number_of_chips, pb_number_of_chips, card_array[card_index], card_array[card_index+1], dg_betting_chip_var, pb_betting_chip_var)
                            poker_next_button.visibility = View.VISIBLE
                            poker_count = 1
                        }
                    }
                }
                poker_count++
            }
        }

        var count_fin = 0
        poker_next_button4.setOnClickListener {
            if (count_fin == 0){
                poker_bgm.stop()
                if (dg_number_of_chips == 0){
                    as_script.text = "핑크빈님의 승리!"
                }
                else if (pb_number_of_chips == 0){
                    as_script.text = "담곰님의 승리!"
                }
            }
            if (count_fin == 1){
                poker_bgm.stop()
                if (dg_number_of_chips == 0){
                    pb_script.text = "푸하하. 다시 해볼래?"
                }
                else if (pb_number_of_chips == 0){
                    pb_script.text = "우엥, 졌당.."
                }
            }
            if (count_fin == 2){
                poker_bgm.stop()
                if (dg_number_of_chips == 0){
                    dg_script.text = "쳇, 다시하면 이긴다구~"
                }
                else if (pb_number_of_chips == 0){
                    dg_image.setImageResource(R.drawable.dg_proud)
                    dg_script.text = "드디어 탈출할 수 있는건가??"
                }
            }
            if (count_fin == 3){
                poker_bgm.stop()
                if (dg_number_of_chips == 0){
                    pb_script.text = "좋아. 다시 해보자!"
                }
                else if (pb_number_of_chips == 0){
                    pb_script.text = "좋아. 이리 따라와봐."
                    poker_next_button4.text = "나가기"
                }
            }
            if (count_fin == 4){
                poker_bgm.stop()
                if (dg_number_of_chips == 0){
                    poker()
                    count_fin = -1
                    poker_next_button4.visibility = View.INVISIBLE
                }
                else if (pb_number_of_chips == 0){
                    val intent = Intent(this@pbtemp, exit::class.java)
                    startActivity(intent)
                }
            }
            count_fin++
        }

        fun point_120() {
            point_120_bgm = MediaPlayer.create(this, R.raw.trainheadingnowhere)
            point_120_bgm.isLooping = true
            point_120_bgm.start()

            text_remain_point.visibility = View.VISIBLE
            remain_point.visibility = View.VISIBLE
            text_dg.visibility = View.VISIBLE
            text_pb.visibility = View.VISIBLE
            colon.visibility = View.VISIBLE
            dg_point.visibility = View.VISIBLE
            pb_point.visibility = View.VISIBLE

            var p_round1_point = (2..4).random()
            var p_round2_point = (23..26).random()
            var p_round3_point = (23..27).random()
            var p_round4_point = (23..27).random()
            var p_round5_point = (23..27).random()
            var p_round7_point = (0..2).random()
            var p_round6_point = 120 - (p_round1_point + p_round2_point + p_round3_point + p_round4_point + p_round5_point + p_round7_point)

            var remain_point_var = 120
            var dg_point_var = 0
            var pb_point_var = 0

            var count_120 = -1
            point_120_next_button.setOnClickListener {
                if (count_120 == -1) {
                    as_script.text = "좋습니다. 담곰님, 준비 되셨습니까?"
                    point_120_next_button.text = "시작하기"
                }
                if (count_120 == 0) {
                    as_script.text = "게임을 시작하죠. 연습게임 없이 바로 갑니다."
                    point_120_next_button.text = "다음"
                    remain_point_var = 120
                    dg_point_var = 0
                    pb_point_var = 0
                    remain_point.text = "120"
                    dg_point.text = "0"
                    pb_point.text = "0"
                }
                if (count_120 == 1) {
                    as_script.text = "담곰님과 핑크빈님, 점수를 제출해 주십시오."
                    submit_point.visibility = View.VISIBLE
                    submit_button.visibility = View.VISIBLE
                    point_120_next_button.visibility = View.INVISIBLE
                    submit_button.setOnClickListener {
                        if (submit_point.text.toString().isEmpty()){
                            as_script.text = "빈 칸으로 제출하시면 안됩니다!!"
                        }
                        else if (submit_point.text.toString().toInt() > remain_point_var){
                            as_script.text = "지금 점수보다 큰 수를 쓰시면 안됩니다."
                        }
                        else {
                            as_script.text = "좋습니다. 두 분 모두 제출하셨군요."
                            remain_point_var -= submit_point.text.toString().toInt()
                            remain_point.text = "${remain_point_var}"
                            point_120_next_button.visibility = View.VISIBLE
                            submit_point.visibility = View.INVISIBLE
                            submit_button.visibility = View.INVISIBLE
                        }
                    }
                }
                if (count_120 == 2){
                    as_script.text = "1라운드의 승자는 과연 누구일까요? 결과를 공개합니다!"
                }
                if (count_120 == 3){
                    if (submit_point.text.toString().toInt() > p_round1_point){
                        as_script.text = "아~~ 1라운드의 승자는 농담곰 님입니다~~!"
                        dg_point_var++
                        dg_point.text = "${dg_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE
                        dg_image.setImageResource(R.drawable.dg_proud)
                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                dg_script.text = "푸하하. 뭐야 쉬운데? 내가 이기겠는걸?"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "크크. 아직 좋아하기엔 이르다구?"
                            }
                            if (count_120_2 == 2) {
                                as_script.text = "좋습니다. 그럼 2라운드로 넘어가죠."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() == p_round1_point){
                        as_script.text = "아~~ 1라운드는 동점이 나왔습니다! 서로의 생각이 일치했군요!"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "호오~ 나랑 똑같이 ${submit_point.text.toString().toInt()}를 쓰다니"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "머리 좀 쓰고있나본데?"
                            }
                            if (count_120_2 == 2) {
                                as_script.text = "좋습니다. 그럼 2라운드로 넘어가죠."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() < p_round1_point){
                        as_script.text = "아~~ 1라운드의 승자는 핑크빈 님입니다~~!!"
                        as_image.setImageResource(R.drawable.askk)
                        pb_image.setImageResource(R.drawable.pbmerong)
                        dg_image.setImageResource(R.drawable.ndgbboo)
                        pb_point_var++
                        pb_point.text = "${pb_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "크크. 1라운드부터 이겨버렸네??"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "2라운드에는 한 50 써볼까? 킥킥"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "쳇.. 1라운드는 포인트 아낀거라구~"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "좋습니다. 그럼 2라운드로 넘어가죠."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                }
                if (count_120 == 4){
                    as_script.text = "담곰님. 2라운드 점수를 제출해 주십시오."
                    submit_point.visibility = View.VISIBLE
                    submit_button.visibility = View.VISIBLE
                    point_120_next_button.visibility = View.INVISIBLE
                    submit_button.setOnClickListener {
                        if (submit_point.text.toString().isEmpty()){
                            as_script.text = "빈 칸으로 제출하시면 안됩니다!!"
                        }
                        else if (submit_point.text.toString().toInt() > remain_point_var){
                            as_script.text = "지금 점수보다 큰 수를 쓰시면 안됩니다."
                        }
                        else {
                            as_script.text = "좋습니다. 두 분 모두 제출하셨군요."
                            remain_point_var -= submit_point.text.toString().toInt()
                            remain_point.text = "${remain_point_var}"
                            point_120_next_button.visibility = View.VISIBLE
                            submit_point.visibility = View.INVISIBLE
                            submit_button.visibility = View.INVISIBLE
                        }
                    }
                }
                if (count_120 == 5){
                    as_script.text = "과연 2라운드에서는 누가 이겼을까요? 공개합니다!"
                }
                if (count_120 == 6) {
                    if (submit_point.text.toString().toInt() > p_round2_point) {
                        as_script.text = "아~~ 2라운드의 승자는 농담곰 님입니다~~!"
                        dg_point_var++
                        dg_point.text = "${dg_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE
                        dg_image.setImageResource(R.drawable.dg_proud)
                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                dg_script.text = "아싸~~"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "흠. 그걸로 좋아하다니. 나 이번에 0 적었는데 ㅋㅋ"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "응~ 안속아~"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "3라운드로 넘어가겠습니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() == p_round2_point) {
                        as_script.text = "아닛~~ 동점입니다!"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "호오~ 나랑 똑같은 수를 쓰다니"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "머리 좀 쓰고있나본데?"
                            }
                            if (count_120_2 == 2) {
                                as_script.text = "좋습니다. 그럼 3라운드로 넘어가죠."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() < p_round2_point) {
                        as_script.text = "아~~ 2라운드의 승자는 핑크빈 님입니다~~!!"
                        as_image.setImageResource(R.drawable.askk)
                        pb_image.setImageResource(R.drawable.pbmerong)
                        pb_point_var++
                        pb_point.text = "${pb_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "크크. 분발하라구."
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "나 아직도 110점 남았는데~ 껄껄"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "우잉.."
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "승부가 달아오르는군요. 그럼 3라운드로 가겠습니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                }
                if (count_120 == 7) {
                    as_script.text = "3라운드입니다. 점수를 제출해 주십시오."
                    submit_point.visibility = View.VISIBLE
                    submit_button.visibility = View.VISIBLE
                    point_120_next_button.visibility = View.INVISIBLE
                    submit_button.setOnClickListener {
                        if (submit_point.text.toString().isEmpty()){
                            as_script.text = "빈 칸으로 제출하시면 안됩니다!!"
                        }
                        else if (submit_point.text.toString().toInt() > remain_point_var){
                            as_script.text = "지금 점수보다 큰 수를 쓰시면 안됩니다."
                        }
                        else {
                            as_script.text = "좋습니다. 두 분 모두 제출하셨군요."
                            remain_point_var -= submit_point.text.toString().toInt()
                            remain_point.text = "${remain_point_var}"
                            point_120_next_button.visibility = View.VISIBLE
                            submit_point.visibility = View.INVISIBLE
                            submit_button.visibility = View.INVISIBLE
                        }
                    }
                }
                if (count_120 == 8){
                    as_script.text = "이번 라운드에는 누가 이겼을까요? 공개합니다!"
                }
                if (count_120 == 9) {
                    if (submit_point.text.toString().toInt() > p_round3_point) {
                        as_script.text = "아~~ 3라운드 승자는 농담곰 님입니다~~!"
                        dg_point_var++
                        dg_point.text = "${dg_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE
                        dg_image.setImageResource(R.drawable.dg_proud)
                        pb_image.setImageResource(R.drawable.pinkbeandefault)
                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                dg_script.text = "오 이겼다~~!"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "응 나 이번에 0 적었어~ ㅋㅋ"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "응 안속아~ 킥킥"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "4라운드로 넘어가겠습니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() == p_round3_point) {
                        as_script.text = "아~~ 무승부입니다! 같은 수를 쓰셨습니다~"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "나랑 똑같은 수를 쓰다니"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "대단한데??"
                            }
                            if (count_120_2 == 2) {
                                as_script.text = "좋습니다. 그럼 4라운드로 넘어가겠습니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() < p_round3_point) {
                        as_script.text = "승자는 핑크빈 님입니다~~!!"
                        as_image.setImageResource(R.drawable.askk)
                        pb_image.setImageResource(R.drawable.pbmerong)
                        dg_image.setImageResource(R.drawable.ndgbboo)
                        pb_point_var++
                        pb_point.text = "${pb_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "크크. 분발하라구."
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "나 다음엔 1쓸게~"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "진짠가..?"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "승부가 달아오르는군요. 그럼 4라운드로 가겠습니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                }
                if (count_120 == 10) {
                    as_script.text = "벌써 4라운드군요! 점수를 제출해 주십시오."
                    submit_point.visibility = View.VISIBLE
                    submit_button.visibility = View.VISIBLE
                    point_120_next_button.visibility = View.INVISIBLE
                    submit_button.setOnClickListener {
                        if (submit_point.text.toString().isEmpty()){
                            as_script.text = "빈 칸으로 제출하시면 안됩니다!!"
                        }
                        else if (submit_point.text.toString().toInt() > remain_point_var){
                            as_script.text = "지금 점수보다 큰 수를 쓰시면 안됩니다."
                        }
                        else {
                            as_script.text = "좋습니다. 두 분 모두 제출하셨군요."
                            remain_point_var -= submit_point.text.toString().toInt()
                            remain_point.text = "${remain_point_var}"
                            point_120_next_button.visibility = View.VISIBLE
                            submit_point.visibility = View.INVISIBLE
                            submit_button.visibility = View.INVISIBLE
                        }
                    }
                }
                if (count_120 == 11){
                    as_script.text = "과연 누가 이겼을까요? 공개합니다!"
                }
                if (count_120 == 12) {
                    if (submit_point.text.toString().toInt() > p_round4_point) {
                        as_script.text = "아~~ 4라운드의 승자는 농담곰 님입니다~~!"
                        dg_point_var++
                        dg_point.text = "${dg_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE
                        dg_image.setImageResource(R.drawable.dg_proud)
                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                dg_script.text = "오우예~"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "흠. 그걸로 좋아하다니. 나 이번에 0 적었는데 ㅋㅋ"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "ㅋㅋㅋ"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "5라운드로 넘어가겠습니다!"
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                                if (dg_point_var >= 4 || pb_point_var >= 4){
                                    point_120_next_button3.visibility = View.VISIBLE
                                }
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() == p_round4_point) {
                        as_script.text = "아~~ 무승부입니다!"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "호오~"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "머리 좀 쓰고있나본데?"
                            }
                            if (count_120_2 == 2) {
                                as_script.text = "그럼 이제 5라운드 입니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() < p_round4_point) {
                        as_script.text = "아~~ 4라운드의 승자는 핑크빈 님입니다~~!!"
                        as_image.setImageResource(R.drawable.askk)
                        pb_image.setImageResource(R.drawable.pbmerong)
                        pb_point_var++
                        pb_point.text = "${pb_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "우앙 나 이제 포인트 없다~ ㅋㅋ."
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "졌당 ㅋ"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "구라치지마~~"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "막상막하군요! 그럼 5라운드로 가겠습니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                                if (dg_point_var >= 4 || pb_point_var >= 4){
                                    point_120_next_button3.visibility = View.VISIBLE
                                }
                            }
                            count_120_2++
                        }
                    }
                }
                if (count_120 == 13) {
                    as_script.text = "담곰님, 5라운드 점수를 제출해 주십시오."
                    submit_point.visibility = View.VISIBLE
                    submit_button.visibility = View.VISIBLE
                    point_120_next_button.visibility = View.INVISIBLE
                    submit_button.setOnClickListener {
                        if (submit_point.text.toString().isEmpty()){
                            as_script.text = "빈 칸으로 제출하시면 안됩니다!!"
                        }
                        else if (submit_point.text.toString().toInt() > remain_point_var){
                            as_script.text = "지금 점수보다 큰 수를 쓰시면 안됩니다."
                        }
                        else {
                            as_script.text = "좋습니다. 두 분 모두 제출하셨군요."
                            remain_point_var -= submit_point.text.toString().toInt()
                            remain_point.text = "${remain_point_var}"
                            point_120_next_button.visibility = View.VISIBLE
                            submit_point.visibility = View.INVISIBLE
                            submit_button.visibility = View.INVISIBLE
                        }
                    }
                }
                if (count_120 == 14){
                    as_script.text = "과연 5라운드에서는 누가 이겼을까요? 공개합니다!"
                }
                if (count_120 == 15) {
                    if (submit_point.text.toString().toInt() > p_round5_point) {
                        as_script.text = "아~~ 담곰님의 승리~~!"
                        dg_point_var++
                        dg_point.text = "${dg_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE
                        dg_image.setImageResource(R.drawable.dg_proud)
                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                dg_script.text = "오예~~"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "쩝.."
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "똥줄타지? ㅋㅋ"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "6라운드로 넘어가겠습니다!"
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                                if (dg_point_var >= 4 || pb_point_var >= 4){
                                    point_120_next_button3.visibility = View.VISIBLE
                                }
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() == p_round5_point) {
                        as_script.text = "아~~ 5라운드는 동점이 나왔습니다! 두 분이 같은 생각을 하셨습니다!"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "나랑 똑같은 수를 쓰다니"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "머리 좀 쓰고있나본데?"
                            }
                            if (count_120_2 == 2) {
                                as_script.text = "좋습니다. 그럼 6라운드로 넘어가죠."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() < p_round5_point) {
                        as_script.text = "아~~ 5라운드의 승자는 핑크빈 님입니다~~!!"
                        as_image.setImageResource(R.drawable.askk)
                        pb_image.setImageResource(R.drawable.pbmerong)
                        pb_point_var++
                        pb_point.text = "${pb_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "크크."
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "껄껄"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "우잉.."
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "승부가 달아오르는군요. 그럼 6라운드로 가겠습니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                                if (dg_point_var >= 4 || pb_point_var >= 4){
                                    point_120_next_button3.visibility = View.VISIBLE
                                }
                            }
                            count_120_2++
                        }
                    }
                }
                if (count_120 == 16) {
                    as_script.text = "담곰님, 6라운드 점수를 제출해 주십시오."
                    submit_point.visibility = View.VISIBLE
                    submit_button.visibility = View.VISIBLE
                    point_120_next_button.visibility = View.INVISIBLE
                    submit_button.setOnClickListener {
                        if (submit_point.text.toString().isEmpty()){
                            as_script.text = "빈 칸으로 제출하시면 안됩니다!!"
                        }
                        else if (submit_point.text.toString().toInt() > remain_point_var){
                            as_script.text = "지금 점수보다 큰 수를 쓰시면 안됩니다."
                        }
                        else {
                            as_script.text = "좋습니다. 두 분 모두 제출하셨군요."
                            remain_point_var -= submit_point.text.toString().toInt()
                            remain_point.text = "${remain_point_var}"
                            point_120_next_button.visibility = View.VISIBLE
                            submit_point.visibility = View.INVISIBLE
                            submit_button.visibility = View.INVISIBLE
                        }
                    }
                }
                if (count_120 == 17){
                    as_script.text = "과연 6라운드에서는 누가 이겼을까요? 공개합니다!"
                }
                if (count_120 == 18) {
                    if (submit_point.text.toString().toInt() > p_round6_point) {
                        as_script.text = "아~~ 승자는 농담곰 님입니다~~!"
                        dg_point_var++
                        dg_point.text = "${dg_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE
                        dg_image.setImageResource(R.drawable.dg_proud)
                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                dg_script.text = "아싸~~"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "흠. 그걸로 좋아하다니. 나 이번에 0 적었는데 ㅋㅋ"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "응~ 안속아~"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "마지막 라운드로 넘어가겠습니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                                if (dg_point_var >= 4 || pb_point_var >= 4){
                                    point_120_next_button3.visibility = View.VISIBLE
                                }
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() == p_round6_point) {
                        as_script.text = "아~~ 6라운드는 무승부입니다!"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "호오~ 나랑 똑같은 수를 쓰다니"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "머리 좀 쓰고있나본데?"
                            }
                            if (count_120_2 == 2) {
                                as_script.text = "좋습니다. 그럼 마지막 7라운드로 넘어가죠."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() < p_round6_point) {
                        as_script.text = "아~~ 6라운드의 승자는 핑크빈 님입니다~~!!"
                        pb_image.setImageResource(R.drawable.pbmerong)
                        pb_point_var++
                        pb_point.text = "${pb_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "크크. 분발하라구."
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "나 아직도 110점 남았는데~ 껄껄"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "우잉.."
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "승부가 달아오르는군요. 그럼 마지막 라운드로 가겠습니다."
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                                if (dg_point_var >= 4 || pb_point_var >= 4){
                                    point_120_next_button3.visibility = View.VISIBLE
                                }
                            }
                            count_120_2++
                        }
                    }
                }
                if (count_120 == 19) {
                    as_script.text = "마지막 7라운드 입니다! 두분 점수를 제출해 주십시오."
                    submit_point.visibility = View.VISIBLE
                    submit_button.visibility = View.VISIBLE
                    point_120_next_button.visibility = View.INVISIBLE
                    submit_button.setOnClickListener {
                        if (submit_point.text.toString().isEmpty()){
                            as_script.text = "빈 칸으로 제출하시면 안됩니다!!"
                        }
                        else if (submit_point.text.toString().toInt() > remain_point_var){
                            as_script.text = "지금 점수보다 큰 수를 쓰시면 안됩니다."
                        }
                        else {
                            as_script.text = "좋습니다. 두 분 모두 제출하셨군요."
                            remain_point_var -= submit_point.text.toString().toInt()
                            remain_point.text = "${remain_point_var}"
                            point_120_next_button.visibility = View.VISIBLE
                            submit_point.visibility = View.INVISIBLE
                            submit_button.visibility = View.INVISIBLE
                        }
                    }
                }
                if (count_120 == 20){
                    as_script.text = "과연 마지막 라운드에서는 누가 이겼을까요? 공개합니다!"
                }
                if (count_120 == 21) {
                    if (submit_point.text.toString().toInt() > p_round7_point) {
                        as_script.text = "아~~ 승자는 농담곰 님입니다~~!"
                        dg_point_var++
                        dg_point.text = "${dg_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE
                        dg_image.setImageResource(R.drawable.dg_proud)
                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                dg_script.text = "아싸~~"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "흠.. ㅋㅋ"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "아싸 기모링~~"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "두분 모두 수고하셨습니다!"
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                                point_120_next_button3.visibility = View.VISIBLE

                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() == p_round7_point) {
                        as_script.text = "아~~ 7라운드는 동점이 나왔습니다! 두 분이 같은 생각을 하셨습니다!"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "호오~ 나랑 똑같은 수를 쓰다니"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "대단한데??"
                            }
                            if (count_120_2 == 2) {
                                as_script.text = "두분 모두 수고하셨습니다!"
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                                point_120_next_button3.visibility = View.VISIBLE

                            }
                            count_120_2++
                        }
                    }
                    if (submit_point.text.toString().toInt() < p_round7_point) {
                        as_script.text = "아~~ 7라운드의 승자는 핑크빈 님입니다~~!!"
                        pb_image.setImageResource(R.drawable.pbmerong)
                        pb_point_var++
                        pb_point.text = "${pb_point_var}"
                        point_120_next_button.visibility = View.INVISIBLE
                        point_120_next_button2.visibility = View.VISIBLE

                        var count_120_2 = 0
                        point_120_next_button2.setOnClickListener {
                            if (count_120_2 == 0) {
                                pb_script.text = "크크. 이겨버렸다~"
                            }
                            if (count_120_2 == 1) {
                                pb_script.text = "나 아직도 110점 남았는데~ 껄껄"
                            }
                            if (count_120_2 == 2) {
                                dg_script.text = "거짓말~~!"
                            }
                            if (count_120_2 == 3) {
                                as_script.text = "두분 모두 수고하셨습니다!"
                                point_120_next_button.visibility = View.VISIBLE
                                point_120_next_button2.visibility = View.INVISIBLE
                                point_120_next_button3.visibility = View.VISIBLE
                            }
                            count_120_2++
                        }
                    }
                }
                count_120++
            }

            var count_120_3 = 0
            point_120_next_button3.setOnClickListener {
                if (count_120_3 == 0){
                    as_script.text = "아닛? 게임이 끝났군요!"
                }
                if (count_120_3 == 1){
                    if (dg_point_var > pb_point_var) {
                        as_script.text = "승자는 담곰님입니다!"
                        as_image.setImageResource(R.drawable.aslaughing)
                        point_120_bgm.stop()
                    }
                    else if (dg_point_var < pb_point_var) {
                        as_script.text = "승자는 핑크빈님입니다!"
                        as_image.setImageResource(R.drawable.asking)
                        point_120_bgm.stop()
                    }
                    else {
                        as_script.text = "무승부입니다!!"
                    }
                }
                if (count_120_3 == 2){
                    if (dg_point_var > pb_point_var) {
                        dg_image.setImageResource(R.drawable.dg_proud)
                        dg_script.text = "뭐야? ㅋㅋ"
                    }
                    else if (dg_point_var < pb_point_var) {
                        pb_image.setImageResource(R.drawable.pbmerong)
                        pb_script.text = "에이 뭐야? ㅋㅋ"
                    }
                    else {
                        pb_script.text = "쩝.. 무승부가 나오다니"
                    }
                }
                if (count_120_3 == 3){
                    if (dg_point_var > pb_point_var) {
                        dg_script.text = "쉬운데? ㅋㅋ"
                    }
                    else if (dg_point_var < pb_point_var) {
                        pb_script.text = "겨우 그거밖에 안돼? ㅋㅋ"
                    }
                    else {
                        pb_script.text = "이러면 재경기를 해야겠군."
                    }
                }
                if (count_120_3 == 4){
                    if (dg_point_var > pb_point_var) {
                        pb_image.setImageResource(R.drawable.pinkbeandefault)
                        pb_script.text = "흠.. 생각보다는 잘하는군"
                    }
                    else if (dg_point_var < pb_point_var) {
                        dg_image.setImageResource(R.drawable.dgmussleangry)
                        dg_script.text = "아오.."
                    }
                    else {
                        dg_script.text = "우씨 아깝다!"
                    }
                }
                if (count_120_3 == 5){
                    if (dg_point_var > pb_point_var) {
                        pb_image.setImageResource(R.drawable.pinkbeandefault)
                        pb_script.text = "좋아 이번 게임은 통과다"
                    }
                    else if (dg_point_var < pb_point_var) {
                        pb_script.text = "ㅋㅋ 기회를 한 번 더 주지."
                    }
                    else {
                        dg_script.text = "내가 거의 다 이긴건데"
                    }
                }
                if (count_120_3 == 6){
                    if (dg_point_var > pb_point_var) {
                        pb_image.setImageResource(R.drawable.pinkbeandefault)
                        dg_script.text = "낄낄 다음 게임도 얼른 가져오라구."
                        point_120_next_button4.visibility = View.VISIBLE
                        point_120_next_button3.visibility = View.INVISIBLE
                        point_120_next_button.visibility = View.INVISIBLE
                    }
                    else if (dg_point_var < pb_point_var) {
                        pb_script.text = "다시 덤벼보라구."
                        point_120_next_button3.visibility = View.INVISIBLE
                        count_120 = -1
                        count_120_3 = -1
                    }
                    else {
                        pb_script.text = "그럼 한 판 더 하도록 하지!"
                        point_120_next_button3.visibility = View.INVISIBLE
                        count_120 = -1
                        count_120_3 = -1
                    }
                }
                count_120_3++
            }

            var count_120_4 = 0
            point_120_next_button4.setOnClickListener {
                if (count_120_4 == 0){
                    text_remain_point.visibility = View.INVISIBLE
                    remain_point.visibility = View.INVISIBLE
                    text_dg.visibility = View.INVISIBLE
                    text_pb.visibility = View.INVISIBLE
                    colon.visibility = View.INVISIBLE
                    dg_point.visibility = View.INVISIBLE
                    pb_point.visibility = View.INVISIBLE
                    pb_script.text = "흠 좋아!"
                }
                if (count_120_4 == 1){
                    pb_script.text = "두 번째 게임은 포커야!"
                }
                if (count_120_4 == 2){
                    dg_script.text = "포커?"
                }
                if (count_120_4 == 3){
                    as_script.text = "게임 규칙을 설명해 드리겠습니다."
                }
                if (count_120_4 == 4){
                    game_rule.visibility = View.VISIBLE
                    game_rule.text = "1. 1부터 10까지의 숫자카드가 2세트, 즉 총 20장의 카드를 사용한다.\n"
                }
                if (count_120_4 == 5){
                    game_rule.append("2. 플레이어 2명은 각각 30개의 칩을 갖고 시작한다.\n")
                }
                if (count_120_4 == 6){
                    game_rule.append("3. 숫자카드는 플레이어에게 각각 한 장씩 랜덤하게 주어지고, 카드의 숫자는 자신만 볼 수 있다.\n")
                }
                if (count_120_4 == 7){
                    game_rule.setText("4. 양 플레이어는 자신의 카드의 숫자를 보고 칩을 베팅한다. 베팅에는 레이즈, 콜, 다이의 세 가지중 하나를 선택할 수 있다.\n")
                }
                if (count_120_4 == 8){
                    game_rule.append("5. 레이즈 :  상대가 베팅한 칩보다 더 많은 칩을 베팅한다. \n")
                }
                if (count_120_4 == 9){
                    game_rule.append("6. 콜 : 상대가 베팅한 칩 개수만큼 베팅한다. \n")
                }
                if (count_120_4 == 10){
                    game_rule.append("7. 다이 : 베팅하지 않고 라운드를 포기한다.\n")
                }
                if (count_120_4 == 11){
                    game_rule.setText("8. 양 플레이어 중 한 명이 콜을 할 경우 양측은 카드를 공개하고, 높은 카드를 가진 사람이 베팅된 칩을 다 가져간다. \n")
                }
                if (count_120_4 == 12){
                    game_rule.append("9. 한 명이 다이를 했을 경우 카드의 숫자와는 관계 없이 다이를 한 쪽이 무조건 져서 상대가 칩을 다 가져간다. \n")
                }
                if (count_120_4 == 13){
                    game_rule.append("10. 어느 한 쪽이 칩을 모두 잃을 때까지 계속한다. \n")
                }
                if (count_120_4 == 14){
                    pb_script.text = "포커를 한 번도 안해봤으면 규칙을 이해 못 할 수도 있긴 한데.."
                }
                if (count_120_4 == 15){
                    pb_script.text = "만약 이해를 못 했다면 이 게임 개발자에게 물어보라구!"
                }
                if (count_120_4 == 16){
                    as_script.text = "그럼 게임을 시작해보죠. 준비 되셨습니까 담곰님?"
                    point_120_next_button4.visibility = View.INVISIBLE
                    poker_next_button.visibility = View.VISIBLE
                    poker()
                }
                count_120_4++
            }
        }

        var count: Int = 0
        next_button.setOnClickListener {
            if (count == 0) {
                dg_script.visibility = View.VISIBLE
            }
            if (count == 1) {
                pb_script.text = "여기까지 오다니 대단하군??"
            }
            if (count == 2) {
                pb_image.setImageResource(R.drawable.pbmerong)
                pb_script.text = "최종보스인 나를 이기면 탈출시켜주겠다"
            }
            if (count == 3) {
                dg_image.setImageResource(R.drawable.dggreenonion)
                dg_image.scaleX = -1f
                dg_script.text = "드디어 마지막이군. 무슨 대결이냐?"
            }
            if (count == 4) {
                pb_image.setImageResource(R.drawable.pinkbeandefault)
                pb_script.text = "나와 게임을 두 번 해서 두 번 모두 이기면 돼"
            }
            if (count == 5) {
                pb_script.text = "한 번이라도 지면 탈출은 없다~"
            }
            if (count == 6) {
                dg_image.setImageResource(R.drawable.dg_proud)
                dg_image.scaleX = 1f
                dg_script.text = "핑크빈 정도야, 뭐 쉽게 이길 수 있지"
            }
            if (count == 7) {
                dg_script.text = "무슨 게임이냐??"
            }
            if (count == 8) {
                pb_script.text = "첫 번째 게임은 120점 게임이야."
            }
            if (count == 9) {
                pb_script.text = "게임 룰을 설명해주지!"
            }
            if (count == 10) {
                game_rule.visibility = View.VISIBLE
                game_rule.text = "1.담곰이와 핑크빈은 모두 120점을 갖고 시작한다."
            }
            if (count == 11) {
                game_rule.text = "1.담곰이와 핑크빈은 모두 120점을 갖고 시작한다.\n2.두 사람은 총 7라운드에 걸쳐 숫자를 적어 내는데, 각 라운드는 숫자가 높은 사람이 승리한다."
            }
            if (count == 12) {
                game_rule.text = "1.담곰이와 핑크빈은 모두 120점을 갖고 시작한다.\n2.두 사람은 총 7라운드에 걸쳐 숫자를 적어 내는데, 각 라운드는 숫자가 높은 사람이 승리한다.\n3.각 라운드에 적어내는 숫자만큼 120점에서 깎인다. 즉 처음에 가진 120점을 분할해서 7라운드동안 내야 한다."
            }
            if (count == 13) {
                game_rule.text = "1.담곰이와 핑크빈은 모두 120점을 갖고 시작한다.\n2.두 사람은 총 7라운드에 걸쳐 숫자를 적어 내는데, 각 라운드는 숫자가 높은 사람이 승리한다.\n3.각 라운드에 적어내는 숫자만큼 120점에서 깎인다. 즉 처음에 가진 120점을 분할해서 7라운드동안 내야 한다.\n4.각 라운드마다 상대가 어떤 숫자를 냈는지는 알려주지 않고, 승패만 알려준다."
            }
            if (count == 14) {
                game_rule.text = "1.담곰이와 핑크빈은 모두 120점을 갖고 시작한다.\n2.두 사람은 총 7라운드에 걸쳐 숫자를 적어 내는데, 각 라운드는 숫자가 높은 사람이 승리한다.\n3.각 라운드에 적어내는 숫자만큼 120점에서 깎인다. 즉 처음에 가진 120점을 분할해서 7라운드동안 내야 한다.\n4.각 라운드마다 상대가 어떤 숫자를 냈는지는 알려주지 않고, 승패만 알려준다.\n5.4승을 거둔 사람이 게임에서 승리한다."
            }
            if (count == 15) {
                pb_script.text = "어때 게임은 간단하지? 간단하지만 머리를 써야 한다구."
            }
            if (count == 16) {
                dg_script.text = "흠.. 심리전 게임인건가.."
            }
            if (count == 17) {
                dg_script.text = "그런데 상대가 어떤 숫자를 적었는지를 안알려주면 누가 이겼는지 어떻게 아냐?"
            }
            if (count == 18) {
                pb_script.text = "그걸 위해서 심판을 한 명 준비했다구"
            }
            if (count == 19) {
                game_rule.visibility = View.INVISIBLE
                pb_script.text = "바로 우리집 집사 알송이다."
                as_image.setImageResource(R.drawable.asdefault)
                as_image.visibility = View.VISIBLE
            }
            if (count == 20) {
                as_script.text = "안녕하십니까? 핑크빈님의 집사 알송이입니다."
                as_script.visibility = View.VISIBLE
            }
            if (count == 21) {
                dg_image.setImageResource(R.drawable.dgseatdown)
                dg_script.text = "얘는 또 뭐야? 웃기게 생겼네"
            }
            if (count == 22) {
                as_script.text = "오늘 담곰님과 핑크빈님의 게임에서 제가 심판을 보겠습니다."
            }
            if (count == 23) {
                as_script.text = "당연하지만 여기 집사라고 해서 핑크빈님의 편을 들지는 않을 것입니다."
            }
            if (count == 24) {
                as_script.text = "공정한 심판을 볼 것을 약속드리죠."
            }
            if (count == 25) {
                pb_script.text = "큭큭. 봤지? 그럼 게임을 시작해볼까?"
                dg_image.setImageResource(R.drawable.ndgbboo)
                next_button.visibility = View.INVISIBLE
                point_120_next_button.visibility = View.VISIBLE
                point_120()
            }
            count++
        }
    }
}