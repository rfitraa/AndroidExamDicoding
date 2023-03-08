package com.dicoding.androidexamdicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.androidexamdicoding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvExo: RecyclerView
    private val list = ArrayList<Exo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvExo = findViewById(R.id.rv_exo)

        list.addAll(getListExo())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page -> {
                val about_me = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(about_me)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvExo.layoutManager = LinearLayoutManager(this)
        val listExoAdapter = ExoAdapter(list)
        rvExo.adapter = listExoAdapter

        listExoAdapter.setOnItemClickCallback(object : ExoAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Exo){
                showSelectedExo(data)
            }
        })
    }

    private fun getListExo(): ArrayList<Exo> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataStageName = resources.getStringArray(R.array.data_stage_name)
        val dataBirthName = resources.getStringArray(R.array.data_birth_name)
        val dataPosition = resources.getStringArray(R.array.data_position)
        val dataBirthday = resources.getStringArray(R.array.data_birthday)
        val dataNationality = resources.getStringArray(R.array.data_nationality)
        val dataBloodType = resources.getStringArray(R.array.data_blood_type)
        val dataMbti = resources.getStringArray(R.array.data_mbti)
        val dataIg = resources.getStringArray(R.array.data_insta)
        val dataWeibo = resources.getStringArray(R.array.data_weibo)
        val dataFacts = resources.getStringArray(R.array.data_facts)
        val listExo = ArrayList<Exo>()
        for (i in dataName.indices){
            val exo = Exo(
                name = dataName[i],
                desc = dataDesc[i],
                photo = dataPhoto.getResourceId(i, -1),
                stageName = dataStageName[i],
                birthName = dataBirthName[i],
                position = dataPosition[i],
                birthday = dataBirthday[i],
                nationality = dataNationality[i],
                bloodType = dataBloodType[i],
                mbti = dataMbti[i],
                insta = dataIg[i],
                weibo = dataWeibo[i],
                facts = dataFacts[i]
            )
            listExo.add(exo)
        }
        return listExo
    }

    private fun showSelectedExo(exo: Exo){
        val moveWithDetail = Intent(this@MainActivity, DetailActivity::class.java)

        moveWithDetail.putExtra(DetailActivity.EXTRA_DETAIL, exo)
        startActivity(moveWithDetail)
    }
}