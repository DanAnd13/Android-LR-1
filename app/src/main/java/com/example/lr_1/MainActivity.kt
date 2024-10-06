package com.example.lr_1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import com.example.lr_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: ButtonClickViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            viewModel.buttonText.observe(this, Observer { newText ->
                binding.titleText.text = newText
            })

            binding.firstButton.setOnClickListener {
                viewModel.updateText(getString(R.string.onbuttonclick_in_own_class))
            }
        }
        fun On_button_click(view: View) {
            viewModel.updateTextFromXml(getString(R.string.onbuttonclick_in_xml))
        }
}