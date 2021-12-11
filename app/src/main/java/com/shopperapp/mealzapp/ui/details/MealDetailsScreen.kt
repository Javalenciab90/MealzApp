package com.shopperapp.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.shopperapp.model.response.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    var profilePictureSate by remember { mutableStateOf(MealProfilePictureSate.Normal)}
    val transition = updateTransition(targetState = profilePictureSate, label = "")
    val imageSize by transition.animateDp(targetValueByState = {it.size}, label = "")
    val imageColor by transition.animateColor(targetValueByState = {it.color}, label = "")
    val imageWidthSize by transition.animateDp(targetValueByState = {it.borderWidth}, label = "")
    Column() {
        Row() {
            Card(modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(
                    width = imageWidthSize,
                    color = imageColor
                )
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = meal?.imageUrl,
                        builder = { transformations(CircleCropTransformation()) }
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSize)
                        .padding(8.dp)
                )
            }
            Text(
                meal?.name ?: "default name",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = {
                profilePictureSate = if (profilePictureSate == MealProfilePictureSate.Normal)
                    MealProfilePictureSate.Expanded
                else
                    MealProfilePictureSate.Normal
            }) {
            Text(text = "Change state of meal profile picture")
        }
    }
}

enum class MealProfilePictureSate(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Cyan, 200.dp, 24.dp)
}