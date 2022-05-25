package com.ko2ic.spike.migrate.compose.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class MainViewModel : ViewModel() {

  private val _onTransit = MutableSharedFlow<Event<String>>(extraBufferCapacity = 1)
  val onTransit = _onTransit.asSharedFlow()

  fun onClickToCustomView() {
    _onTransit.tryEmit(Event("toCustomView"))
  }

  fun onClickToXmlView() {
    _onTransit.tryEmit(Event("toXmlView"))
  }

  fun onClickToComposeView() {
    _onTransit.tryEmit(Event("toComposeView"))
  }
}