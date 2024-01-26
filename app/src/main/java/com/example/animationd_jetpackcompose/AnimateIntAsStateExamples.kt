package com.example.animationd_jetpackcompose

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShapeChangesExampleOne() {

    var changeShape by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.padding(8.dp).fillMaxSize()) {
        Button(onClick = {
            changeShape = !changeShape
        }) {
            Text(text = "Start Animation", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))

        val roundedCorners by animateIntAsState(
            targetValue = if (changeShape) 100 else 0,
            label = "",
            animationSpec = tween(1500)
        )

        Box(
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(roundedCorners))
                .background(Color.Blue)

        )
    }
}

@Preview
@Composable
fun ShapeChangesExampleOne_Preview() {
    ShapeChangesExampleOne()
}