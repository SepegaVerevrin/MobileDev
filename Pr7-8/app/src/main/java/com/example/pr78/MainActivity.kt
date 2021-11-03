package com.example.pr78

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val RESULT="RESULT"
    }
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById<TextView>(R.id.textView3)

        if (savedInstanceState!=null) {
            result.text=savedInstanceState.getInt(RESULT).toString()
        }

        val firstNamber = findViewById<EditText>(R.id.editTextNumber)
        if (firstNamber.text!=null) {

            val button = findViewById<Button>(R.id.button)
            button.setOnClickListener {
                var tmp = firstNamber.text.toString().toInt()
                var res = ""
                while (tmp >= 1) {
                    res += (tmp % 2)
                    tmp /= 2
                }
                result.text = (res.reversed())
            }

            val button2 = findViewById<Button>(R.id.button2)
            button2.setOnClickListener {
                var tmp = firstNamber.text.toString().toInt()
                var res = ""
                while (tmp >= 1) {
                    res += (tmp % 8)
                    tmp /= 8
                }
                result.text = (res.reversed())
            }

            val button3 = findViewById<Button>(R.id.button3)
            button3.setOnClickListener {
                var tmp = firstNamber.text.toString().toInt()
                var res = ""
                while (tmp >= 1) {
                    when (tmp % 16) {
                        in 0..9 -> res += (tmp % 16)
                        in 10..15 -> res = res + ((tmp % 16) + 17 + 48 - 10).toChar()
                    }
                    tmp /= 16
                }
                result.text = (res.reversed())
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (result.text != "") {
            outState.putInt(RESULT, result.text.toString().toInt())
        }
    }

}

//    override fun onPause() {
//        super.onPause()
//    }
//
//    override fun onStart() {
//        super.onStart()
//    }
//
//    override fun onResume() {
//        super.onResume()
//    }
//
//    override fun onStop() {
//        super.onStop()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//    }


//val spinner = findViewById<Spinner>(R.id.spinner)
//        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
//                // Display the selected item text on text view
//                val selected  = parent.getItemAtPosition(position).toString()
//
//                val button=findViewById<Button>(R.id.button)
//                button.setOnClickListener {
//                    val firstNamber = findViewById<EditText>(R.id.editTextNumber)
//
//                    result.text = (firstNamber.text.toString().toInt()+selected.toInt()).toString()
//                }
//            }
//            override fun onNothingSelected(parent: AdapterView<*>){
//                // Another interface callback
//            }
//        }