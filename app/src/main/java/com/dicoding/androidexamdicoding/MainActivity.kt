package com.dicoding.androidexamdicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvExo: RecyclerView
    private val list = ArrayList<Exo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvExo = findViewById(R.id.rv_exo)
        rvExo.setHasFixedSize(true)

        list.addAll(getListExo())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvExo.layoutManager = LinearLayoutManager(this)
        val listExoAdapter = ExoAdapter(list)
        rvExo.adapter = listExoAdapter
    }

    private fun getListExo(): ArrayList<Exo> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listExo = ArrayList<Exo>()
        for (i in dataName.indices){
            val hero = Exo(dataName[i], dataDesc[i], dataPhoto[i])
            listExo.add(hero)
        }
        return listExo
    }
}