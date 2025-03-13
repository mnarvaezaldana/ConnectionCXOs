package com.marcos.connectioncxos

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.marcos.connectioncxos.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<ConnectionVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener { getData() }

        binding.connectionStatus.text = "bytes: $viewModel.getWifiInfo().toString()"
        getData()
    }

    private fun getData() {
        lifecycleScope.launch {
            viewModel.getData().let { content ->
                withContext(Dispatchers.Main) {
                    binding.content.text = content
                }
            }
        }
    }

}