package com.example.taptomakemoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taptomakemoney.ui.theme.TapToMakeMoneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TapToMakeMoneyTheme {
                // A surface container using the 'background' color from the theme
                Tap()
            }
        }
    }
}



@Composable
fun Tap() {
    val money = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onBackground
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$ ${money.value}", style = TextStyle(
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(130.dp))
            MyButton(moneyCounter = money.value) {
                newValue -> money.value = newValue
            }
    }
}}

@Composable
fun MyButton(moneyCounter: Int = 0,updateMoneyCounter: (Int) -> Unit)  {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        ElevatedButton(onClick = {
            updateMoneyCounter(moneyCounter + 1)
        }, modifier = Modifier
            .padding(5.dp)
            .size(100.dp),
            shape = RoundedCornerShape(9),
            elevation = ButtonDefaults.elevatedButtonElevation(4.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF3F51B5))
        ) {
            Text(text = "Tap", modifier = Modifier)

        }


        ElevatedButton(onClick = {
            updateMoneyCounter(0)
        }, modifier = Modifier
            .padding(5.dp)
            .size(100.dp),
            shape = RoundedCornerShape(9),
            elevation = ButtonDefaults.elevatedButtonElevation(4.dp),
            colors = ButtonDefaults.buttonColors(Color(0x95FF5722))
        ) {
            Text(text = "Refresh", modifier = Modifier)

        }

    }

}



@Preview(showBackground = true)
@Composable
fun prev() {

}
