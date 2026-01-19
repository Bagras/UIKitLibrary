package com.example.uikit.components.modal_window

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorDescription
import com.example.uikit.theme.ColorWhite
import kotlinx.coroutines.launch
import java.util.UUID

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CustomSnackBar(modifier: Modifier = Modifier, message: String) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Box(Modifier
            .fillMaxWidth()
            .height(130.dp),
            contentAlignment = Alignment.BottomCenter) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = ColorWhite
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) {
                Box(Modifier.fillMaxSize()) {
                    Box(Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, top = 24.dp, end = 50.dp)) {
                        Text(
                            message,
                            fontSize = 20.sp,
                            color = ColorBlack
                        )
                    }
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
                        Card(
                            modifier.size(20.dp),
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(ColorAccent)
                        ) {
                            Box(Modifier
                                .fillMaxSize()
                                .clickable {

                                }, contentAlignment = Alignment.Center){
                                Icon(painter = painterResource(R.drawable.icon_close), contentDescription = null, tint = ColorDescription, modifier = Modifier.size(15.dp))
                            }
                        }
                    }

                }
            }
        }

    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TestApp(modifier: Modifier = Modifier) {
    val snackbarHostState = remember { SnackbarHostState() }
    val snackBarEvent: MutableState<SnackBarViewEvent?> = remember { mutableStateOf(null) }

    fun triggerSnackbar(){
        snackBarEvent.value = SnackBarViewEvent(message = "Hello")
    }
    Surface(modifier.fillMaxSize()) {
        Scaffold(snackbarHost = {CustomSnackBarHost(hostState = snackbarHostState)}) {
            Button(onClick = {triggerSnackbar()}) {

            }
        }
    }





    snackBarEvent.value?.let {
        LaunchedEffect(it.eventId) {
            snackbarHostState.showSnackbar(message = it.message)
        }
    }
}

@Composable
fun CustomSnackBarHost(hostState: SnackbarHostState) {
    SnackbarHost(hostState = hostState){
        CustomSnackBar(message = "Нет подключения к интернету!")
    }
}
@Preview
@Composable
private fun Aaaaa() {
    TestApp()
}

data class SnackBarViewEvent(
    val message: String,
    val eventId: UUID = UUID.randomUUID()
)