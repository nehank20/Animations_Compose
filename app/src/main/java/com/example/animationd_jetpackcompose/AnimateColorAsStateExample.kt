package com.example.animationd_jetpackcompose

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColorChangesExampleOne() {

    var toggleColor by remember {
        mutableStateOf(
            false
        )
    }

    val boxColor by animateColorAsState(
        targetValue = if(toggleColor) Color.Red else Color.Blue,
        label = "",
        animationSpec = tween(durationMillis = 500, easing = LinearEasing)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(color = boxColor))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { toggleColor = !toggleColor }) {
            Text(text = "Change color", fontSize = 20.sp)
        }
    }
}