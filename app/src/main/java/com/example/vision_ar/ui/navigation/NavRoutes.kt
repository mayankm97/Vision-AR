package com.example.vision_ar.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Serializable
data class ARScreen(val model: String)

@Serializable
object AlphabetScreen

@Serializable
object QuizScreen