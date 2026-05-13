package com.artshz.habits.home.presentation.index.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artshz.habits.R

@Composable
@Preview
fun PreviewQuote() {
    HomeQuote(
        text = "Esta es una prueba de quote",
        author = "anonimo",
        image = R.drawable.quote_img1
    )
}

@Composable
fun HomeQuote(
    text: String,
    author: String,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .aspectRatio(1f)
                .align(Alignment.TopEnd)
                .graphicsLayer(
                    scaleX = 1.7f,
                    scaleY = 1.7f
                )
                .offset(x = (-14).dp, y = 11.dp)
        )
        Column(
            modifier = Modifier
                .padding(vertical = 26.dp, horizontal = 16.dp)
                .align(Alignment.TopStart)
                .fillMaxWidth(0.7f)
        ) {
            Text(
                text = text.uppercase(),
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "- ${author.uppercase()}",
                color = MaterialTheme.colorScheme.tertiary.copy(
                    alpha = 0.5f
                ),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}