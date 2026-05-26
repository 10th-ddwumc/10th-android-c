package com.yogurt.umc_nike_clone_compose.ui.screen.my

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.yogurt.umc_nike_clone_compose.R
import com.yogurt.umc_nike_clone_compose.ui.theme.UMC_NIKE_clone_composeTheme

@Composable
fun MyScreen(viewModel: MyViewModel = hiltViewModel()) {
    val gray100 = Color(0xFFF5F5F5)
    val gray600 = Color(0xFF757575)
    val strokeColor = Color(0xFFE4E4E4)

    val profileResult by viewModel.profileResult.collectAsState()
    val userListResult by viewModel.userListResult.collectAsState()

    val profileData = profileResult?.getOrNull()?.userData
    val userList = userListResult?.getOrNull()?.userList ?: emptyList()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Spacer(modifier = Modifier.height(44.dp))
            if (profileData?.avatar != null) {
                AsyncImage(
                    model = profileData.avatar,
                    contentDescription = "프로필 사진",
                    modifier = Modifier
                        .size(84.dp)
                        .clip(CircleShape)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(84.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
            }
        }

        item {
            Text(
                text = if (profileData != null) "${profileData.firstName} ${profileData.lastName}" else "닉네임",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
        }

        item {
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
                    .width(180.dp)
                    .height(51.dp),
                border = BorderStroke(1.dp, strokeColor),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = "프로필 수정", fontWeight = FontWeight.Bold)
            }
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MenuItemContent(iconRes = R.drawable.ic_orderbox, label = "주문")
                Box(modifier = Modifier.width(1.dp).height(20.dp).background(strokeColor))
                MenuItemContent(iconRes = R.drawable.ic_identificationcard, label = "패스")
                Box(modifier = Modifier.width(1.dp).height(20.dp).background(strokeColor))
                MenuItemContent(iconRes = R.drawable.ic_calendarblank, label = "이벤트")
                Box(modifier = Modifier.width(1.dp).height(20.dp).background(strokeColor))
                MenuItemContent(iconRes = R.drawable.ic_gear, label = "설정")
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.55.dp)
                    .background(gray100)
            )
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 19.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "나이키 멤버 혜택",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 6.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.caretright),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                }
                Text(
                    text = "0개 혜택 사용 가능",
                    fontSize = 12.sp,
                    color = gray600,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.55.dp)
                    .background(gray100)
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "팔로잉(${userList.size})", fontWeight = FontWeight.Bold)
                Text(text = "편집", color = gray600, fontSize = 12.sp)
            }
        }

        item {
            if (userList.isEmpty()) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(116.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(3) {
                        Box(
                            modifier = Modifier
                                .size(107.dp)
                                .background(Color.LightGray)
                        )
                    }
                }
            } else {
                val pagerState = rememberPagerState(pageCount = { userList.size })
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(116.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    pageSize = PageSize.Fixed(107.dp),
                    pageSpacing = 8.dp
                ) { page ->
                    val user = userList[page]
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        AsyncImage(
                            model = user.avatar,
                            contentDescription = "${user.firstName} 프로필",
                            modifier = Modifier.size(107.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp)
                    .height(55.dp)
                    .background(gray100),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "회원가입일 : 2025년 9월",
                    color = gray600,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
private fun MenuItemContent(iconRes: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Text(text = label, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    UMC_NIKE_clone_composeTheme {
        MyScreen()
    }
}
