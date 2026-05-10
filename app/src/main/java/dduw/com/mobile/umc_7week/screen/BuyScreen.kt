package dduw.com.mobile.umc_7week.screen
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BuyScreen(
    onNavigateBuy: () -> Unit
) {
   Row(
       modifier = Modifier.padding(16.dp),
       verticalAlignment = Alignment.CenterVertically
   ) {
       Text(
           text = "전체",
           fontSize = 16.sp,
           modifier = Modifier.padding(end=10.dp)

       )
       Text(
           text = "Top&T-Shirts",
           fontSize = 16.sp,
           modifier = Modifier.padding(end=10.dp)
       )
       Text(
           text = "Shoes",
           fontSize = 16.sp,
           modifier = Modifier.padding(end=10.dp)
       )
   }
}
@Preview(showBackground = true)
@Composable
fun BuyPreview() {

   BuyScreen(
       onNavigateBuy = {}
    )
}