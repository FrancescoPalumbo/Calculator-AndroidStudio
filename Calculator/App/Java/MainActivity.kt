package it.uniparthenope.studenti.francescopalumbo004.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener { appendOnExpresstion("1", true)}
        tvTwo.setOnClickListener { appendOnExpresstion("2", true)}
        tvThree.setOnClickListener { appendOnExpresstion("3", true)}
        tvFour.setOnClickListener { appendOnExpresstion("4", true)}
        tvFive.setOnClickListener { appendOnExpresstion("5", true)}
        tvSix.setOnClickListener { appendOnExpresstion("6", true)}
        tvSeven.setOnClickListener { appendOnExpresstion("7", true)}
        tvEight.setOnClickListener { appendOnExpresstion("8", true)}
        tvNine.setOnClickListener { appendOnExpresstion("9", true)}
        tvZero.setOnClickListener { appendOnExpresstion("0", true)}
        tvDot.setOnClickListener { appendOnExpresstion(".", true)}

        //Operators
        tvPlus.setOnClickListener {appendOnExpresstion("+", false)}
        tvMinus.setOnClickListener {appendOnExpresstion("-", false)}
        tvMult.setOnClickListener {appendOnExpresstion("*", false)}
        tvDivide.setOnClickListener {appendOnExpresstion("/", false)}
        tvOpen.setOnClickListener {appendOnExpresstion("(", false)}
        tvClose.setOnClickListener {appendOnExpresstion(")", false)}

        tvClear.setOnClickListener {
            tvExpresstion.text = ""
            tvResult.text = ""
        }


        tvBack.setOnClickListener {
            val string = tvExpresstion.text.toString()
            if(string.isNotEmpty()) {
                tvExpresstion.text = string.substring(0,string.length-1)
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpresstion.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()
            }catch (e:Exception){
                Log.d("Exception", "message : " + e.message)
            }
        }

    }

    fun appendOnExpresstion(str: String, canClear : Boolean){

        if(tvResult.text.isNotEmpty()){
            tvExpresstion.text=""
        }

        if(canClear){
            tvResult.text = ""
            tvExpresstion.append(str)
        }else{
            tvExpresstion.append(tvResult.text)
            tvExpresstion.append(str)
            tvResult.text = ""
        }
    }

}
