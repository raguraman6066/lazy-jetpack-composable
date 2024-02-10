package com.example.lazycomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazycomposables.ui.theme.LazyComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyComposablesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var osList= listOf<String>("Android","Windows","IOS","Linus","Android","Windows","IOS","Linus","Android","Windows","IOS","Linus","Android","Windows","IOS","Linus","Android","Windows","IOS","Linus")
                   // PopulateItems(osList = osList)
                   // DemoLazyColumn(osList = osList)
                   // DemoLazyRow(osList = osList)
                    DemoLazyGrid(osList = osList)
                }
            }
        }
    }
}

@Composable
fun PopulateItems(osList:List<String>){
    Column {
        osList.forEach {
            CreateRowItems(osName = it)
        }
    }

}

@Composable
fun CreateRowItems(osName:String){
    Row {
        Text(text = osName, fontSize = 32.sp)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyComposablesTheme {
        Greeting("Android")
    }
}

@Composable
fun DemoLazyColumn(osList: List<String>){
   LazyColumn {
//       item {
//           Text(text = "Your First Item")
//       }
//       items(5){
//           index ->  Text(text = "Index $index")
//       }
       items(osList){
           Text(text = it, fontSize = 32.sp)
       }
   }
}
//work like recycledview..removes invisible items while scrolling
@Composable
fun DemoLazyRow(osList: List<String>){
  LazyRow{
      items(osList){
          Text(text = "$it ", fontSize = 20.sp, color = Color.Red)
      }
  }
}

@Composable
fun DemoLazyGrid(osList: List<String>){
   LazyVerticalGrid(
       columns = GridCells.Adaptive(150.dp),
     //  columns = GridCells.Fixed(3),

       content = {
       //       items(osList){
//           Text(text = it, fontSize = 25.sp)
//       }

       items(osList.size){
           index ->  Card(modifier = Modifier
           .padding(4.dp)
           .fillMaxWidth(), elevation = CardDefaults.cardElevation(8.dp), colors = CardDefaults.cardColors(Color.Blue)) {
           Text(text = osList[index], fontSize = 20.sp, color = Color.White, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
       }
       }
   })
}

