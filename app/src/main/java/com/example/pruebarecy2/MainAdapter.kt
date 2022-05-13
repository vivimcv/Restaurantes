package com.example.pruebarecy2

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebarecy2.databinding.AdapterMovieBinding
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlin.coroutines.coroutineContext


class MainAdapter(contexto: Context,private val cellClickListener: OnItemClickListener): RecyclerView.Adapter<MainViewHolder>() {

    var movies = mutableListOf<Restaurante>()
    fun setMovieList(movies: List<Restaurante>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        val context = parent.context
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = movie.nombre
       val image= Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
        holder.binding.tvCal.text = movie.calificacion
        holder.binding.tvCosto.text = movie.costopromedio.toString()
        holder.binding.tvYear.text = movie.año.toString()


        holder.itemView.setOnClickListener {  cellClickListener.onItemClick()
          Log.d("hola","hola")  }


      /* holder.binding.item.setOnClickListener {
         Log.d("hola","hola")

       }*/


    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun onClick(position: Int) {
      //  v!!.context.startActivity(Intent(v!!.context, MainActivity2::class.java))
    }

}
class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {
}