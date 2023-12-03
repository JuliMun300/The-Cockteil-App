package com.example.thecockteilapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thecockteilapp.view.CockteilAdapter
import com.example.thecockteilapp.viewmodel.CocktailViewModel

private lateinit var RvCockteil: RecyclerView
private lateinit var progressBar: ProgressBar
private var adapter = CockteilAdapter()
private lateinit var searchview:SearchView
private lateinit var ViewModel: CocktailViewModel
private val repository = Repository()
private val ListaCockteils = mutableListOf<Cocktail>()


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RvCockteil = findViewById(R.id.RecyclerViewCockteil)
        progressBar = findViewById(R.id.progressBarCocketil)
        searchview = findViewById(R.id.searchViewview)
        RvCockteil.layoutManager = LinearLayoutManager(this)
        ViewModel = ViewModelProvider(this, CocktailViewModelFactory(repository,application))[CocktailViewModel::class.java]

       SetupUi()
    }

    private fun SetupUi(){

        progressBar.visibility = View.INVISIBLE
        RvCockteil.adapter = adapter
        searchview.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(!query.isNullOrEmpty()){
                    ListaCockteils.clear()
                    ShowProgressBar()
                    ViewModel.SearchCockteils(query)
                    adapter.notifyDataSetChanged()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        adapter.onItemClickListener = {coctel ->
            val intent = Intent(this, CocktailInfo::class.java)
            intent.putExtra("cocteil",coctel)
            startActivity(intent)

        }
         ShowListOfCocktails()
    }

    private fun ShowListOfCocktails() {
        ViewModel.lista.observe(this, Observer {
            ListaCockteils.addAll(it)
            adapter.submitList(ListaCockteils)
        })
    }

    private fun ShowProgressBar() {
        ViewModel.status.observe(this, Observer {

            when (it) {
                StatusProgress.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                StatusProgress.Sucess -> {
                    progressBar.visibility = View.GONE
                }
                else -> {}
            }
        })
    }
}

