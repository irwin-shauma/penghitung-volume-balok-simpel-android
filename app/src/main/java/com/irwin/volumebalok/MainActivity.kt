package com.irwin.volumebalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var editPanjang: EditText
    lateinit var editLebar : EditText
    lateinit var editTinggi : EditText
    lateinit var buttonCalculate : Button
    lateinit var tvResult : TextView

    companion object{
        private const val QUERY = "query"
    }

    private val query: String? = null

    // Inisialisasi komponen
    private fun initComponents(){
        editPanjang = findViewById(R.id.edit_panjang)
        editLebar= findViewById(R.id.edit_lebar)
        editTinggi = findViewById(R.id.edit_tinggi)
        buttonCalculate = findViewById(R.id.button_kalkulasi)
        tvResult = findViewById(R.id.tv_hasil)
    }

    // Listener untuk button
    private fun initListener(){
        buttonCalculate.setOnClickListener {
                val inputPanjang = editPanjang.text.toString().trim()
                val inputLebar = editLebar.text.toString().trim()
                val inputTinggi = editTinggi.text.toString().trim()
                when{
                    inputPanjang.isEmpty() -> Toast.makeText(this, "Empty field Panjang not allowed!", Toast.LENGTH_SHORT).show()
                    inputLebar.isEmpty() -> Toast.makeText(this, "Empty field Lebar not allowed!", Toast.LENGTH_SHORT).show()
                    inputTinggi.isEmpty() -> Toast.makeText(this, "Empty field Tinggi not allowed!", Toast.LENGTH_SHORT).show()
                    else -> {
                        val volumeTotal = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                        tvResult.text = volumeTotal.toString()
                    }
                }


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initListener()

        when{
            savedInstanceState != null ->{
                val hasil = savedInstanceState.getString(QUERY)
                tvResult.text = hasil
            }
        }

        fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            outState.putString(QUERY, tvResult.text.toString())
        }

    }



}