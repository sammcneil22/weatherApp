package com.example.helloandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloandroid.R

enum class WeatherType { SUNNY, CLOUDY, RAINY }

data class DayForecast(val dayName: String, val type: WeatherType, val tempC: Int)

val sample7Day = listOf(

    DayForecast("Monday", WeatherType.SUNNY, 19),
    DayForecast("Tuesday", WeatherType.CLOUDY, 17),
    DayForecast("Wednesday", WeatherType.RAINY, 14),
    DayForecast("Thursday", WeatherType.SUNNY, 21),
    DayForecast("Friday", WeatherType.CLOUDY, 18),
    DayForecast("Saturday", WeatherType.RAINY, 13),
    DayForecast("Sunday", WeatherType.SUNNY, 20)

)

@Composable
fun Forecast(forecasts: List<DayForecast> = sample7Day) {

    LazyColumn(

        modifier = Modifier

            .fillMaxSize()
            .padding(8.dp),

        verticalArrangement = Arrangement.spacedBy(8.dp)

    )

    {
        items(forecasts) { forecast ->

            DayRow(forecast)
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

        }
    }
}

@Composable
private fun DayRow(forecast: DayForecast) {

    Row(

        modifier = Modifier

            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),

        verticalAlignment = Alignment.CenterVertically

    )

    {
        val iconRes = when (forecast.type) {

            WeatherType.SUNNY -> R.drawable.ic_sun
            WeatherType.CLOUDY -> R.drawable.ic_cloudy
            WeatherType.RAINY -> R.drawable.ic_rain

        }

        Image(

            painter = painterResource(id = iconRes),
            contentDescription = forecast.type.name,
            modifier = Modifier.size(64.dp)

        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(

            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start

        )

        {
            Text(

                text = forecast.dayName,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 18.sp

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(

                text = "${forecast.tempC}°",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.primary

            )
        }
    }
}