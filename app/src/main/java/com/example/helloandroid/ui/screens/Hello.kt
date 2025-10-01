package com.example.helloandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.helloandroid.R

@Composable
fun Hello() {
    Column()
    {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo"
        )

        Text("Hello Amdroid!")
    }

}