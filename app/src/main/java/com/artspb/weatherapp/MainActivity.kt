package com.artspb.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Устанавливаем activity_main.xml в качестве разметки экрана
        setContentView(R.layout.activity_main)

        // 1. Готовим данные (Хардкодим список прогноза погоды)
        val weatherList = listOf(
            DailyWeather("Пн", true, -23),
            DailyWeather("Вт", true, -20),
            DailyWeather("Ср", false, -15),
            DailyWeather("Чт", true, -3),
            DailyWeather("Пт", false, 6),
            DailyWeather("Сб", false, 11),
            DailyWeather("Вс", true, 20),
        )

        // 2. Создаем экземпляр нашего адаптера и передаем ему список данных
        val weatherAdapter = WeatherAdapter(weatherList)

        // 3. Находим RecyclerView на макете
        val rvWeather = findViewById<RecyclerView>(R.id.rvWeather)

        // 4. Назначаем адаптер нашему RecyclerView.
        rvWeather.adapter = weatherAdapter
    }
}
