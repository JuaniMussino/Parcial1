package com.example.parcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

         lateinit var nombre: TextView
         lateinit var deporte: TextView
         lateinit var activo: TextView
         lateinit var boton: Button


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.extras

        val nombre_deportista = bundle?.getString("Nombre", " ")
        val deporte_deportista = bundle?.getString("Deporte", "")
        val activo_deportista = bundle?.getBoolean("Está activo?", false)

        nombre = findViewById(R.id.tvNombre)
        deporte = findViewById(R.id.tvDeporte)
        activo = findViewById(R.id.tvActivo)
        boton = findViewById(R.id.botonRegresar)

        nombre.text = nombre_deportista
        deporte.text = "Deporte que practica: $deporte_deportista"
        activo.text = if(
            activo_deportista == true
        ) "El/la deportista se encuentra en actividad"
        else "El/la deportista se encuentra retirado/a"



        boton.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}