package com.example.pieincreasingview

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.RectF

val parts : Int = 2
val arcs : Int = 5
val scGap : Float = 0.02f
val sizeFactor : Float = 4.9f
val delay : Long = 20
val colors : Array<String> = arrayOf(
    "#F44336",
    "#4CAF50",
    "#9C27B0",
    "#795548",
    "#2196F3"
)
val backColor : Int = Color.parseColor("#BDBDBD")
val deg : Float = 360f
