package com.example.searchbar_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list=findViewById<ListView>(R.id.listView)
        val search=findViewById<SearchView>(R.id.searchView)
        val names = arrayOf(
            "python",
            "java",
            "c++",
            "android",
            "ML",
            "CP"
        )

        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,names)
        list.adapter=adapter
        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {

                search.clearFocus()
                if(names.contains(p0)){
                    adapter.filter.filter(p0)
                }
                else{
                    Toast.makeText(applicationContext,"item not found",Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                adapter.filter.filter(p0)
                return false
            }

        })
    }}