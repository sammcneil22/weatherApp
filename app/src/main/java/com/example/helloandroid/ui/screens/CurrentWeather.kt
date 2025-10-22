package com.example.helloandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloandroid.R

@Composable
fun CurrentWeather() {

    Column(

        modifier = Modifier

            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    )

    {
        Image(

            painter = painterResource(id = R.drawable.ic_sun),
            contentDescription = "Sunny",
            modifier = Modifier.size(120.dp)

        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(

            text = "It's sunny out",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground

        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(

            text = "19°",
            fontSize = 48.sp,
            color = MaterialTheme.colorScheme.primary

        )
    }
}