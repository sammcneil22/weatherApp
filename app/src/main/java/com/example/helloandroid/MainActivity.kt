package com.example.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helloandroid.ui.screens.CurrentWeather
import com.example.helloandroid.ui.screens.Forecast
import com.example.helloandroid.ui.theme.HelloAndroidTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            HelloAndroidTheme {

                DisplayUI()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayUI() {

    val navController = rememberNavController()

    //remembers what page were on
    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold(

        topBar = {

            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(

                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor =  MaterialTheme.colorScheme.primary

                ),

                title = {

                    Text("WeatherWorks")

                }
            )
        },

        bottomBar = {

            NavigationBar(

                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary

            )

            {

                NavigationBarItem(

                    label = {

                        Text("Current Weather")

                    },

                    icon = {

                        Icon(

                            painter = painterResource(R.drawable.ic_sun),
                            contentDescription = "Current Weather",
                            modifier = Modifier.size(24.dp)

                        )
                    },

                    selected = selectedItem == 0,
                    onClick = {

                        selectedItem = 0
                        navController.navigate("Current Weather")

                    }
                )

                NavigationBarItem(

                    label = {

                        Text("7 Day Forecast")

                    },

                    icon = {

                        Icon(

                            painter = painterResource(R.drawable.ic_rain),
                            contentDescription = "7 Day Forecast",
                            modifier = Modifier.size(24.dp)


                        )
                    },

                    selected = selectedItem == 1,
                    onClick = {

                        selectedItem = 1
                        navController.navigate("7 Day Forecast")

                    }
                )
            }
        }
    )

    { innerPadding ->

        //render screen
        NavHost(

            navController = navController,
            startDestination = "Current Weather",
            modifier = Modifier.padding(innerPadding)

        )

        {
            //display home screen
            composable(route = "Current Weather")
            {

                CurrentWeather()

            }

            //display 7 day forecast screen
            composable(route = "7 Day Forecast")
            {

                Forecast()

            }
        }
    }
}

