
package com.example.sumadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sumadora.model.Suma
import com.example.sumadora.ui.theme.SumadoraTheme
import java.text.NumberFormat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SumadoraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SumadoraLayout()
                }
            }
        }
    }
}

@Composable
fun SumadoraLayout() {
    var num1 by remember { mutableStateOf("") }
    val amount1 = num1.toDoubleOrNull() ?: 0.0
    var num2 by remember { mutableStateOf("") }
    val amount2 = num2.toDoubleOrNull() ?: 0.0
    val suma = CalculaSuma(amount1,amount2)

    Column(
        modifier = Modifier.padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.sumador),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField1(
            value = num1,
            onValueChange = { num1 = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField2(
            value = num2,
            onValueChange = { num2 = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.suma, suma),
            style = MaterialTheme.typography.displaySmall
        )
        Column (
            modifier = Modifier.padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            LazyColumn(modifier = Modifier
                .padding(top = 16.dp)
                .border(1.dp, Color.Blue)
                .fillMaxWidth()
                .height(200.dp)){
                //ListaSumas(listaSumas = )
            }
        }


        Spacer(modifier = Modifier.height(150.dp))
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField1(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(stringResource(R.string.num1)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField2(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(stringResource(R.string.num2)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}
/*
@Composable
fun ListaSumas(listaSumas: List<Suma>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(listaSumas) { suma ->

            CalcularSuma(
                affirmation = suma,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}*/


private fun CalculaSuma(amount1: Double, amount2: Double): String {
    val suma = amount1+amount2
    return NumberFormat.getCurrencyInstance().format(suma)
}



@Preview(showBackground = true)
@Composable
fun SumadoraPreview() {
    SumadoraTheme {
        SumadoraLayout()
    }
}