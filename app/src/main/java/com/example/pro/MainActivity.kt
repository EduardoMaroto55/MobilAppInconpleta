package com.example.pro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.pro.data.Weather


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnGetInfo = findViewById<Button>(R.id.button)
        btnGetInfo.setOnClickListener{
            getWeatherInfo()
        }
    }
    private fun getWeatherInfo(){
        val city = findViewById<TextView>(R.id.city).text
        val appId = "ed7c7d1a27344121a8130f5594126fe7"
        val url = "https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${appId}"
        val queue = Volley.newRequestQueue(this)
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            {
                val datos = it.getJSONObject("main")
                val temp = datos.getDouble("temp")
                val feelsLike = datos.getDouble("feels_like")
                val pressure = datos.getInt("pressure")
                val humidity=datos.getInt("humidity")
                val minTem=datos.getDouble("temp_min")
                val maxTem=datos.getDouble("temp_max")
                var weather = Weather(temp,feelsLike,pressure,humidity,minTem,maxTem)
                Log.d("Main Activity",weather.temp.toString())
                Toast.makeText(this, "Data received: "+ datos.toString(), Toast.LENGTH_LONG).show()
            },{
                Log.d("Main Activity Error:",it.toString())
                Toast.makeText(this, "Error: Request not found ${it}", Toast.LENGTH_LONG).show()

            }
        )
        queue.add(jsonObjectRequest)
        Toast.makeText(this,"Getting info",Toast.LENGTH_LONG).show()
    }
}