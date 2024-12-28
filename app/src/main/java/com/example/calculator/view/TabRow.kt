package com.example.calculator.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api


import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Tabs(){
    var selectedTabIndex by remember { mutableStateOf(0) }

    var tabTitles= listOf("Add", "Subtract", "Multiply", "Divide")

    Scaffold(
        topBar={

            Column {
                 CenterAlignedTopAppBar(
                     title = { Text(text = "Calculator",
                         color = Color.White
                     ) },
                     colors= TopAppBarDefaults.centerAlignedTopAppBarColors(
                         containerColor = Color.Blue)
                 )

                TabRow(
                    selectedTabIndex=selectedTabIndex,
                    modifier=Modifier.height(50.dp)

                ){
                    tabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = {
                                Text(title,
                                    color=Color.White,
                                    fontSize = 15.sp
                                )
                            },
                            modifier = Modifier.background(Color.Blue)

                        )
                    }
                }



            }


        }

    ){

        when(selectedTabIndex){
            0-> CalView("Add", "+")
            1-> CalView("Subtract", "-")
            2-> CalView("Multiply", "*")
            3-> CalView("Divide", "/")
        }


    }



}