package sv.edu.udb.beautyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
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
            if (correo.text.toString().isEmpty() && contrasena.text.toString().isEmpty()){
                Toast.makeText(this,"Porfavor Ingrese correo y contraseña",Toast.LENGTH_SHORT).show()
            }else{

                Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}