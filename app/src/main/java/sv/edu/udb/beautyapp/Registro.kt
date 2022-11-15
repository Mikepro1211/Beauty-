package sv.edu.udb.beautyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registro : AppCompatActivity() {
    //instancia de google autenticator
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        //variables del formulario
        val correo = findViewById<EditText>(R.id.txtEmail)
        val contrasena =  findViewById<EditText>(R.id.TxtPassword)
        val  numero = findViewById<EditText>(R.id.etTelefono)
        val btnRegistrar =findViewById<Button>(R.id.buttonRegistrar)
        val tengoCuenta =  findViewById<TextView>(R.id.UsuarioNuevo)
        //firebase
        // Initialize Firebase Auth
       auth = Firebase.auth
        btnRegistrar.setOnClickListener {
            performSignUp()
        }
        tengoCuenta.setOnClickListener {
            val intent =  Intent(this,Login::class.java)
            startActivity(intent)
            Toast.makeText(this,"Ingresa tus datos",Toast.LENGTH_SHORT).show()
        }
        //obtenemos el email and use
    }

    private fun performSignUp() {
        val email = findViewById<EditText>(R.id.txtEmail)
        val password =  findViewById<EditText>(R.id.TxtPassword)
        //validacion
        if(email.text.isEmpty()|| password.text.isEmpty()){
            Toast.makeText(this,"Porfavor no dejes campos vacios",Toast.LENGTH_SHORT).show()
            return
        }
        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success,
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, " Informacion agregada.",
                        Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener{
                Toast.makeText(this,"Ocurrio algun error  ${it.localizedMessage}",Toast.LENGTH_SHORT).show()
            }
    }


}