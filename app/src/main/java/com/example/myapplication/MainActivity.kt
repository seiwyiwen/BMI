package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate =findViewById<View>(R.id.buttonCalculate)
        val btnReset =findViewById<View>(R.id.buttonReset)

        buttonReset.setOnClickListener(){
            txtWeight.setText("")
            txtHeight.setText("")
            textBmi.setText("")
            imageView.setImageResource(R.drawable.empty)
            txtWeight.requestFocus()

        }
        buttonCalculate.setOnClickListener(){
            val weight =  txtWeight.text.toString().toDouble()
            val height = txtHeight.text.toString().toDouble()

            val bmi:Double = weight / (height * height)
            val size:String

            if(bmi <18.5){
                size = "Under"
                textBmi.text ="%.2f".format(bmi)
                txtSize.text = size
                imageView.setImageResource(R.drawable.under)
            }else if(bmi >= 18.5 && bmi <=24.9){
                size = "Normal"
                textBmi.text ="%.2f".format(bmi)
                txtSize.text = size
                imageView.setImageResource(R.drawable.normal)

            }else{
                size = "Over"
                textBmi.text ="%.2f".format(bmi)
                txtSize.text = size
                imageView.setImageResource(R.drawable.over)
            }
        }
    }
}
