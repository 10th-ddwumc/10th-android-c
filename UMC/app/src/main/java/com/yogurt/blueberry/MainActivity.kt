package com.yogurt.blueberry

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yogurt.blueberry.databinding.ActivityMainBinding
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button01.setOnClickListener {
            binding.button01.setTextColor("#8E682D".toColorInt())
        }
        binding.button02.setOnClickListener {
            binding.button02.setTextColor("#20777C".toColorInt())
        }
        binding.button03.setOnClickListener {
            binding.button03.setTextColor("#4E369D".toColorInt())
        }
        binding.button04.setOnClickListener {
            binding.button04.setTextColor("#326835".toColorInt())
        }
        binding.button05.setOnClickListener {
            binding.button05.setTextColor("#6D302A".toColorInt())
        }
    }
}