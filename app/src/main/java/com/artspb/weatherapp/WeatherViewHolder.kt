package com.artspb.weatherapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

// ViewHolder принимает View (наш скомпилированный day_item.xml)
class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    // Ищем все нужные элементы внутри переданного itemView ОДИН РАЗ при создании холдера.
    private val cardView: MaterialCardView = itemView.findViewById(R.id.cardView)
    private val tvDay: TextView = itemView.findViewById(R.id.tvDay)
    private val ivClouds: ImageView = itemView.findViewById(R.id.ivClouds)
    private val tvTemperature: TextView = itemView.findViewById(R.id.tvTemperature)

    // Метод для привязки конкретных данных (объекта DailyWeather) к нашим View
    fun bind(item: DailyWeather) {
        val temp = item.temperature

        // Выбираем правильный шаблон строки (с плюсом или без)
        val tempString =
            if (temp > 0) R.string.plus_temperature
            else R.string.minus_temperature

        // Выбираем цвет фона в зависимости от градусов (when - аналог switch-case)
        val tempColor = when {
            temp < -20 -> R.color.less_then_minus_20
            temp in -20..-15 -> R.color.minus_20_to_minus_15
            temp in -14..-10 -> R.color.minus_14_to_minus_10
            temp in -9..9 -> R.color.minus_9_to_plus_9
            temp in 10..14 -> R.color.plus_10_to_plus_14
            temp in 15..20 -> R.color.plus_15_to_plus_20
            else -> R.color.more_then_plus_20
        }

        // Логика выбора иконки с именами файлов
        val cloudsIcon = if (item.clouds) R.drawable.ic_cloud_24dp else R.drawable.ic_sun_24dp

        // ПРИСВАИВАЕМ ДАННЫЕ ВО VIEW:
        tvDay.text = item.day // Текст дня недели
        ivClouds.setImageResource(cloudsIcon) // Картинка погоды

        // Берем строку из strings.xml и подставляем температуру вместо %1$d
        tvTemperature.text = itemView.context.getString(tempString, temp.toInt())

        // Красим саму карточку (MaterialCardView) в нужный цвет
        cardView.setCardBackgroundColor(itemView.context.getColor(tempColor))

        // ФИЧА 2: Обработка клика по элементу списка
        itemView.setOnClickListener {
            // Показываем всплывающее сообщение (Toast) при нажатии
            Toast.makeText(
                itemView.context,
                "Подробный прогноз на ${item.day}: ${tvTemperature.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

