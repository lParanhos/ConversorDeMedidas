package com.paranhos.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlin.Double as Doublel

class ConverterPeso : AppCompatActivity() {

    var unidades = arrayOf("Miligrama (mg)", "Centigrama (cg)", "Grama (g)", "Quilograma (kg)")
    var selecao = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_peso)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //carregar os componetes
        val spinner = findViewById<Spinner>(R.id.select)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val btnCalcular = findViewById<Button>(R.id.btnConverter)

        //cria o meu arrayAdapter
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
                    //miligrama
                    var texto = " Centigrama = "
                    texto +=  Double.parseDouble(valor)/ 10f
                    texto += "cg \n Grama = "
                    texto += Double.parseDouble(valor) / 1000f
                    texto += "g \n Quilograma = "
                    texto += Double.parseDouble(valor) / 1000000f
                    texto += "kg"

                    txtResultado.text = texto

                }else if(selecao == 1){
                    //centimetro
                    var texto = " Miligrama = "
                    texto +=  Double.parseDouble(valor)* 10f
                    texto += "mg \n Grama = "
                    texto += Double.parseDouble(valor) / 100f
                    texto += "g \n Quilograma = "
                    texto += Double.parseDouble(valor) / 100000f
                    texto += "kg"

                    txtResultado.text = texto

                }else if(selecao == 2){
                    //metro
                    var texto = " Miligrama = "
                    texto +=  Double.parseDouble(valor)* 1000f
                    texto += "mg \n Centigrama = "
                    texto += Double.parseDouble(valor) * 100f
                    texto += "cg \n Quilograma = "
                    texto += Double.parseDouble(valor) / 1000f
                    texto += "kg"

                    txtResultado.text = texto

                }else if(selecao == 3){
                    //Quilometro

                    var texto = " Miligrama = "
                    texto +=  Double.parseDouble(valor)* 1000000f
                    texto += "mg \n Centigrama = "
                    texto += Double.parseDouble(valor) * 100000f
                    texto += "cg \n Grama = "
                    texto += Double.parseDouble(valor) * 1000f
                    texto += "g"

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
