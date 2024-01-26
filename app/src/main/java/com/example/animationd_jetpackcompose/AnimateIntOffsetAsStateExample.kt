package com.example.animationd_jetpackcompose

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun ChangePositionOfComposable() {

    var moved by remember {
        mutableStateOf(false)
    }

    val xAxis = with(LocalDensity.current) {
        0.dp.toPx().roundToInt()
    }

    val yAxis = with(LocalDensity.current) {
        400.dp.toPx().roundToInt()
    }

    val offset by animateIntOffsetAsState(
        targetValue = if(moved){
            IntOffset(xAxis, yAxis)
        }else{
            IntOffset.Zero
        }, label = "",
        animationSpec = tween(2000)
    )


    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Box(modifier = Modifier
            .offset {
                offset
            }
            .background(Color.Blue)
            .size(100.dp)

            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                moved = !moved
            }
        )


    }
}