package sv.edu.udb.beautyapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class RegistrarCita : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var  drawer: DrawerLayout
    private lateinit var  toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_cita)
        val toolbar: androidx.appcompat.widget.Toolbar= findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer=findViewById(R.id.drawer_layout)
        toogle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        val agendarcita = findViewById<Button>(R.id.agregarcita)
        agendarcita.setOnClickListener {
            //asignando valores
            val builder = AlertDialog.Builder(this@RegistrarCita)
            val view =  layoutInflater.inflate(R.layout.confirmacioncita,null)
            //val hide =  findViewById<Button>(R.id.citaok)
            //pasando la vista al builder
            builder.setView(view)
            //creando dialogo
            val dialogo = builder.create()
            dialogo.show()
        }
        //calendario
        val etfecha =findViewById<EditText>(R.id.etfecha)
        etfecha.setOnClickListener{
            showDatePickerDialog()
        }

        //Hora

        val ethora = findViewById<EditText>(R.id.ethora)
        ethora.setOnClickListener {
            showTimePickerDialog()
        }
        //spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val lista= arrayOf("Selecciona Sucursal","Centro Comercial Bambu","La Gran Via","Multiplaza")
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,lista)
        spinner.adapter =adaptador1



    }
    //funcion para el timer
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment{time->onTimeSelected(time)}
        timePicker.show(supportFragmentManager,"time")
    }
    private fun onTimeSelected(time:String){
        val  ettime =  findViewById<EditText>(R.id.ethora)
        ettime.setText("${time}")

    }

    //Funciona para el Spinner


    //funciones para el calendario
    private fun showDatePickerDialog() {
        val datePicker =  DatePickerFragment{day, month, year ->  onDateSelected(day,month,year)}
        datePicker.show(supportFragmentManager,"datePicker")
    }

    fun onDateSelected  (day:Int,month:Int,year:Int){
        val etdate = findViewById<EditText>(R.id.etfecha)
        etdate.setText("${day},${month},${year}")

    }
    //fin funciones calendario
    //funciones menu
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_one -> {
                val Intent = Intent(this,MainActivity::class.java)
                startActivity(Intent)

            }
            R.id.nav_item_two -> {
                val intent  =  Intent(this,RegistrarCita::class.java)
                startActivity(intent)

            }
            R.id.nav_item_three -> {
                val intent  =  Intent(this,Sucursale::class.java)
                startActivity(intent)
            }
            R.id.nav_item_fourth -> {
                val intent  =  Intent(this,Productos::class.java)
                startActivity(intent)
            }
            R.id.prueba -> {
                val intent  =  Intent(this,Facturacion::class.java)
                startActivity(intent)
            }
            R.id.logout -> {
                Toast.makeText(this,"Has cerrado session",Toast.LENGTH_SHORT).show()
                val intent  =  Intent(this,Login::class.java)
                startActivity(intent)
            }

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onPostCreate(savedInstanceState: Bundle?){
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    //fin funciones menu
}