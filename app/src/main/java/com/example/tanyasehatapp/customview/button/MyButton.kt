package com.example.diarystoryapp.customview.button

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.tanyasehatapp.R

class MyButton : AppCompatButton {

    private lateinit var enabledBackground: Drawable
    private lateinit var disabledBackground: Drawable
    private var txtColor: Int = 0

    constructor(context: Context) : super(context){
        init()

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun updateButtonState() {
        background = if (isEnabled) enabledBackground else disabledBackground
        text = if (isEnabled) "Submit" else "Isi Dulu"
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        updateButtonState()
        setTextColor(txtColor)
        textSize = 12f
        gravity = Gravity.CENTER
        text = if(isEnabled) "Submit" else "Isi Dulu"
    }

    private fun init() {
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        enabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button) as Drawable
        disabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button_disabled) as Drawable
    }
}