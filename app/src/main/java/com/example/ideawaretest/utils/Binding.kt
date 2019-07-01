package com.example.ideawaretest.utils

import android.text.format.DateFormat
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.ideawaretest.R
import java.util.*


@BindingAdapter("android:visibility")
fun setVisibility(view: View, value: String?) {
    view.visibility = if (value == "postponed") View.VISIBLE else View.GONE
}

@BindingAdapter("day")
fun setDay(label: TextView, value: Date?) {
    val day = DateFormat.format("dd", value) as String
    label.text = day
}

@BindingAdapter("day_week")
fun setDayWeek(label: TextView, value: Date?) {
    val dayWeek = DateFormat.format("EEE", value) as String
    label.text = dayWeek
}

@BindingAdapter("date_match")
fun setDateMatch(label: TextView, value: Date?) {
    val dayWeek = DateFormat.format("|  MMM dd, yyyy 'at' HH:mm", value) as String
    label.text = dayWeek
}

@BindingAdapter("postponed")
fun setPostponed(label: TextView, value: String?) {
    val color = if (value == "postponed") R.color.colorRed else R.color.colorGray
    label.setTextColor(ContextCompat.getColor(label.context, color))
}