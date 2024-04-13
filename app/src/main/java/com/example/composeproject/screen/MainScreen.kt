package com.example.composeproject.screen

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.composeproject.R
import com.example.composeproject.ui.theme.Pink40
import com.example.composeproject.viewmodel.MainScreenViewModel
import com.example.composeproject.viewmodel.SignUpViewModel

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
            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
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
        ) {}
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(Color.Blue)
        ) {}
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
    val id: Int, val name: String, val age: Int
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
            text = person.name, fontSize = 40.sp, color = Color.Black, fontWeight = FontWeight.Light
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
            }, colors = ButtonDefaults.buttonColors(
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
            modifier = Modifier.wrapContentSize(),

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
        modifier = Modifier.padding(12.dp)
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
            BasicTextField(value = text, onValueChange = {
                text = it
            }, singleLine = true, textStyle = TextStyle(fontSize = 16.sp),

                // PlaceHolder 설정
                decorationBox = { innerTextField ->
                    Text(
                        text = if (text.equals("")) "입력하세요" else "",
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )
                    innerTextField()
                })
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

@Composable
fun ExampleImage() {
//    Image(
//        painter = painterResource(id = R.drawable.sisley_alfred),
//        contentDescription = "exampleImage",
//        contentScale = ContentScale.Crop,
//    )

    Image(
        painter = rememberImagePainter(data = "https://i.pravatar.cc/300"),
        contentDescription = "Example Image",
    )

    // AsyncImage -> coil 라이브러리 사용
}

// 회원가입 화면
// 아이디, 비번, 회원가입 버튼
// placeholder 포커스에 따라 띄워지기
// border = 8.dp, height = 50.dp, 양 옆 padding = 12.dp
// font weight = normal, font size = 18.sp, 글씨 항상 중앙 정렬
// 아이디는 이메일 형식으로 받음 @ 들어왔을 때 테두리색은 주황색으로 바뀌게
// 비밀번호 부분은 숨기고 보여주게 하는 기능 추가
// 비밀번호 부분에서 텍스트 수 측정하는거 만들어서 10자리 이상이면 주황색
// 버튼 아이디, 비밀번호 부분에서 둘 다 주황색으로 바뀌었을 때 활성화 그 전에는 비활성화
// 아이디 부분에서 맨 앞글자가 대문자면 에러 표시 -> border 빨간색으로 표시 보더 밑에 작게 에러메시지 출력 : 맨 앞글자 대문자는 사용금지 (글자색상 빨간색)
// 컴포넌트 사이 18.dp 간격
@Composable
fun SignUpScreen(viewModel: SignUpViewModel) {

    // 텍스트필드 포커스 요청
    val focusRequester = remember {
        FocusRequester()
    }

    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .padding(12.dp)
    ) {
        // SignUp Title
        Text(
            text = "회원가입",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(18.dp))

        // Email TextField
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(
                    8.dp,
                    if (viewModel.email.contains("@") && viewModel.isEmailValidate)
                        Color(0xFFFFA500)
                    else Color.Black
                )
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BasicTextField(
                value = viewModel.email,
                onValueChange = {
                    viewModel.email = it
                    viewModel.isEmailSuccess = viewModel.email.contains("@")
                    Log.d("이메일 입력", viewModel.email)
                },

                // Focus 이벤트
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .onFocusChanged { focusState ->
                        // 이메일 텍스트 필드에 대한 포커스 감지
                        viewModel.isEmailFocused = focusState.isFocused
                    },

                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                ),
                singleLine = true,

                // PlaceHolder 설정
                decorationBox = { innerTextField ->
                    Text(
                        text = if (viewModel.email.isEmpty() && !viewModel.isEmailFocused) "이메일 입력" else "",
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )
                    innerTextField()
                })
        }

        // Email error message
        if (viewModel.email.isNotEmpty() && viewModel.email[0].isUpperCase()) {
            viewModel.isEmailValidate = false
            Text(
                text = "맨 앞글자 대문자는 사용금지",
                color = Color.Red,
                fontSize = 10.sp,
                fontWeight = FontWeight.Light
            )
        } else {
            viewModel.isEmailValidate = true
        }
        Spacer(modifier = Modifier.height(18.dp))

        // Password TextField
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(
                    8.dp,
                    if (viewModel.password.length >= 10) {
                        Color(0xFFFFA500)
                    } else Color.Black
                )
                .padding(horizontal = 8.dp)
                .padding(end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BasicTextField(
                value = viewModel.password,
                onValueChange = {
                    viewModel.password = it
                    viewModel.isPasswordSuccess = viewModel.password.length >= 10
                    Log.d("비밀번호 입력", viewModel.password)
                },

                // 비밀번호 가시성 설정
                visualTransformation = if (viewModel.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .onFocusChanged { focusState ->
                        // 비밀번호 텍스트 필드에 대한 포커스 감지
                        viewModel.isPasswordFocused = focusState.isFocused
                    },

                // PlaceHolder 설정
                decorationBox = { innerTextField ->
                    Text(
                        text = if (viewModel.password.isEmpty() && !viewModel.isPasswordFocused) "비밀번호 입력" else "",
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )
                    innerTextField()
                })

            // 비밀번호 가시성 아이콘
            Icon(
                painter = painterResource(id = R.drawable.eye),
                contentDescription = "passwordVisibleImage",
                modifier = Modifier
                    .size(22.dp)
                    .clickable {
                        viewModel.isPasswordVisible = !viewModel.isPasswordVisible
                    }
            )
        }
        Spacer(modifier = Modifier.height(18.dp))

        // SignUp Button
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                Log.d("회원가입 버튼", "클릭")
            },
            enabled = viewModel.isEmailSuccess && viewModel.isPasswordSuccess && viewModel.isEmailValidate,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (viewModel.isEmailSuccess && viewModel.isPasswordSuccess) Color(
                    0xFFFFA500
                ) else Color.Gray,
                contentColor = Color.White
            )
        ) {
            Text(text = "회원가입")
        }

        // 포커스 요청
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
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
//    )
//    }
//    LazyColumnScreen(MainScreenViewModel())
    SignUpScreen(viewModel = SignUpViewModel())
}

// 다음주 코일 이미지 주소값 받아오기