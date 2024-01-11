package com.example.mylemonade2

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylemonade2.ui.theme.MyLemonade2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLemonade2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyLemonade2()
                }
            }
        }
    }
}

@Composable
fun MyLemonade2(modifier: Modifier = Modifier) {
    Column {
        TopBarTitle()
        MyLemonadeSteps()
    }
}

@Composable
fun MyLemonadeSteps(modifier: Modifier = Modifier) {
    var step by remember { mutableIntStateOf(1) }

    val imageId = when(step) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    val descriptionId = when(step) {
        0 -> R.string.step1_description
        1 -> R.string.step2_description
        2 -> R.string.step3_description
        3 -> R.string.step4_description
        else -> R.string.step1_description
    }

    val instructionId = when(step) {
        0 -> R.string.step1_instructions
        1 -> R.string.step2_instructions
        2 -> R.string.step3_instructions
        3 -> R.string.step4_instructions
        else -> R.string.step1_instructions
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { step = (step + 1) % 4  },
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
            ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = stringResource(id = descriptionId)
            )
        }
        Spacer(modifier = modifier.height(32.dp))
        Text(
            text = stringResource(id = instructionId),
            fontSize = 18.sp
        )
    }
}

@Composable
fun TopBarTitle(modifier: Modifier = Modifier) {
    Text(
        text = "My Lemonade",
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarTitlePreview(modifier: Modifier = Modifier) {
    TopBarTitle()
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyLemonade2Preview() {
    MyLemonade2Theme {
        MyLemonade2()
    }
}