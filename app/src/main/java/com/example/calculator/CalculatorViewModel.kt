package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(act: CalculatorAction) {
        when (act) {
            is Number -> enterNumber(act.number)
            is Decimal -> enterDecimal()
            is Clear -> state = CalculatorState()
            is Operation -> enterOperation(act.operation)
            is Calculate -> calculate()
            is Delete -> delete()
        }
    }

    private fun delete() {
        if (state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2.dropLast(1))
        } else if (state.operation != null) {
            state = state.copy(operation = null)
        } else if (state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun calculate() {
        TODO("Not yet implemented")
    }

    private fun enterNumber(num: Int) {
        if (state.operation == null && state.number1.length < 8) {
            state = state.copy(number1 = state.number1 + num)
        } else if (state.operation != null && state.number2.length < 8) {
            state = state.copy(number2 = state.number2 + num)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && state.number1.isNotBlank() && !state.number1.contains(".")) {
            state = state.copy(number1 = state.number1 + ".")
        } else if (state.operation != null && state.number2.isNotBlank()
            && !state.number2.contains(".")
        ) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun enterOperation(op: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = op)
        }
    }

}
