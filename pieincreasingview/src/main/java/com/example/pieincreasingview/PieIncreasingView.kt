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
val colors : Array<Int> = arrayOf(
    "#F44336",
    "#4CAF50",
    "#9C27B0",
    "#795548",
    "#2196F3"
).map {
    Color.parseColor(it)
}.toTypedArray()

val backColor : Int = Color.parseColor("#BDBDBD")
val deg : Float = 360f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawPieIncreasing(scale : Float, w : Float, h : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val size : Float = Math.min(w, h) / sizeFactor
    val gap : Float = deg / arcs
    save()
    translate(w / 2, h / 2)
    for (j in 0..(arcs - 1)) {
        val sf2j : Float = sf2.divideScale(j, arcs)
        val r : Float = size * 0.5f * sf1 + (size * 0.5f) * sf2j
        save()
        rotate(gap * j)
        drawArc(RectF(-r, -r, r, r), 0f, gap, true, paint)
        restore()
    }
    restore()
}

fun Canvas.drawPINode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    drawPieIncreasing(scale, w, h, paint)
}
