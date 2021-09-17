package me.pengj.navigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                XMLButton()
                Spacer(modifier = Modifier.height(32.dp))
                ComposeButton()
            }
        }
    }

    @Composable
    fun XMLButton() {
        Button(modifier = Modifier.width(240.dp), onClick = {
            openActivity(XMLActivity::class.java)
        }) {
           Text(text = "XML")
        }
    }

    @Composable
    fun ComposeButton() {
        Button(modifier = Modifier.width(240.dp), onClick = {
            openActivity(ComposeActivity::class.java)
        }) {
            Text(text = "Compose")
        }
    }

    private fun<T> openActivity(clazz: Class<T>) {
        startActivity(Intent(this, clazz))
    }
}