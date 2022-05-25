package com.ko2ic.spike.migrate.compose.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.R

class CountUpButton @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = R.attr.buttonStyle
) : androidx.appcompat.widget.AppCompatButton(context, attrs, defStyleAttr),
  View.OnClickListener {

  private var count = 0;

  init {
    isAllCaps = false
    setOnClickListener(this)
    text = "Count Up $count"
  }

  override fun onClick(v: View?) {
    count++
    text = "Count Up $count"
  }
}