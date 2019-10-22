package com.paranhos.conversordemedidas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Carregar Componentes
        var btnCompri = findViewById<ImageButton>(R.id.btnComprimento)
        var btnDados = findViewById<ImageButton>(R.id.btnDados)
        var btnTemperatura = findViewById<ImageButton>(R.id.btnTemperatura)
        var btnPeso = findViewById<ImageButton>(R.id.btnPeso)


        btnCompri.setOnClickListener {
            var intent = Intent(this, ConversorComprimento::class.java)
            startActivity(intent)
        }


        btnDados.setOnClickListener {
            var intent = Intent(this, ConversorDados::class.java)
            startActivity(intent)
        }

        btnTemperatura.setOnClickListener {
            var intent = Intent(this, ConversorTemperatura::class.java)
            startActivity(intent)
        }

        btnPeso.setOnClickListener{
            var intent = Intent(this, ConverterPeso::class.java)
            startActivity(intent)
        }
    }
}
