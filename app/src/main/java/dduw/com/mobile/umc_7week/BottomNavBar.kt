package dduw.com.mobile.umc_7week

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dduw.com.mobile.umc_7week.navigation.BottomNavItem

@Composable
fun BottomNavBar(navController: NavController) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Buy,
        BottomNavItem.WishList,
        BottomNavItem.Bag,
        BottomNavItem.Profile
    )

    NavigationBar {

        items.forEach { item ->

            NavigationBarItem(
                selected = false, // 나중에 개선 가능
                onClick = {
                    navController.navigate(item.route)
                },
                label = { Text(item.label) },

                icon = {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(28.dp)
                    )
                }
            )
        }
    }
}