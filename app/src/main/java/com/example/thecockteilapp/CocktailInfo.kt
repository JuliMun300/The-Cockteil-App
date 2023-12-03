package com.example.thecockteilapp

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

class CocktailInfo : AppCompatActivity() {
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
        val cocteil = bundle?.getParcelable<Cocktail>("cocteil")

        if (bundle != null) {
            Nombre.text = cocteil?.Nombre
            Instrucciones.text = cocteil?.Instrucciones
            Ingrediente1.text = "Ingredient 1: ${cocteil?.Ingrediente1}"
            Ingrediente2.text = "Ingredient 2: ${cocteil?.Ingrediente2}"
            Ingrediente3.text = "Ingredient 3: ${cocteil?.Ingrediente3}"
            Picasso.get().load(cocteil?.imagen).into(Imagen)
        }
    }
}
