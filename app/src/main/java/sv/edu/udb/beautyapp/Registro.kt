package sv.edu.udb.beautyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        //variables del formulario
        val correo = findViewById<EditText>(R.id.txtEmail)
        val contrasena =  findViewById<EditText>(R.id.TxtPassword)
        val  numero = findViewById<EditText>(R.id.etTelefono)
        val btnRegistrar =findViewById<Button>(R.id.buttonRegistrar)
        val tengoCuenta =  findViewById<TextView>(R.id.UsuarioNuevo)


        btnRegistrar.setOnClickListener {
            if (correo.text.toString().isEmpty()&&contrasena.text.toString().isEmpty()&&numero.text.toString().isEmpty()){
                Toast.makeText(this,"Porfavor Igresa todos los datos",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Informacion registrada",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }


        }
        tengoCuenta.setOnClickListener {
            val intent =  Intent(this,Login::class.java)
            startActivity(intent)
            Toast.makeText(this,"Ingresa tus datos",Toast.LENGTH_SHORT).show()
        }

    }
}