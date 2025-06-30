package com.example.vision_ar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.vision_ar.ui.navigation.ARScreen
import com.example.vision_ar.ui.navigation.AlphabetScreen
import com.example.vision_ar.ui.navigation.HomeScreen
import com.example.vision_ar.ui.navigation.QuizScreen
import com.example.vision_ar.ui.screens.ARScreen
import com.example.vision_ar.ui.screens.AlphabetScreen
import com.example.vision_ar.ui.screens.HomeScreen
import com.example.vision_ar.ui.screens.QuizScreen
import com.example.vision_ar.ui.theme.Vision_ARTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vision_ARTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = HomeScreen,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<HomeScreen> {
                            HomeScreen(navController)
                        }
                        composable<ARScreen> {
                            val alphabet = it.toRoute<ARScreen>().model
                            ARScreen(navController, alphabet)
                        }
                        composable<AlphabetScreen> {
                            AlphabetScreen(navController)
                        }
                        composable<QuizScreen> {
                            QuizScreen(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}