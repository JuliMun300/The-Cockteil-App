package com.example.thecockteilapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thecockteilapp.Cocktail
import com.example.thecockteilapp.R
import com.squareup.picasso.Picasso

class CockteilAdapter : ListAdapter<Cocktail, CockteilAdapter.ViewHolder>(DiffcallBack) {


    lateinit var onItemClickListener: (Cocktail) -> Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.cockteil_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.render(item)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val Nombre = view.findViewById(R.id.NombreId) as TextView
        val Imagen = view.findViewById(R.id.ImagenId) as ImageView

        fun render(cockteil: Cocktail) {
            Nombre.text = cockteil.Nombre
            Picasso.get().load(cockteil.imagen).into(Imagen)

            view.setOnClickListener {
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(cockteil)
                }
            }
        }
    }

    companion object DiffcallBack : DiffUtil.ItemCallback<Cocktail>() {
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem.Nombre == oldItem.Nombre
        }

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem == newItem
        }
    }
}
