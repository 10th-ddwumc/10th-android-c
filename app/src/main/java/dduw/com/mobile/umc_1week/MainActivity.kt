package dduw.com.mobile.umc_1week

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dduw.com.mobile.umc_1week.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.yellow.setOnClickListener{
            binding.yellowText.setTextColor(Color.parseColor("#FFEFB6"))
        }

        binding.blue.setOnClickListener{
            binding.blueText.setTextColor(Color.parseColor("#CEE7F5"))
        }

        binding.purple.setOnClickListener{
            binding.purpleText.setTextColor(Color.parseColor("#BEC3ED"))
        }

        binding.green.setOnClickListener{
            binding.greenText.setTextColor(Color.parseColor("#B1D3B9"))
        }

        binding.red.setOnClickListener{
            binding.redText.setTextColor(Color.parseColor("#EB8B8B"))
        }
    }
}