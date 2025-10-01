package com.example.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helloandroid.ui.screens.Hello
import com.example.helloandroid.ui.screens.Home
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

    // Variable to store the selected value in Nav Bar
    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor =  MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text("My Android App")
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            )
            {
                // Navigation Bar Items go here...

                // Link to Home screen
                NavigationBarItem(
                    label = {
                        Text("Home")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_home),
                            contentDescription = "Home"
                        )
                    },
                    selected = selectedItem == 0,
                    onClick = {
                        selectedItem = 0
                        navController.navigate("home")
                    }
                )

                // Link to Hello screen
                NavigationBarItem(
                    label = {
                        Text("Hello")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_hand),
                            contentDescription = "Hello"
                        )
                    },
                    selected = selectedItem == 1,
                    onClick = {
                        selectedItem = 1
                        navController.navigate("hello")
                    }
                )

            }
        }
    )
    { innerPadding ->
        // Content goes here...

        // Use a Nav Host to render the screens
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        )
        {
            // Display Home screen
            composable(route = "home")
            {
                Home()
            }

            // Display Hello screen
            composable(route = "hello")
            {
                Hello()
            }
        }
    }
}


@Composable
fun Greeting() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()

        )
        {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo")
        }


        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
        ){
            Text(
                text = "Hello"
            )

            Text(
                text = "Android"
            )

            Text(
                text = "Welcome to my app"
            )
        }
    }


}