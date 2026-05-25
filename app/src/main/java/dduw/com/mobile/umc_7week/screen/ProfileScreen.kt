package dduw.com.mobile.umc_7week.screen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dduw.com.mobile.umc_7week.R
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import dduw.com.mobile.umc_7week.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    onNavigateProfile: () -> Unit,
    viewModel: ProfileViewModel = viewModel()
) {
    val user = viewModel.user.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AsyncImage(
            model = user?.avatar,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (user != null)
                "${user.first_name} ${user.last_name}"
            else
                "로딩중...",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        //프로필 수정 버튼
        Button(
            onClick = { onNavigateProfile() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .width(220.dp)
                .height(55.dp)
        ) {
            Text(
                text = "프로필 수정",
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        //메뉴
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuItem(
                icon = R.drawable.order_icon,
                text = "주문"
            )
            MenuItem(
                icon = R.drawable.pass_icon,
                text = "패스"
            )
            MenuItem(
                icon = R.drawable.event_icon,
                text = "이벤트"
            )
            MenuItem(
                icon = R.drawable.setting_icon,
                text = "설정"
            )
        }

        Spacer( modifier = Modifier.height(20.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(20.dp))

        //멤버 혜택 카드
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(20.dp)
        ){
            Text(
                text = "나이키 멤버 혜택",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "0개 사용 가능",
                color = Color.Gray
            )
        }
        HorizontalDivider()

        Spacer(modifier = Modifier.height(8.dp))

        //팔로잉
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "팔로잉 (3)",
                fontSize = 15.sp,
                )

            Text(
                text = "편집",
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 팔로잉 리스트
        LazyRow(
            modifier = Modifier.padding(start = 20.dp)
        ) {

            items(5) {

                AsyncImage(
                    model = "https://picsum.photos/200",
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(140.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // 가입일
        Text(
            text = "회원 가입일: 2025년 9월",
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}
@Composable
fun MenuItem(
    icon: Int,
    text: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = text)
    }
}
@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileScreen(
        onNavigateProfile = {}
    )
}