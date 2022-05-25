package com.ko2ic.spike.migrate.compose.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.google.android.material.composethemeadapter.MdcTheme
import com.ko2ic.spike.migrate.compose.R
import com.ko2ic.spike.migrate.compose.databinding.ComposeViewFragmentBinding

class ComposeViewUsageFragment : Fragment(R.layout.compose_view_fragment) {

  companion object {
    fun newInstance() = ComposeViewUsageFragment()
  }

  private lateinit var viewModel: ComposeViewModel

  private var _binding: ComposeViewFragmentBinding? = null
  private val binding get() = _binding!!

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel = ViewModelProvider(this)[ComposeViewModel::class.java]
    _binding = DataBindingUtil.bind(view)
    binding.viewModel = viewModel
    binding.lifecycleOwner = viewLifecycleOwner
    binding.composeView.apply {
      setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
      setContent {
        MdcTheme(setTextColors = true, setDefaultFontFamily = false) {
          HelloCompose()
        }
      }
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  @Composable
  private fun HelloCompose() {
    Row {
      Checkbox(checked = true, onCheckedChange = {

      })
      Text(
        "Hello Compose!",
        style = MaterialTheme.typography.body2,
        modifier = Modifier
          .fillMaxWidth()
          .padding(24.dp)
          .wrapContentWidth(Alignment.CenterHorizontally)
      )
    }

  }

  @Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
  )
  @Preview
  @Composable
  fun DarkHelloComposePreview() {
    AppCompatTheme {
      HelloCompose()
    }
  }

  @Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
  )
  @Preview
  @Composable
  fun HelloComposePreview() {
    AppCompatTheme {
      HelloCompose()
    }
  }

}