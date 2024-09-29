package com.example.parcial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spin: Spinner
    private lateinit var list: ListView
    var deportistasLista = mutableListOf<Deportistas>()
    var deportistasNombres  = mutableListOf<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spin = findViewById(R.id.spin)
        list =  findViewById(R.id.lista)

        val paises =listOf("Argentina", "Uruguay", "Colombia")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, paises)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter

        //val adapterLista = ArrayAdapter(this, android.R.layout.simple_list_item_1, deportistasLista)
        //list.adapter= adapterLista

        val adapterLista = ArrayAdapter(this, android.R.layout.simple_list_item_1, deportistasNombres)
        list.adapter= adapterLista



        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val paisSeleccionado = paises[position]
                deportistasLista.clear()
                deportistasNombres.clear()



                    deportistasLista.addAll(devolverDeportistas(paisSeleccionado))
                for(deportista in deportistasLista) {
                    deportistasNombres.add(deportista.nombre)

                }



                adapterLista.notifyDataSetChanged()
                Toast.makeText(this@MainActivity, "selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Seleccione una opcion", Toast.LENGTH_SHORT)
                    .show()
            }

        }


        list.setOnItemClickListener { parent, view, position, id ->
            val deportistaSeleccionado = deportistasLista[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("Nombre", deportistaSeleccionado.nombre)
            intent.putExtra("Deporte", deportistaSeleccionado.deporte)
            intent.putExtra("Está activo?", deportistaSeleccionado.activo)
            startActivity(intent)

        }


            }

        fun devolverDeportistas(pais: String): MutableList<Deportistas> {
        return when(pais){
            "Argentina" -> mutableListOf(
                Deportistas("Lionel Messi", "Fútbol", true),
                Deportistas("Diego Maradona", "Fútbol", false),
                Deportistas("Norberto Alonso", "Fútbol", false),
                Deportistas("Fabricio Oberto", "Basket", false),
                Deportistas("David Nalbandian", "Tenis", false),
                Deportistas("Guillermo Coria", "Tenis", false),
                Deportistas("Gabriela Sabatini", "Tenis", false),
                Deportistas("Gonzalo Martinez", "Fútbol", true),
                Deportistas("Luciana Aymar", "Hockey", false),
                Deportistas("Valentina Raposo", "Hockey", true)

            )
            "Uruguay" -> mutableListOf(
                Deportistas("Enzo Francescoli", "Fútbol", false),
                Deportistas("Omar Galeano", "Basket", false),
                Deportistas("Fiorella Bonicelli", "Tenis", false),
                Deportistas("Marcel Felder", "Tenis", false),
                Deportistas("Nicolás De la Cruz", "Fútbol", true),
                Deportistas("Antonio Alzamendi", "Fútbol", false),
                Deportistas("Ramiro Cabrera", "Ciclismo", true),
                Deportistas("Florencia Aguirre", "Voley", true),
                Deportistas("Dante Locco", "Natación", false),
                Deportistas("Alberto Uria", "Automovilismo", false)

            )
            "Colombia" -> mutableListOf(
                Deportistas("Miguel Ángel Borja", "Fútbol", true),
                Deportistas("Juan Pablo Montoya", "Automovilismo", true),
                Deportistas("Tatiana Calderón", "Automovilismo", true),
                Deportistas("Juan Fernando Quintero", "Fútbol", true),
                Deportistas("Santiago Giraldo", "Tenis", false),
                Deportistas("Juan Pablo Angel", "Fútbol", false),
                Deportistas("Daniel Galán", "Tenis", true),
                Deportistas("Teófilo Gutiérrez", "Fútbol", true),
                Deportistas("Valentia Abril", "Ciclismo", true),
                Deportistas("Camilo Villegas", "Golf", true)

            )

            else -> mutableListOf()


        }





     }

}