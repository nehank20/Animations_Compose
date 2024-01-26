package com.example.animationd_jetpackcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChangeLayoutHeight() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {


        var toggleExpanded by remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .animateContentSize()
                .height(if (toggleExpanded) 400.dp else 200.dp)
                .fillMaxWidth()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    toggleExpanded = !toggleExpanded
                }



        )
    }
}