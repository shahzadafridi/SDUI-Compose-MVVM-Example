package com.droidcon.sduicompsemvvm.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.droidcon.sduicompsemvvm.ui.screens.home.HomeScreen
import com.droidcon.sduicompsemvvm.ui.theme.SduiComposeMvvM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SduiComposeMvvM {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoadHomeScreen()
                }
            }
        }
    }
}

@Composable
fun LoadHomeScreen() {
     HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SduiComposeMvvM {
        LoadHomeScreen()
    }
}