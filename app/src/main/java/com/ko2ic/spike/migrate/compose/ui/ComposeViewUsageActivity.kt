package com.ko2ic.spike.migrate.compose.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ko2ic.spike.migrate.compose.R

class ComposeViewUsageActivity : AppCompatActivity() {

  companion object {
    fun intent(context: Context) = Intent(context, ComposeViewUsageActivity::class.java).apply {
      flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.compose_view_activity)
    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .replace(R.id.container, ComposeViewUsageFragment.newInstance())
        .commitNow()
    }
  }
}