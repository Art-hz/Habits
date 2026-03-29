package com.artshz.habits.authentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.artshz.habits.R
import com.artshz.habits.core.presentation.HabitTitle

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.33f))
            HabitTitle(
                title = "Welcome to monumental habits",
                modifier = Modifier.fillMaxWidth(0.7f)
            )
            Spacer(modifier = Modifier.weight(1F))
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Log in with email",
                    modifier = Modifier.fillMaxWidth().padding(top = 7.dp, bottom = 12.dp),
                    style = MaterialTheme.typography.titleMedium.copy(
                        textAlign = TextAlign.Center
                    )
                )
                HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary)

            }
        }
    }
}
