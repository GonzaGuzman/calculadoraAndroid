package com.zalo.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num1 = 0.0
    private var num2 = 0.0
    private var operation = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_0.setOnClickListener { numberPress("0") }
        button_1.setOnClickListener { numberPress("1") }
        button_2.setOnClickListener { numberPress("2") }
        button_3.setOnClickListener { numberPress("3") }
        button_4.setOnClickListener { numberPress("4") }
        button_5.setOnClickListener { numberPress("5") }
        button_6.setOnClickListener { numberPress("6") }
        button_7.setOnClickListener { numberPress("7") }
        button_8.setOnClickListener { numberPress("8") }
        button_9.setOnClickListener { numberPress("9") }

        button_point.setOnClickListener { numberPress(".") }

        button_plus.setOnClickListener { operationPress(SUMA) }
        button_minus.setOnClickListener { operationPress(RESTA) }
        button_multiplication.setOnClickListener { operationPress(MULTIPLICACION) }
        button_division.setOnClickListener { operationPress(DIVISION) }
        button_clear.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultView.text = ""
            operation = NO_OPERATION
        }

        button_equals.setOnClickListener {
            var result = when (operation) {
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> if (num2 != 0.0) num1 / num2 else 0.0
                else -> 0
            }
            resultView.text = result.toString()
        }

    }


    private fun numberPress(digit: String) {
        resultView.text = "${resultView.text}$digit"
        if (operation == NO_OPERATION) {
            num1 = resultView.text.toString().toDouble()
        } else {
            num2 = resultView.text.toString().toDouble()
        }

    }

    private fun operationPress(operacion: Int) {
        this.operation = operacion
        resultView.text = ""

    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERATION = 0
    }


}