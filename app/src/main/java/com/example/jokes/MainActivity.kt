package com.example.jokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        getJokes()

    }
    private fun getJokes(){
        val jokes = ApiService.apiInstance.getRandomJokes()
        with(jokes) {
            enqueue(object : Callback<ArrayList<Jokes>> {

                override fun onFailure(call: Call<ArrayList<Jokes>>, t: Throwable) {
                    Log.d("MainActivity","Error in Fetching jokes",t)
                }

                override fun onResponse(call: Call<ArrayList<Jokes>>, response: Response<ArrayList<Jokes>>) {
                    val jokes = response.body()
                    if(jokes != null){
                        Log.d("MainAcitvity",jokes.toString())
                        myAdapter = MyAdapter(this@MainActivity,jokes)
                        recyclerView.adapter = myAdapter
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            })
        }
    }
}