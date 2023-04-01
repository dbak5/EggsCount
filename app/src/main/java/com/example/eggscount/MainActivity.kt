package com.example.eggscount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

/*
Name: DaHye Baker
ID: 30063368
Assessment 1: Activity 5
*/

class MainActivity : AppCompatActivity() {

    // Create custom eggception - no number entereds
    class NoEggsException(message: String) : Exception(message)

    // Set numbers for eggs
    private val GROSS_EGGS = 144
    private val DOZEN_EGGS = 12
    private var numberEggs = 0

    // Text view variable as null
    private var textViewResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.textViewResult)

        //region exceptions and button update function

        //region Functions

        // No egg number entered - exception
        fun noEggsException(numberEggs: Int) {
            if (numberEggs <= 0 || numberEggs.toString().isEmpty())
                throw NoEggsException(getString(R.string.NothingDelete))
        }

        // Update the egg number in the text view
        fun updateEggNumber(v: View) {
            numberEggs = numberEggs * 10 + ((v as Button).text).toString().toInt()
            textViewResult?.text = numberEggs.toString()
        }

        //endregion

        //region Enter and Delete Buttons

        // Enter button to calculate the gross, dozen or single eggs
        val btnEnter = findViewById<Button>(R.id.btnEnter)
        btnEnter.setOnClickListener {
            try {
                noEggsException(numberEggs)
                val grossAmt = numberEggs / GROSS_EGGS
                val remainingAfterGross = numberEggs % GROSS_EGGS
                val dozenAmt = remainingAfterGross / DOZEN_EGGS
                val singleEggs = remainingAfterGross % DOZEN_EGGS
                textViewResult?.text =
                    "There are $numberEggs eggs. That is $grossAmt gross(es), $dozenAmt dozen(s) and $singleEggs single eggs"
            } catch (e: NoEggsException) {
                Snackbar.make(it, "Error, please enter a valid number", Snackbar.LENGTH_LONG).show()
            }
        }

        // Delete button to remove the last digit from number eggs
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        btnDelete.setOnClickListener {
            try {
                noEggsException(numberEggs)
                val numberEggsString = numberEggs.toString()
                if (numberEggsString.length == 1) {
                    numberEggs = 0
                    textViewResult?.text = getString(R.string.enter_egg)
                } else {
                    numberEggs = numberEggsString.dropLast(1).toInt()
                    textViewResult?.text = numberEggs.toString()
                }
            } catch (e: NumberFormatException) {
                Snackbar.make(it, getString(R.string.NothingDelete), Snackbar.LENGTH_LONG).show()
            } catch (e: NoEggsException) {
                Snackbar.make(it, getString(R.string.NothingDelete), Snackbar.LENGTH_LONG).show()
            }
        }
        //endregion

        //region Number buttons
        val btn1 = findViewById<Button>(R.id.btnOne)
        btn1.setOnClickListener { updateEggNumber(it) }
        val btn2 = findViewById<Button>(R.id.btnTwo)
        btn2.setOnClickListener { updateEggNumber(it) }
        val btn3 = findViewById<Button>(R.id.btnThree)
        btn3.setOnClickListener { updateEggNumber(it) }
        val btn4 = findViewById<Button>(R.id.btnFour)
        btn4.setOnClickListener { updateEggNumber(it) }
        val btn5 = findViewById<Button>(R.id.btnFive)
        btn5.setOnClickListener { updateEggNumber(it) }
        val btn6 = findViewById<Button>(R.id.btnSix)
        btn6.setOnClickListener { updateEggNumber(it) }
        val btn7 = findViewById<Button>(R.id.btnSeven)
        btn7.setOnClickListener { updateEggNumber(it) }
        val btn8 = findViewById<Button>(R.id.btnEight)
        btn8.setOnClickListener { updateEggNumber(it) }
        val btn9 = findViewById<Button>(R.id.btnNine)
        btn9.setOnClickListener { updateEggNumber(it) }
        val btn0 = findViewById<Button>(R.id.btnZero)
        btn0.setOnClickListener { updateEggNumber(it) }
        //endregion

        //endregion

        //region no exception and button function

//        //region Enter and Delete Buttons
//
//        // Enter button to calculate the gross, dozen or single eggs
//        val btnEnter = findViewById<Button>(R.id.btnEnter)
//        btnEnter.setOnClickListener {
//            if (numberEggs == 0 || numberEggs.toString().isEmpty()) {
//                Snackbar.make(it, "Error, please enter a valid number", Snackbar.LENGTH_LONG).show()
//            } else {
//                var btnEnter = findViewById<Button>(R.id.btnEnter)
//                val grossAmt = numberEggs / GROSS_EGGS
//                val remainingAfterGross = numberEggs % GROSS_EGGS
//                val dozenAmt = remainingAfterGross / DOZEN_EGGS
//                val singleEggs = remainingAfterGross % DOZEN_EGGS
//                textViewResult?.text =
//                    "There are $numberEggs eggs. That is $grossAmt gross(es), $dozenAmt dozen(s) and $singleEggs single eggs"
//            }
//        }
//
//        // Delete button to remove the last digit from number eggs
//        val btnDelete = findViewById<Button>(R.id.btnDelete)
//        btnDelete.setOnClickListener {
//            try {
//                val numberEggsString = numberEggs.toString()
//                if (numberEggs == 0 || numberEggsString.isEmpty()){
//                    Snackbar.make(it, getString(R.string.NothingDelete), Snackbar.LENGTH_LONG).show()
//                }
//                else{
//                    if (numberEggsString.length == 1) {
//                        numberEggs = 0
//                        textViewResult?.text = getString(R.string.enter_egg)
//                    } else {
//                        numberEggs =
//                            numberEggsString.substring(0, numberEggsString.length - 1).toInt()
//                        textViewResult?.text = numberEggs.toString()
//                    }
//                }
//            } catch (e: NumberFormatException) {
//                Snackbar.make(it, getString(R.string.NothingDelete), Snackbar.LENGTH_LONG).show()
//            }
//        }
//        //endregion
//
//        //region Number buttons
//
//        var btn1 = findViewById<Button>(R.id.btnOne)
//        btn1.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        var btn2 = findViewById<Button>(R.id.btnTwo)
//        btn2.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        var btn3 = findViewById<Button>(R.id.btnThree)
//        btn3.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        var btn4 = findViewById<Button>(R.id.btnFour)
//        btn4.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        var btn5 = findViewById<Button>(R.id.btnFive)
//        btn5.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        var btn6 = findViewById<Button>(R.id.btnSix)
//        btn6.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        var btn7 = findViewById<Button>(R.id.btnSeven)
//        btn7.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        var btn8 = findViewById<Button>(R.id.btnEight)
//        btn8.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        var btn9 = findViewById<Button>(R.id.btnNine)
//        btn9.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        var btn0 = findViewById<Button>(R.id.btnZero)
//        btn0.setOnClickListener {
//            numberEggs = numberEggs * 10 + ((it as Button).text).toString().toInt()
//            textViewResult?.text = numberEggs.toString()
//        }
//        //endregion

        //endregion
    }
}


