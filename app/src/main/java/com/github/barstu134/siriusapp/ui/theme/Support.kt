package com.github.barstu134.siriusapp.ui.theme

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import androidx.navigation.NavHostController
import com.github.barstu134.siriusapp.LowPanel
import com.github.barstu134.siriusapp.R
import com.github.barstu134.siriusapp.TitleWithBackArrow
import com.github.barstu134.siriusapp.veryLightGray

@Composable
fun SupportChatScreen(navController:NavHostController) {
    var text by remember { mutableStateOf("") }
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            TitleWithBackArrow("Чат поддержки") {
                   navController.navigate("support")
            }
            Spacer(Modifier.weight(0.5f))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp, 0.dp, 16.dp, 16.dp))
                        .fillMaxWidth(0.8f)
                        .background(Color.Blue)
                ) {
                    Text(
                        "Нужна помощь с переводом", color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logo_short),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .padding(8.dp)
                        .background(veryLightGray, CircleShape)
                        .scale(1.5f)
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(0.dp, 16.dp, 16.dp, 16.dp))
                        .fillMaxWidth(0.8f)
                        .background(veryLightGray)
                ) {
                    Text(
                        "С какой операцией вам нужна помощь?", color = Color.Black,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logo_short),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .padding(8.dp)
                        .background(Color.Transparent, CircleShape)
                        .scale(1.5f),
                    tint = Color.Transparent
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp))
                        .fillMaxWidth(0.8f)
                        .background(veryLightGray, ShapeDefaults.Small)
                ) {
                    Text(
                        "2392309 на 120\$", color = Color.Black,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logo_short),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .padding(8.dp)
                        .background(Color.Transparent, CircleShape)
                        .scale(1.5f),
                    tint = Color.Transparent
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp))
                        .fillMaxWidth(0.8f)
                        .background(veryLightGray)
                ) {
                    Text(
                        "3920323 на 1239\$", color = Color.Black,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(0.8f),
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { Text("Введите сообщение") },
                    shape = MaterialTheme.shapes.medium,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                )
                Box(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(Color.Blue, CircleShape)) {
                    Icon(
                        painter = painterResource(id = R.drawable.send),
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.Center),
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun SupportScreen(navController:NavHostController) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Spacer(Modifier.size(24.dp))
            Text(
                "Чат по операциям и поддержка",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(0.5f)
            )

            Row {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Text(
                        "частые вопросы",
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.warning),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Text(
                        "помощь со сделками",
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("support_chat") }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo_short),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth(0.1f)
                            .scale(2f)
                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(0.5f)
                    ) {
                        Text(
                            "Чат поддержки",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "отлично \uD83D\uDC4D", color = Color.Gray
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            "17:54",
                            maxLines = 1,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.4f)
                                .aspectRatio(1f)
                                .background(
                                    Color.Black,
                                    CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "2",
                                color = Color.White,
                                modifier = Modifier
                                    .padding(4.dp),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth(0.1f)
                            .scale(1.5f)
                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(0.5f)
                    ) {
                        Text(
                            "Системные уведомления",
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text("проведен на +7 983 989 42 98", color = Color.Gray)
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            "13:04",
                            maxLines = 1,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.4f)
                                .aspectRatio(1f)
                                .background(
                                    Color.Black,
                                    CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "1",
                                color = Color.White,
                                modifier = Modifier
                                    .padding(4.dp),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
            Spacer(Modifier.weight(0.1f))
            LowPanel(navController)
            Spacer(Modifier.weight(0.01f))
        }
    }
}