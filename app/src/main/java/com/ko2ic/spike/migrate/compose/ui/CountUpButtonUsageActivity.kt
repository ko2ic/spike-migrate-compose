package com.ko2ic.spike.migrate.compose.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.ko2ic.spike.migrate.compose.ui.view.CountUpButton

class CountUpButtonUsageActivity : AppCompatActivity() {

  companion object {
    fun intent(context: Context) = Intent(context, CountUpButtonUsageActivity::class.java).apply {
      flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CountUpButtonView()
    }
  }

  @Composable
  fun CountUpButtonView() {
    AndroidView(
      factory = ::CountUpButton,
    )
  }
}