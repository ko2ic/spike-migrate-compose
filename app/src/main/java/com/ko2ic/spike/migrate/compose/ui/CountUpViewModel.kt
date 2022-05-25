package com.ko2ic.spike.migrate.compose.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountUpViewModel : ViewModel() {

  private val _count: MutableStateFlow<Int> = MutableStateFlow(0)
  val count: StateFlow<Int> = _count.asStateFlow()

  fun increaseCount() {
    _count.value++
  }
}