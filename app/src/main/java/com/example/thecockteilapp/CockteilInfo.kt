package com.example.thecockteilapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

private lateinit var Nombre: TextView
private lateinit var Instrucciones: TextView
private lateinit var Ingrediente1: TextView
private lateinit var Ingrediente2: TextView
private lateinit var Ingrediente3: TextView
private lateinit var Imagen: ImageView

class CockteilInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cockteil_info)

        Nombre = findViewById(R.id.textViewNombre)
        Instrucciones = findViewById(R.id.textViewInstrucciones)
        Ingrediente1 = findViewById(R.id.textviewIngrediente1)
        Ingrediente2 = findViewById(R.id.textviewIngrediente2)
        Ingrediente3 = findViewById(R.id.textviewIngrediente3)
        Imagen = findViewById(R.id.imageViewCockteil)


        val bundle = intent.extras
        val cockteilNombre = bundle?.getString("cockteilnombre")
        val cockteilInstrucciones = bundle?.getString("cockteilInstrucciones")
        val ingrediente1 = bundle?.getString("cockteilIngred1")
        val ingrediente2 = bundle?.getString("cockteilIngred2")
        val ingrediente3 = bundle?.getString("cockteilIngrediente3")
        val imagenCockteil = bundle?.getString("cockteilImagen")

        if (bundle != null) {
            Nombre.text = cockteilNombre.toString()
            Instrucciones.text = cockteilInstrucciones.toString()
            Ingrediente1.text = "Ingredient 1: ${ingrediente1.toString()}"
            Ingrediente2.text = "Ingredient 2: ${ingrediente2.toString()}"
            Ingrediente3.text = "Ingredient 3: ${ingrediente3.toString()}"
            Picasso.get().load(imagenCockteil.toString()).into(Imagen)
        }


    }

}
