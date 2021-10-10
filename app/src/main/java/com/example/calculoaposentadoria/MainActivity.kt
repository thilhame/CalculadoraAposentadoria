package com.example.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text


class MainActivity: Activity() {

private lateinit var txt_idade:EditText
private lateinit var spn_sexo:Spinner
private lateinit var btn_calcular:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo o arquivo de layout
        setContentView(R.layout.activity_main)

         spn_sexo = findViewById(R.id.spn_sexo)
         txt_idade = findViewById(R.id.txt_idade)
         btn_calcular = findViewById(R.id.btn_calcular)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
        listOf(" ","masculino", "feminino"))





        btn_calcular.setOnClickListener{



            val sexo = spn_sexo.selectedItem as String
            val idade = txt_idade.text.toString()
            var resultado = 0
            var masculino = 70
            var feminino = 65





            if ( sexo == "masculino" && idade.isNotEmpty()){
                resultado = (masculino - idade.toInt())
                txt_resultado.text = "Faltam $resultado anos para você se aposentar . "


            }else{
                Toast.makeText(getApplicationContext(),"Preencha todos os campos",Toast.LENGTH_SHORT).show();
                validarDados()
            }


            if(sexo == "feminino" && idade.isNotEmpty()){
                resultado = (feminino - idade.toInt())
                txt_resultado.text = "Faltam $resultado anos para você se aposentar . "

            }else{
                Toast.makeText(getApplicationContext(),"Preencha todos os campos",Toast.LENGTH_SHORT).show();
                validarDados()
            }



        }

    }

    private fun validarDados() : Boolean {

            var error = false
            if (txt_idade.text.isEmpty()) {
                txt_idade.error = "obrigatorio preencher campos!"
                error = true
            }
            return error

        }

    }

