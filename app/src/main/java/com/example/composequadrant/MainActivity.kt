package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val titles = listOf<String>(
                        stringResource(R.string.title_text_a),
                        stringResource(R.string.title_text_b),
                        stringResource(R.string.title_text_c),
                        stringResource(R.string.title_text_d))
                    val bodies = listOf<String>(
                        stringResource(R.string.body_text_a),
                        stringResource(R.string.body_text_b),
                        stringResource(R.string.body_text_c),
                        stringResource(R.string.body_text_d)
                    )
                    val colors = listOf<androidx.compose.ui.graphics.Color>(
                        androidx.compose.ui.graphics.Color.Green,
                        androidx.compose.ui.graphics.Color.Yellow,
                        androidx.compose.ui.graphics.Color.Cyan,
                        androidx.compose.ui.graphics.Color.LightGray
                    )
                    AllQuadrantDisplay(titles = titles, bodies = bodies, colors = colors)
                }
            }
        }
    }
}

@Composable
fun QuadrantDisplay(title: String, body: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = body, textAlign = TextAlign.Justify)
    }
}

@Composable
fun AllQuadrantDisplay(titles: List<String>, bodies: List<String>, colors: List<androidx.compose.ui.graphics.Color>) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f)) {
            Column(Modifier.background(colors[0]).fillMaxWidth(0.5f).fillMaxHeight().padding(16.dp)) {
                QuadrantDisplay(title = titles[0], body = bodies[0])
            }
            Box(Modifier.background(colors[1]).fillMaxWidth().fillMaxHeight().padding(16.dp)) {
                QuadrantDisplay(title = titles[1], body = bodies[1])
            }
        }
        Row(Modifier.fillMaxWidth().fillMaxHeight()) {
            Box(Modifier.background(colors[2]).fillMaxWidth(0.5f).fillMaxHeight().padding(16.dp)) {
                QuadrantDisplay(title = titles[2], body = bodies[2])
            }
            Box(Modifier.background(colors[3]).fillMaxWidth().fillMaxHeight().padding(16.dp)) {
                QuadrantDisplay(title = titles[3], body = bodies[3])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        val titles = listOf<String>(
            stringResource(R.string.title_text_a),
            stringResource(R.string.title_text_b),
            stringResource(R.string.title_text_c),
            stringResource(R.string.title_text_d))
        val bodies = listOf<String>(
            stringResource(R.string.body_text_a),
            stringResource(R.string.body_text_b),
            stringResource(R.string.body_text_c),
            stringResource(R.string.body_text_d)
        )
        val colors = listOf<androidx.compose.ui.graphics.Color>(
            androidx.compose.ui.graphics.Color.Green,
            androidx.compose.ui.graphics.Color.Yellow,
            androidx.compose.ui.graphics.Color.Cyan,
            androidx.compose.ui.graphics.Color.LightGray
        )
        AllQuadrantDisplay(titles = titles, bodies = bodies, colors = colors)
    }
}