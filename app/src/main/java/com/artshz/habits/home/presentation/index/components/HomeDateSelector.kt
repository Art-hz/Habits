package com.artshz.habits.home.presentation.index.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.ZonedDateTime
import java.util.Date

@Composable
fun HomeDateSelector(
    selectedDate: ZonedDateTime,
    currentDate: ZonedDateTime, // la diferencia con dateTime es que zoned detecta la zona horaria entonces si cambias de pais lo detecta y ajusta
    onDateSelected: (ZonedDateTime) -> Unit,
    modifier: Modifier = Modifier,
    datesToShow: Int = 4
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        for (i in datesToShow downTo 0) {
            val date = currentDate.minusDays(i.toLong())
            HomeDateItem(
                date = date,
                isSelected = date.toLocalDate() == selectedDate.toLocalDate(),
                onClick = { onDateSelected(date) }
            )
        }
    }

}