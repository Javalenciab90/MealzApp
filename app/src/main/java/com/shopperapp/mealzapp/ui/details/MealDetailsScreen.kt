package com.shopperapp.mealzapp.ui.details

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.shopperapp.model.response.MealResponse
import java.lang.Float.min

@SuppressLint("NewApi")
@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value - 600f))
    Surface(color = MaterialTheme.colors.background) {
        Column() {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Green
                        )
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = meal?.imageUrl,
                                builder = { transformations(CircleCropTransformation()) }
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(max(100.dp, 200.dp * offset))
                        )
                    }
                    Text(
                        meal?.name ?: "default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
            }
        }
    }

}

enum class MealProfilePictureSate(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Cyan, 200.dp, 24.dp)
}