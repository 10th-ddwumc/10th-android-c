package dduw.com.mobile.umc_7week.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dduw.com.mobile.umc_7week.R

@Composable
fun ShoppingBagScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(10.dp)
            .padding(top = 200.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Image(
           painter = painterResource(id=R.drawable.bagcircle),
           contentDescription = "장바구니 사진",
           modifier = Modifier.size(80.dp)
               .padding(bottom = 30.dp)
       )

        Text(
            text = "장바구니가 비어있습니다.",
            fontSize = 14.sp
        )

        Text(
            text = "제품을 추가하면 여기에 표시됩니다.",
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 350.dp)
        )
        Button(onClick = {
            navController.navigate("buy")
        },
            modifier = Modifier.width(300.dp)
                .height(50.dp)
        ){
            Text("주문하기")
        }
    }
}
