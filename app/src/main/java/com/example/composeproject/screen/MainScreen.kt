package com.example.composeproject.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.composeproject.R
import com.example.composeproject.ui.theme.Pink40
import com.example.composeproject.viewmodel.MainScreenViewModel

// 로직을 구현하는 함수는 첫글자 소문자
// Composable -> 컴포저블을 시작한다 이 함수는 첫글자 대문자로 시작
// 폰트 사이즈 * 1.5(150%) / 폰트 사이즈 * 0.006 (0.6%)
// 가로는 화면 사이즈 최대로 하고 패딩 추가, 세로는 직접 하드코딩
// modifier는 인자로 받아서 공통으로 수정할 수 있다. -> 빼라.
// interactioinsource는 포커스에 따른 효과를 줄 수 있다.
//  = remember 변수는 .value로 접근

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Gray, shape = RoundedCornerShape(4.dp)),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Hello World!",
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.096.sp,
            color = Pink40
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Hello Good!",
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.096.sp,
            color = Pink40,
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Hello",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.096.sp,
                color = Pink40
            )
            Text(
                text = "World",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.096.sp,
                color = Pink40
            )
        }
    }
}

@Composable
fun ImageTask() {
    Row {
        Box(
            modifier = Modifier
                .size(70.dp) // 박스 크기 설정
                .clip(CircleShape) // 박스 원형
        ) {
            // 이미지
            Image(
                painter = painterResource(id = R.drawable.sisley_alfred),
                contentDescription = "Alfred Sisley Image",
                modifier = Modifier.matchParentSize()
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
        ) {
            // 상단 텍스트
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Alfred Sisley",
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            // 하단 텍스트
            Text(
                modifier = Modifier
                    .padding(top = 3.dp)
                    .fillMaxWidth(),
                text = "3 minutes ago",
                fontSize = 16.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
fun BoxScreen() {
    Column {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(30.dp)
                .background(Color.Transparent)
                .border(1.dp, Color.Blue, CircleShape)
        ) {
        }
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(Color.Blue)
        ) {
        }
    }
}

@Composable
fun LazyColumnScreen(viewModel: MainScreenViewModel) {
    LazyColumn {
        items(viewModel.getAllPerson()) { person ->
            CustomItem(person = person)
        }
    }
}

data class Person(
    val id: Int,
    val name: String,
    val age: Int
)

// remember = 값 저장
// rememberSaveable = 리컴포지션 상황에도 값 불변
@Composable
fun CustomItem(person: Person) {
    var isSelect by rememberSaveable {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = person.id.toString(),
            fontSize = 40.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.name,
            fontSize = 40.sp,
            color = Color.Black,
            fontWeight = FontWeight.Light
        )
        Text(
            text = person.age.toString(),
            fontSize = 40.sp,
            color = Color.Black,
            fontWeight = FontWeight.ExtraLight
        )
        Text(text = isSelect.toString())
        Button(
            onClick = {
                isSelect = !isSelect
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSelect) Color.Red else Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(text = if (isSelect) "좋아요" else "싫어요")
        }
    }
}

@Composable
fun ButtonTest() {
    val text = remember {
        mutableStateOf(0)
    }
    Column {
        Text(text = text.value.toString())
        Button(onClick = {
            text.value++
        }) {
            Text(text = "숫자 1 올리기")
        }
    }
}

@Composable
fun test() {
    Row {
        Button(
            onClick = {},
            modifier = Modifier
                .wrapContentSize(),

            ) {
            Text(text = "버튼1", fontSize = 10.sp)
        }
        Button(onClick = {}) {
            Text(text = "버튼2")
        }
        Button(onClick = {}) {
            Text(text = "버튼3")
        }
        Button(onClick = { }) {
            Text(text = "버튼4")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestTextField() {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(1.dp, Color.Blue, RoundedCornerShape(4.dp))
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                singleLine = true,
                textStyle = TextStyle(fontSize = 16.sp),

                // PlaceHolder 설정
                decorationBox = { innerTextField ->
                    Text(
                        text = if (text.equals("")) "입력하세요" else "",
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )
                    innerTextField()
                }
            )
            if (text.isNotEmpty()) {
                Icon(
                    modifier = Modifier
                        .size(22.dp)
                        .clickable {
                            text = ""
                        },
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear",
                )
            }
        }
    }

}

// showSystemUi = true - 핸드폰 모양으로 Preview 가능
// showBackground = true - 배경 보이기
@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(12.dp)
//    ) {
//    }
//    LazyColumnScreen(MainScreenViewModel())
    TestTextField()

}

// 다음주 코일 이미지 주소값 받아오기