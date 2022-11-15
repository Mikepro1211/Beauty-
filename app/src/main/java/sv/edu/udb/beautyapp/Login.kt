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

class Login : AppCompatActivity() {
    //instancia de google authenticator
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //firebase
        auth = Firebase.auth
        //llamando espacions
        val correo = findViewById<EditText>(R.id.txtEmail)
        val contrasena = findViewById<EditText>(R.id.TxtPassword)
        val nuevaCuenta = findViewById<TextView>(R.id.UsuarioNuevo)
        val botonIngresar =  findViewById<Button>(R.id.buttonIngresar)

        nuevaCuenta.setOnClickListener{
            Toast.makeText(this,"Crea tu cuenta",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,Registro::class.java)
            startActivity(intent)
        }

        botonIngresar.setOnClickListener {
            performLogin()
            }
        }

    private fun performLogin() {
        //obtener informacion desde el usuario
        val correo = findViewById<EditText>(R.id.txtEmail)
        val contrasena = findViewById<EditText>(R.id.TxtPassword)

        if (correo.text.isEmpty()||contrasena.text.isEmpty()) {
            Toast.makeText(this, "Porfavor rellene los campos", Toast.LENGTH_SHORT).show()
            return
        }
         val emailInput = correo.text.toString()
         val passwordInput = contrasena.text.toString()

        auth.signInWithEmailAndPassword(emailInput, passwordInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                     val intent =  Intent (this,MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Se ha iniciado session con exito",
                        Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Fallo autenticación.",
                        Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener{
                Toast.makeText(baseContext, "Fallo  autenticación. ${it.localizedMessage}",
                    Toast.LENGTH_SHORT).show()
            }
        }

}
