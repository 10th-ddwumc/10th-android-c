package com.jihee.week1_mission

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jihee.week1_mission.databinding.ActivityMainBinding
import android.graphics.Color

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.img1.setOnClickListener {
            binding.textView4.setTextColor(Color.parseColor("#FFD700"))
        }

        binding.img2.setOnClickListener {
            binding.textView5.setTextColor(Color.parseColor("#2196F3"))
        }

        binding.img3.setOnClickListener {
            binding.textView6.setTextColor(Color.parseColor("#9C27B0"))
        }

        binding.img4.setOnClickListener {
            binding.textView7.setTextColor(Color.parseColor("#4CAF50"))
        }

        binding.img5.setOnClickListener {
            binding.textView8.setTextColor(Color.parseColor("#F44336"))
        }
    }
}