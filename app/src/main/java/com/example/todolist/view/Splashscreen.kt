package com.example.todolist.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.view.LoginActivity
import kotlinx.coroutines.delay
import com.example.todolist.R

class Splashscreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplashBody()
        }
    }
}

@Composable
fun SplashBody() {
    val context = LocalContext.current
    val activity = context as Activity

    // Navigate to login after 3 seconds
    LaunchedEffect(Unit) {
        delay(3000) // 3 second delay
        context.startActivity(Intent(context, LoginActivity::class.java))
        activity.finish()
    }

    // UI layout
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image.....
        Image(
            painter = painterResource(R.drawable.log_bg),
            contentDescription = "Splash Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // Dark overlay for readability/aesthetic
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.50f))
        )
        // Centered Logo
        Image(
            painter = painterResource(R.drawable.logoo),
            contentDescription = "App Logo",
            modifier = Modifier
                .align(Alignment.Center)
                .size(180.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashBodyPreview() {
    SplashBody()
}
