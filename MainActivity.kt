package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 레이아웃에서 버튼을 찾음
        val rollButton: Button = findViewById(R.id.button)

        // 버튼에 클릭 리스너를 설정해 유저가 버튼을 누를 때 주사위를 굴릴 수 있도록 설정
        rollButton.setOnClickListener { rollDice() }

        // 앱이 시작될 때 주사위 굴리기 시행
        rollDice()
    }

    private fun rollDice() {
        // 새로운 6면 주사위 생성, 주사위 굴리기
        val dice = Dice(6)
        val diceRoll = dice.roll()
        
        /*val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
        텍스트뷰를 통한 주사위 결과 표시하는 방법*/
        
        // 이미지뷰를 활용한 주사위 결과 표시
        val diceImage : ImageView = findViewById(R.id.imageView)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        //6->...으로 코드 작성시 주사위 면 수가 6을 넘어가는 경우 오류 발생 가능, 오류 방지를 위함
        }
        diceImage.setImageResource(drawableResource) // setImageResource()를 사용해 이미지뷰에 표시되는 이미지 변경
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}