package com.example.calculator.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeView(){
    Scaffold(
        topBar={
            CenterAlignedTopAppBar(
                title = { Text(text = "Calculator",
                    color = Color.White
                    ) },
                colors= TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) {


    }

}


@Composable
fun CalView(btnText:String, operator:String){
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    var showAlert by remember { mutableStateOf(false) }



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier=Modifier
            .fillMaxSize()
    ) {



        OutlinedTextField(
            value = num1,
            onValueChange = { num1 =it },
            label = { Text("Number 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)



        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 =it },
            label = { Text("Number 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)


        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick={
            when(operator){
                "+" -> result= (num1.toDouble()+num2.toDouble()).toString()
                "-" -> result= (num1.toDouble()-num2.toDouble()).toString()
                "*" -> result= (num1.toDouble()*num2.toDouble()).toString()
                "/" -> result= (num1.toDouble()/num2.toDouble()).toString()

            }
            showAlert=true
            num2=""
            num1=""
        },
            modifier=Modifier.width(120.dp),
            colors= ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )){
            Text(btnText)

        }



    }


    if(showAlert){
        AlertDialog(
            title={Text("The result is: ")},
            text={Text(result,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
                )},
            onDismissRequest = {showAlert=false},
            confirmButton = {
                Button(onClick = { showAlert = false },
                    colors= ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                    ) {
                    Text("Ok")
                }
            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Alerta(title:String, text:String, onDismissRequest:() -> Unit, onConfirmation:() -> Unit){

    AlertDialog(
         title={Text(title)},
        text={Text(text)},
        onDismissRequest = {onDismissRequest()},
        confirmButton = {onConfirmation()},
        dismissButton = {onDismissRequest}
    )
}