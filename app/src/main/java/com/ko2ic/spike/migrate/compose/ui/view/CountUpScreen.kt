package com.ko2ic.spike.migrate.compose.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ko2ic.spike.migrate.compose.ui.CountUpViewModel

@Composable
fun CountUpScreen(viewModel: CountUpViewModel) {
  val count: Int by viewModel.count.collectAsState()
  SideEffect {
    println("CountUpScreen")
  }
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {

    Text(
      text = "$count"
    )
    Button(onClick = {
      viewModel.increaseCount()
    }) {
      Icon(Icons.Outlined.Add, contentDescription = "+")
    }
  }
}