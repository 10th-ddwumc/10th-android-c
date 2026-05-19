package com.jihee.week2_mission.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jihee.week2_mission.R
import com.jihee.week2_mission.RetrofitInstance
import com.jihee.week2_mission.User

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen() {
    var myName by remember { mutableStateOf("") }
    var myAvatar by remember { mutableStateOf("") }

    var userList by remember {
        mutableStateOf<List<User>>(emptyList())
    }

    LaunchedEffect(Unit) {

        try {
            val response = RetrofitInstance.api.getUsers(
                "reqres_842dfb047c9043af967deb9a16fb3dac",
                1
            )

            userList = response.data

            val userResponse = RetrofitInstance.api.getUser(
                "reqres_842dfb047c9043af967deb9a16fb3dac",
                1
            )

            val me = userResponse.data

            myName = "${me.first_name} ${me.last_name}"
            myAvatar = me.avatar

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    val pagerState = rememberPagerState(
        pageCount = { userList.size }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = myAvatar,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(100.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = myName,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { },
            modifier = Modifier.size(width = 151.dp, height = 49.dp)
        ) {
            Text("프로필 수정")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_divider),
            contentDescription = null
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_order),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_columnrectangle),
                contentDescription = null,
                modifier = Modifier.height(100.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_pass),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_columnrectangle),
                contentDescription = null,
                modifier = Modifier.height(100.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_event),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_columnrectangle),
                contentDescription = null,
                modifier = Modifier.height(100.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_setting),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_divider),
            contentDescription = null
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "팔로잉(3)",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "편집",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        if (userList.isNotEmpty()) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.height(250.dp)
            ) { page ->
                val user = userList[page]

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AsyncImage(
                        model = user.avatar,
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(100.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "${user.first_name} ${user.last_name}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}