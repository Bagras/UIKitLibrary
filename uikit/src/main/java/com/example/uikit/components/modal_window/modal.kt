package com.example.uikit.components.modal_window

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorBlack
import com.example.uikit.theme.ColorDivider
import kotlinx.coroutines.launch

@Composable
fun ModalWindowSelect(selectInputChoice: (String) -> Unit, sheetState: ModalBottomSheetState) {
    val scope = rememberCoroutineScope()
    val selectList = mutableListOf<String>(
        "Мужчинам",
        "Женщинам",
        "Детям",
        "Аксессуары"
    )
    Column(Modifier.fillMaxSize().testTag("BottomSheet")) {
        Spacer(Modifier.height(20.dp))
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Text("Выберите категорию", fontSize = 28.sp, color = ColorBlack)
        }
        Spacer(Modifier.height(40.dp))
        LazyColumn(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            items(selectList) {
                Column(Modifier.fillMaxWidth().padding().clickable{
                    selectInputChoice
                    scope.launch { sheetState.hide() }
                },
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        it,
                        fontSize = 20.sp,
                        color = ColorBlack,
                        modifier = Modifier.padding(vertical = 15.dp)
                    )
                    Divider(thickness = 1.dp, color = ColorDivider)
                }
            }
        }
    }

}


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetFun(modifier: Modifier = Modifier, showModalSheet: MutableState<Boolean>, sheetState: ModalBottomSheetState) {
    val scope = rememberCoroutineScope()
    Column(Modifier.padding(horizontal = 20.dp, vertical = 24.dp)) {
        Row(Modifier.fillMaxWidth()) {
            Box(Modifier.width(267.dp)){
                Text(
                    "Рубашка Воскресенье для машинного вязанья",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Box(Modifier
                .fillMaxWidth()
                .height(32.dp), contentAlignment = Alignment.CenterEnd){
                Card(modifier
                    .size(32.dp)
                    .clickable {
                        showModalSheet.value = !showModalSheet.value
                        scope.launch {
                            sheetState.hide()
                        }
                    }, shape = CircleShape) {
                    Box(Modifier.size(32.dp), contentAlignment = Alignment.Center){
                        Icon(painter = painterResource(R.drawable.icon_close), contentDescription = null)
                    }
                }
            }

        }
        Spacer(Modifier.height(20.dp))
        Column(
            Modifier.fillMaxWidth()
        ) {
            Text(
                "Описание",
                fontSize = 16.sp,
                color = Color(0xff939396),
                fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Мой выбор для этих шапок – кардные составы, которые раскрываются деликатным пушком. Кашемиры, мериносы, смесовки с ними отлично подойдут на шапку.\n" +
                        "Кардные составы берите в большое количество сложений, вязать будем резинку 1х1, плотненько.\n" +
                        "Пряжу 1400-1500м в 100г в 4 сложения, пряжу 700м в 2 сложения. Ориентир для конечной толщины – 300-350м в 100г.\n" +
                        "Артикулы, из которых мы вязали эту модель: Zermatt Zegna Baruffa, Cashfive, Baby Cashmere Loro Piana, Soft Donegal и другие.\n" +
                        "Примерный расход на шапку с подгибом 70-90г.", fontSize = 15.sp
            )


        }

        Spacer(Modifier.height(49.dp))
        Column(Modifier.fillMaxWidth()) {
            Text(
                "Примерный расходж:",
                fontSize = 14.sp,
                color = Color(0xff939396)
            )
            Spacer(Modifier.height(4.dp))
            Text(
                "80-90 г",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Spacer(Modifier.height(20.dp))
        Button(onClick = {

        },
            modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(ColorAccent),
            shape = RoundedCornerShape(10.dp)
        ) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text("Добавить за 690 ₽")
            }
        }
    }
    Spacer(Modifier.height(20.dp))


}
