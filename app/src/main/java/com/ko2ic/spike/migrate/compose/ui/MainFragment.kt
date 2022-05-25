package com.ko2ic.spike.migrate.compose.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ko2ic.spike.migrate.compose.R
import com.ko2ic.spike.migrate.compose.databinding.MainFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment(R.layout.main_fragment) {

  companion object {
    fun newInstance() = MainFragment()
  }

  private lateinit var viewModel: MainViewModel

  private var _binding: MainFragmentBinding? = null
  private val binding get() = _binding!!

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    _binding = DataBindingUtil.bind(view)
    binding.viewModel = viewModel
    binding.lifecycleOwner = viewLifecycleOwner
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.onTransit.collect { event ->
        withContext(Dispatchers.Main) {
          if (!isResumed) return@withContext
          if (event.peekContent() == "toCustomView") {
            startActivity(CountUpButtonUsageActivity.intent(requireActivity()))
          } else if (event.peekContent() == "toXmlView") {
            startActivity(XmlViewUsageActivity.intent(requireActivity()))
          } else if (event.peekContent() == "toComposeView") {
            startActivity(ComposeViewUsageActivity.intent(requireActivity()))
          }
        }
      }
    }
  }
}