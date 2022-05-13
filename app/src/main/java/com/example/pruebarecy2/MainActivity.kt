package com.example.pruebarecy2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pruebarecy2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnItemClickListener {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val currentFragment: Fragment? = null
    val adapter = MainAdapter(this,this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllMovies()





    }

    fun onClick(view: View) {


        val intent = Intent(this, Informacion::class.java)
        with(binding) {
            val resultados = Bundle()
            //eventos del click

            resultados.putInt("resultado",1)
            intent.putExtras(resultados)
            //Toast.makeText(this@MainActivity, resultados.toString(), Toast.LENGTH_SHORT).show()
            //  intent.putExtra("ID", 0)
            startActivity(intent)
            finish()
        }


    }

    //restauranteElegido: Restaurante
    override fun onItemClick() {
        Toast.makeText(this, "lala",Toast.LENGTH_LONG).show()
    }


}