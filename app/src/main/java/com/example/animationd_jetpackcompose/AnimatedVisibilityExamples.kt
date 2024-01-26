package com.example.animationd_jetpackcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VisibilityExampleOne() {
    var toggle by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                toggle = !toggle
            },
            shape = CircleShape
        ) {
            Text(text = "Start Animation", fontSize = 20.sp)
        }

        Spacer(Modifier.height(16.dp))

        AnimatedVisibility(
            visible = toggle,
            enter = expandIn(),
            exit = shrinkOut() + fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .background(Color.Blue)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

    }


}

@Composable
fun VisibilityExampleTwo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var toggleVisibility by remember {
            mutableStateOf(true)
        }

        Button(onClick = {
            toggleVisibility = !toggleVisibility
        }) {
            Text(text = if (toggleVisibility) "Hide" else "Show", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(52.dp))

        AnimatedVisibility(visible = toggleVisibility) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Green))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Blue))


    }
}

@Preview
@Composable
fun VisibilityExampleOne_Preview() {
    VisibilityExampleOne()
}