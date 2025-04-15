package com.example.calculator

import androidx.compose.ui.graphics.Color

data class ButtonMeta(
    val name: String, val color: Color,
    val action: CalculatorAction,
    val ratio: Float = 1f,
    var weight: Float = 1f
)
