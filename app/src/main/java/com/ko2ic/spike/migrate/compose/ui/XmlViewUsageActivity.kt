package com.ko2ic.spike.migrate.compose.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.ko2ic.spike.migrate.compose.databinding.XmlViewFragmentBinding

class XmlViewUsageActivity : AppCompatActivity() {

  companion object {
    fun intent(context: Context) = Intent(context, XmlViewUsageActivity::class.java).apply {
      flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      XmlView()
    }
  }

  @Composable
  fun XmlView() {
    AndroidViewBinding(
      factory = XmlViewFragmentBinding::inflate,
      update = {
        label2.text = "インフレート後に設定"
      })
  }
}