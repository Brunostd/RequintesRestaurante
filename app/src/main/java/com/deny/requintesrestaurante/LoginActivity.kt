package com.deny.requintesrestaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isInvisible
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.*
import java.lang.Exception

class LoginActivity : AppCompatActivity() {

    var             firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    lateinit var     buttonLogin: Button
    lateinit var buttonCadastrar: Button
    lateinit var     recebeEmail: EditText
    lateinit var     recebeSenha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        buttonLogin      = findViewById(R.id.buttonEntrar)
        buttonCadastrar  = findViewById(R.id.buttonCadastrar)
        recebeEmail      = findViewById(R.id.editTextLoginEmail)
        recebeSenha      = findViewById(R.id.editTextLoginSenha)

        buttonCadastrar.isInvisible = true

        /*buttonCadastrar.setOnClickListener(View.OnClickListener {
            cadastrar()
        })*/

        buttonLogin.setOnClickListener(View.OnClickListener {
            login()
        })
    }

    fun login(){
        if (!recebeEmail.text.toString().isEmpty()){
            if (!recebeSenha.text.toString().isEmpty()){

                var auxEmail: String = recebeEmail.text.toString()
                var auxSenha: String = recebeSenha.text.toString()

                firebaseAuth.signInWithEmailAndPassword(auxEmail, auxSenha).addOnCompleteListener(
                    OnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(
                                this,
                                "Login feito com sucesso",
                                Toast.LENGTH_SHORT
                            ).show()

                            val intent2 = Intent(this, CardapioActivity::class.java)
                            startActivity(intent2)
                            finish()

                        } else {
                            var excecao = ""
                            try {
                                throw it.exception!!
                            } catch (e: FirebaseAuthInvalidCredentialsException) {
                                excecao = "E-mail ou senha não corresponde a um usuario cadastrado"
                            } catch (e: FirebaseAuthInvalidUserException) {
                                excecao = "Usuario não está cadastrado"
                            } catch (e: Exception) {
                                excecao = "Erro ao fazer login" + e.message
                                e.printStackTrace()
                            }
                            Toast.makeText(
                                this,
                                excecao,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })

            }else{
                Toast.makeText(
                    this,
                    "Digite alguma senha",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else{
            Toast.makeText(
                this,
                "Digite algum email",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    /*fun cadastrar(){
        if (!recebeEmail.text.toString().isEmpty()){
            if (!recebeSenha.text.toString().isEmpty()){

                var auxEmail: String = recebeEmail.text.toString()
                var auxSenha: String = recebeSenha.text.toString()

                firebaseAuth.createUserWithEmailAndPassword(auxEmail, auxSenha).addOnCompleteListener(
                    OnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(
                                this,
                                "Cadastrado com sucesso",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            var excecao = ""
                            try {
                                throw it.exception!!
                            } catch (e: FirebaseAuthWeakPasswordException) {
                                excecao = "Digite uma senha mais forte"
                            } catch (e: FirebaseAuthInvalidCredentialsException) {
                                excecao = "Digite um e-mail válido"
                            } catch (e: FirebaseAuthUserCollisionException) {
                                excecao = "Este usuario já existe"
                            } catch (e: Exception) {
                                excecao = "Erro ao cadastrar usuario" + e.message
                                e.printStackTrace()
                            }
                            Toast.makeText(
                                this,
                                excecao,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })

            } else{
                Toast.makeText(
                    this,
                    "Digite uma senha",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else{
            Toast.makeText(
                this,
                "Digite um email",
                Toast.LENGTH_SHORT
            ).show()
        }
    }*/
}