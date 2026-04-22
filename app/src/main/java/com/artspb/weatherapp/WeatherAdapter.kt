package com.artspb.weatherapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// Адаптер принимает список данных в конструкторе.
class WeatherAdapter(
    private val data: List<DailyWeather>
) : RecyclerView.Adapter<WeatherViewHolder>() {

    // Метод 1: Создает новые ViewHolder-ы, превращая XML в реальные объекты View.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false)
        return WeatherViewHolder(view)
    }

    // Метод 2: Привязывает данные к существующему ViewHolder-у (вызывается при прокрутке).
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(data[position])
    }

    // Метод 3: Сообщает RecyclerView, сколько всего элементов в нашем списке.
    override fun getItemCount(): Int {
        return data.size
    }
}
