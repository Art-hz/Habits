package com.artshz.habits.home.presentation.index.components

import android.widget.CheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artshz.habits.core.presentation.HabitCheckbox
import com.artshz.habits.home.domain.models.Habit
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime

@Preview
@Composable
fun PreviewHomeHabit() {
    HomeHabit(
        habit = Habit(
            id = "1",
            name = "Test",
            completedDates = listOf(LocalDate.now()),
            reminder = LocalTime.now(),
            frequency = listOf(DayOfWeek.WEDNESDAY),
            startDate = ZonedDateTime.now()
        ),
        selectedDate = LocalDate.now(),
        onCheckedChange = {},
        onClickHabit = {}
    )
}

@Composable
fun HomeHabit(
    modifier: Modifier = Modifier,
    habit: Habit,
    selectedDate: LocalDate,
    onCheckedChange: (Boolean) -> Unit,
    onClickHabit: () -> Unit
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
            .background(color = Color.White)
            .clickable {onClickHabit()},
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(start = 9.dp),
            text = habit.name,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.tertiary
        )

        HabitCheckbox(
            isChecked = habit.completedDates.contains(selectedDate)
        ) {
            onCheckedChange(it)
        }
    }
}