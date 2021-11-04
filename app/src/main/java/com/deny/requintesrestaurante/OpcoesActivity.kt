package com.deny.requintesrestaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class OpcoesActivity : AppCompatActivity() {

    lateinit var logotipo: ImageView
    var auxClickLogin: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcoes)
        supportActionBar?.hide()

        logotipo = findViewById(R.id.imageViewLogoTipo)
        abrirLogin()

    }

    fun abrirLogin(){
        var intentIniciarLogin: Intent = Intent(this, LoginActivity::class.java)

        logotipo.setOnClickListener(View.OnClickListener {
            auxClickLogin += 1
            if (auxClickLogin >= 5){

                Toast.makeText(
                    this,
                    "Clique mais "+(10 - auxClickLogin),
                    Toast.LENGTH_SHORT
                ).show()

                if (auxClickLogin == 10){
                    startActivity(intentIniciarLogin)
                }
            }
        })
    }
}