package com.gwsilver.prakticheskaya_rabota_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.gwsilver.prakticheskaya_rabota_9.databinding.ActivityMainBinding
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StartAdapter
    var List = ArrayList<ListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StartAdapter()
        recyclerView.adapter = adapter
        getResult()
        binding.button.setOnClickListener {
            getResult()
        }
    }

    private fun getResult(){
        val url = "https://cdn.cur.su/api/cbr.json"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest (
            Request.Method.GET,
            url,{
                    response->
                val obj = JSONObject(response)
                val rates = obj.getJSONObject("rates")
                for (i in ValuteList){
                    List.add(ListItem(i, rates.getDouble(i)))
                }
            }, {
                Log.d("MyLog", "Error: $it")
            })
        queue.add(stringRequest)
        adapter.setList(List)
    }
}

