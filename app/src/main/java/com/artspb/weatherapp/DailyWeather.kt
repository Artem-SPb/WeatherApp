package com.artspb.weatherapp

// data class идеально подходит для хранения состояния. Он автоматически генерирует нужные методы.
data class DailyWeather(
    val day: String,        // День недели (например, "Пн")
    val clouds: Boolean,    // Облачно ли (true - облако, false - солнце)
    val temperature: Short, // Температура. Используем Short для экономии памяти, числа небольшие.
)
