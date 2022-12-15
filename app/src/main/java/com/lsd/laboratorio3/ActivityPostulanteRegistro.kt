package com.lsd.laboratorio3
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ActivityPostulanteRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postulante_registro)

        //recivo los campos
        val nombre = findViewById<EditText>(R.id.etName)
        val apellidoP = findViewById<EditText>(R.id.etLastNameP)
        val apellidoM = findViewById<EditText>(R.id.etLastNameM)
        val fechaN = findViewById<EditText>(R.id.etDate)
        val colegio = findViewById<EditText>(R.id.etColegio)
        val carrera = findViewById<EditText>(R.id.etCarrera)
        val registrar = findViewById<Button>(R.id.btnRegistrar)

        registrar.setOnClickListener{
            //guardamos los datos en el objeto postulante
            var postulante = Postulante(nombre.text.toString(),apellidoP.text.toString(),apellidoM.text.toString(),fechaN.text.toString()
                ,colegio.text.toString(),carrera.text.toString())
            var array = ArrayList<String>()
            //val mensaje = postulante.fechaN
            //Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
            val contexto: Context = this
            registerForActivityResult(postulante)
            var helper=Helper1()
            helper.guardar(postulante, contexto)
            array=helper.leer(contexto)
            registerForActivityResult2(array)
        }
    }
    //envia los datos al activityMenu
    fun registerForActivityResult(postulante: Postulante){
        val intent = Intent(this,ActivityMenu::class.java)
        intent.putExtra("objetoPostulante",postulante as java.io.Serializable)
        startActivity(intent)
    }
    fun registerForActivityResult2(array: ArrayList<String>){
        val intent = Intent(this,ActivityListaPostulantes::class.java)
        intent.putExtra("arraydatos",array as java.io.Serializable)
        startActivity(intent)
    }
}