package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.theme.LightGrey
import com.example.calculator.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                val viewModel: CalculatorViewModel by viewModels()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Calculator(
                    state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::onAction,
                    data = listOf(
                        listOf(
                            ButtonMeta("AC", LightGrey, Clear, 2f, 2f),
                            ButtonMeta("Del", LightGrey, Delete),
                            ButtonMeta("/", Orange, Operation(Divide))
                        ),
                        listOf(
                            ButtonMeta("7", Color.DarkGray, Number(7)),
                            ButtonMeta("8", Color.DarkGray, Number(8)),
                            ButtonMeta("9", Color.DarkGray, Number(9)),
                            ButtonMeta("x", Orange, Operation(Multiply))
                        ),
                        listOf(
                            ButtonMeta("4", Color.DarkGray, Number(4)),
                            ButtonMeta("5", Color.DarkGray, Number(5)),
                            ButtonMeta("6", Color.DarkGray, Number(6)),
                            ButtonMeta("-", Orange, Operation(Substract))
                        ),
                        listOf(
                            ButtonMeta("1", Color.DarkGray, Number(1)),
                            ButtonMeta("2", Color.DarkGray, Number(2)),
                            ButtonMeta("3", Color.DarkGray, Number(3)),
                            ButtonMeta("+", Orange, Operation(Add))
                        ),
                        listOf(
                            ButtonMeta("0", Color.DarkGray, Number(0), 2f, 2f),
                            ButtonMeta(".", Color.DarkGray, Decimal),
                            ButtonMeta("=", Orange, Calculate)
                        )
                    )
                )
            }
        }
    }
}
