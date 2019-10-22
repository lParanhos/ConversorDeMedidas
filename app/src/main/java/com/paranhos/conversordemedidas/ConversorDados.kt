package com.paranhos.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlin.Double as Doublel

class ConversorDados : AppCompatActivity() {

    var unidades = arrayOf("Byte (b)", "Quilobyte (kb)", "MegaByte (mb)", "Gigabyte (gb)")
    var selecao = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_dados)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //carrega os componentes
        val spinner = findViewById<Spinner>(R.id.select)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val btnCalcular = findViewById<Button>(R.id.btnConverter)

        //Cria arrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unidades)
        spinner.adapter = adapter



        spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {  }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selecao = position
            }

        }

        btnCalcular.setOnClickListener {
            val valor = txtValor.text.toString()
            if(valor != ""){
                if(selecao == 0){
                    var texto = " Kilobyte = "
                    texto +=  Double.parseDouble(valor)/ 1000f
                    texto += "kb \n MegaByte = "
                    texto += Double.parseDouble(valor) / 1000000f
                    texto += "mb \n Gigabyte = "
                    texto += Double.parseDouble(valor) / 1000000000f
                    texto += "gb"

                    txtResultado.text = texto

                }else if(selecao == 1){
                    var texto = " Byte = "
                    texto +=  Double.parseDouble(valor)* 1000f
                    texto += "b \n MegaByte = "
                    texto += Double.parseDouble(valor) / 1000f
                    texto += "mb \n GigaByte = "
                    texto += Double.parseDouble(valor) / 1000000f
                    texto += "gb"

                    txtResultado.text = texto

                }else if(selecao == 2){
                    var texto = " Byte = "
                    texto +=  Double.parseDouble(valor)* 1000000f
                    texto += "b \n KiloByte = "
                    texto += Double.parseDouble(valor) * 1000f
                    texto += "kb \n GigaByte = "
                    texto += Double.parseDouble(valor) / 1000f
                    texto += "gb"

                    txtResultado.text = texto

                }else if(selecao == 3){
                    var texto = " Byte = "
                    texto +=  Double.parseDouble(valor)* 1000000000f
                    texto += "b \n KiloByte = "
                    texto += Double.parseDouble(valor) * 1000000f
                    texto += "kb \n MegaByte = "
                    texto += Double.parseDouble(valor) * 1000f
                    texto += "mb"

                    txtResultado.text = texto
                }

            } else {
                txtResultado.text = "Adicione um valor para ser Convertido."
            }
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
