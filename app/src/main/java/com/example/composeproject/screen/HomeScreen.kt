package com.example.composeproject.screen

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.composeproject.R
import com.example.composeproject.model.Product
import com.example.composeproject.viewmodel.ProductListViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // 텍스트
            Row {
                Text(text = "두정동", fontWeight = FontWeight.Bold)
                Image(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = "moreImage",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 8.dp)
                )
            }

            Row {
                // 검색 아이콘
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "searchImage",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 8.dp)
                )
                // 알림 아이콘
                Image(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "notificationImage",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Button(
                modifier = Modifier
                    .width(70.dp)
                    .height(35.dp),
                onClick = {
                    navController.navigate("all_screen")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff1f3f5)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 7.dp),
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.list),
                        contentDescription = "allImage",
                        modifier = Modifier
                            .size(18.dp)

                    )
                    Text(
                        "전체",
                        color = Color.Black,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center),
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(
                modifier = Modifier
                    .width(70.dp)
                    .height(35.dp),
                onClick = {
                    navController.navigate("job_screen")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff1f3f5)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 7.dp),
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.job),
                        contentDescription = "jobImage",
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Text(
                        "알바",
                        color = Color.Black,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center),
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(
                modifier = Modifier
                    .width(80.dp)
                    .height(35.dp),
                onClick = {
                    navController.navigate("real_estate_screen")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff1f3f5)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 9.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.realestate),
                        contentDescription = "jobImage",
                        modifier = Modifier
                            .size(20.dp)
                    )

                    Text(
                        "부동산",
                        color = Color.Black,
                        style = TextStyle(fontSize = 12.sp, textAlign = TextAlign.Center),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center),
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(
                modifier = Modifier
                    .width(80.dp)
                    .height(35.dp),
                onClick = {
                    navController.navigate("car_screen")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff1f3f5)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 9.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.car),
                        contentDescription = "jobImage",
                        modifier = Modifier
                            .size(20.dp)
                    )

                    Text(
                        "중고차", color = Color.Black, style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center),
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        ProductListScreen(viewModel = ProductListViewModel())
    }

}

@Composable
fun ProductListScreen(viewModel: ProductListViewModel) {
    LazyColumn {
        items(viewModel.getAllProduct()) { product ->
            CustomItem(product = product)
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Composable
fun CustomItem(product: Product) {
    Row {
        Box(
            modifier = Modifier
                .size(110.dp) // 박스 크기 설정
                .clip(shape = RoundedCornerShape(8.dp))
        ) {
            // 이미지
            Image(
                painter = rememberAsyncImagePainter(model = product.image),
                contentDescription = "Product Image",
                modifier = Modifier.matchParentSize()
            )
        }

        Column(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 상단 텍스트
                Text(
                    text = product.title,
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.setting),
                    contentDescription = "settingImage",
                    modifier = Modifier
                        .size(20.dp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 3.dp)
                    .fillMaxWidth()
            ) {
                // 하단 텍스트
                Text(
                    text = product.address,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Light
                )

                Spacer(modifier = Modifier.width(5.dp))

                // 하단 텍스트
                Text(
                    text = "- " + product.time,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Light
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 3.dp)
                    .fillMaxWidth()
            ) {
                if (product.status == 1) {
                    Button(
                        modifier = Modifier
                            .width(50.dp)
                            .height(20.dp),
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff1f3f5)),
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            "거래완료",
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center),
                            color = Color.Black,
                            style = TextStyle(fontSize = 10.sp),
                        )
                    }

                    Spacer(modifier = Modifier.width(5.dp))
                } else if (product.status == 2) {
                    Button(
                        modifier = Modifier
                            .width(50.dp)
                            .height(20.dp),
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff4B9D75)),
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            "예약중",
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center),
                            color = Color.White,
                            style = TextStyle(fontSize = 10.sp),
                        )
                    }

                    Spacer(modifier = Modifier.width(5.dp))
                }

                Text(
                    text = product.price,
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {

                if (product.comments > 0) {
                    Image(
                        painter = painterResource(id = R.drawable.chat2),
                        contentDescription = "commentsImage",
                        modifier = Modifier
                            .size(20.dp)
                    )

                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        text = product.comments.toString(),
                        fontSize = 12.sp,
                        color = Color.Gray,
                    )
                }

                if (product.likes > 0) {
                    Image(
                        painter = painterResource(id = R.drawable.likes),
                        contentDescription = "likesImage",
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        text = product.likes.toString(),
                        fontSize = 12.sp,
                        color = Color.Gray,
                    )
                }

            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}

