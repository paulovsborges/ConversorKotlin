package com.example.conversoskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_price
        edit_amount
        text_valueF
        button_calculate.setOnClickListener(this)


    }


    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.button_calculate) {
            calculate()
        }

    }

    private fun calculate () {
       if(validationOK()) {


           val price = edit_price.text.toString().toFloat()
           val amount = edit_amount.text.toString().toFloat()
           val valueF = price * amount

           text_valueF.text = "o valor total é de: ${"%.2f".format(valueF)}"

       } else (Toast.makeText(this, "todos os campos são obrigatórios", Toast.LENGTH_LONG).show())
    }

    private fun validationOK(): Boolean {
        return (edit_price.text.toString() != "" && edit_amount.text.toString() != "")
    }
}