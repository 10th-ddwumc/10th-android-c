package com.yogurt.umc_work02

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yogurt.umc_work02.databinding.ActivityMainBinding
import kotlin.getValue

class MainActivity : AppCompatActivity() {
    private val Tag = "LIFE_QUIZ"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(Tag, "onCreate")

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, HomeFragment())
            .commit()

        binding.bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_home -> {
                    Log.d("NAV_TEST", "홈 화면 교체 시도")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, HomeFragment())
                        .commit()
                    true
                }
                R.id.nav_purchase -> {
                    Log.d("NAV_TEST", "구매 화면 교체 시도")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, PurchaseFragment())
                        .commit()
                    true
                }
                R.id.nav_wishlist -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, WishlistFragment())
                        .commit()
                    true
                }
                R.id.nav_cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, CartFragment())
                        .commit()
                    true
                }
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, ProfileFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }

    }
    fun changeFragment(itemId: Int) {
        binding.bottomNav.selectedItemId = itemId
    }

    override fun onStart() {
        super.onStart()
        Log.d(Tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(Tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(Tag, "onRestart")
    }


}

