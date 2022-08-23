package com.example.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*


class MainActivity : Activity() {

    private lateinit var txt_idade: EditText
    private lateinit var spn_sexo: Spinner
    private lateinit var btn_calcular: Button
    private lateinit var btn_limpar: Button
    private lateinit var btn_sair: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo o arquivo de layout
        setContentView(R.layout.activity_main)

        spn_sexo = findViewById(R.id.spn_sexo)
        txt_idade = findViewById(R.id.txt_idade)
        btn_calcular = findViewById(R.id.btn_calcular)
        btn_limpar = findViewById(R.id.btn_limpar)
        btn_sair = findViewById(R.id.btn_sair)
        var txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        val arraySpinner =listOf(" ", "masculino", "feminino")
        spn_sexo.adapter = ArrayAdapter<String>(this,R.layout.spinner,arraySpinner)

        btn_calcular.setOnClickListener {

            val sexo = spn_sexo.selectedItem as String
            val idade = txt_idade.text.toString()
            var resultado = 0
            var masculino = 70
            var feminino = 65

            try {

                if (sexo == "masculino" && idade.isNotEmpty()) {
                    resultado = (masculino - idade.toInt())
                    txt_resultado.text = ("Faltam $resultado anos para você se aposentar. ")

                } else if (sexo == "feminino" && idade.isNotEmpty()) {
                    resultado = (feminino - idade.toInt())
                    txt_resultado.text = "Faltam $resultado anos para você se aposentar. "

                }else{
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_LONG).show();
                }
            } catch (e: Throwable) {

            }

        }
        btn_limpar.setOnClickListener() {
            txt_idade.text.clear()
            txt_resultado.setText("")


        }
        btn_sair.setOnClickListener() {
            finish()

        }
    }

   }

