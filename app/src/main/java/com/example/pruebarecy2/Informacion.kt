package com.example.pruebarecy2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Informacion : AppCompatActivity() {
    var id:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        val bundle = intent.extras
        val resultado = bundle?.getInt("resultados", 0)

        //val operacion = bundle?.getInt("resultado", 0)
        //val resultado = bundle?.getDouble("resultado", 0.0)
        Toast.makeText(this, resultado.toString(), Toast.LENGTH_SHORT).show()
      //  Toast.makeText(this,"hola",Toast.LENGTH_LONG).show()
       /* if(savedInstanceState == null){

            val bundle = intent.extras
            if(bundle != null){
                id = bundle.getInt("ID", 0)

                Toast.makeText(this,"hola",Toast.LENGTH_LONG).show()
            }
        }else{
            id = savedInstanceState.getSerializable("ID") as Int
        }
        */

    }


    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }
}