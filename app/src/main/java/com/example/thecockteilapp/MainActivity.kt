package com.example.thecockteilapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var RvCockteil: RecyclerView
private lateinit var progressBar: ProgressBar
private lateinit var ViewModel:CockteilViewModel


private val ListaCockteils = mutableListOf<Cockteil>(
    Cockteil(
        "4564",
        "Ginebra",
        "https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/3070648_f.jpg",
        "Florales",
        "Picante",
        "Amaderado",
        "Arribaderchi"
    )

)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RvCockteil = findViewById(R.id.RecyclerViewCockteil)
        progressBar = findViewById(R.id.progressBarCocketil)
        RvCockteil.layoutManager = LinearLayoutManager(this)
        val adapter = CockteilAdapter()

        RvCockteil.adapter = adapter

        adapter.onItemClickListener = {
            val intent = Intent(this, CockteilInfo::class.java)
            val cockteil = it
            intent.putExtra("cockteilnombre", cockteil.Nombre)
            intent.putExtra("cockteilInstrucciones", cockteil.Instrucciones)
            intent.putExtra("cockteilIngred1", cockteil.Ingrediente1)
            intent.putExtra("cockteilIngred2", cockteil.Ingrediente2)
            intent.putExtra("cockteilIngrediente3", cockteil.Ingrediente3)
            intent.putExtra("cockteilImagen", cockteil.imagen)
            startActivity(intent)

            Toast.makeText(this, "${it.Nombre}", Toast.LENGTH_SHORT).show()
        }

        ViewModel = ViewModelProvider(this)[CockteilViewModel::class.java]

        ViewModel.lista.observe(this, Observer {
            adapter.submitList(it)
        })

        ShowProgressBar()

    }
    private fun ShowProgressBar(){
        ViewModel.status.observe(this, Observer {

            when (it) {
                StatusProgress.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                StatusProgress.Sucess -> {
                    progressBar.visibility = View.GONE
                }
            }
        })
    }

}