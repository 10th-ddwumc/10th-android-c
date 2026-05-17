package com.yogurt.umc_nike_clone_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yogurt.umc_nike_clone_compose.ui.theme.UMC_NIKE_clone_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UMC_NIKE_clone_composeTheme() {
                NikeCloneApp()
            }
        }
    }
}
