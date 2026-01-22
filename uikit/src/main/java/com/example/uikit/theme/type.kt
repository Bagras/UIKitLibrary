package com.example.uikit.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Title_1_Semibold = Typography(
    titleLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight(600),
        lineHeight = 28.sp,
        letterSpacing = 0.33.sp
    )
)

val Title_1_ExtraBold = Typography(
    titleLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight(800),
        lineHeight = 28.sp,
        letterSpacing = 0.33.sp
    )
)

val Title_2_Regular = Typography(
    titleMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight(400),
        lineHeight = 28.sp,
        letterSpacing = 0.38.sp
    )
)

val Title_2_Semibold = Typography(
    titleMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight(600),
        lineHeight = 28.sp,
        letterSpacing = 0.38.sp
    )
)

val Title_2_ExtraBold = Typography(
    titleMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight(800),
        lineHeight = 28.sp,
        letterSpacing = 0.38.sp
    )
)

val Title_3_Regular = Typography(
    titleSmall = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight(400),
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    )
)

val Title_3_Medium = Typography(
    titleSmall = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight(500),
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    )
)

val Title_3_Semibold = Typography(
    titleSmall = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight(600),
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    )
)

val Headline_Regular = Typography(
    headlineMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        lineHeight = 20.sp,
        letterSpacing = (-0.32).sp
    )
)

val Headline_Medium = Typography(
    headlineMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight(500),
        lineHeight = 20.sp,
        letterSpacing = (-0.32).sp
    )
)

val Text_Regular = Typography(
    bodyMedium = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight(400),
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    )
)

val Text_Medium = Typography(
    bodyMedium = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight(500),
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    )
)

val Caption_Regular = Typography(
    bodyLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    )
)

val Caption_Semibold = Typography(
    bodyLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight(600),
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

val Caption_2_Regular = Typography(
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight(400),
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    )
)

val Caption_2_Bold = Typography(
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight(700),
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    )
)


object CustomTypography{
    val title_1_semibold = Title_1_Semibold.titleLarge
    val title_1_extrabold = Title_1_ExtraBold.titleLarge
    val title_2_regular = Title_2_Regular.titleMedium
    val title_2_semibold = Title_2_Semibold.titleMedium
    val title_2_extrabold = Title_2_ExtraBold.titleMedium
    val title_3_regular = Title_3_Regular.titleSmall
    val title_3_medium = Title_3_Medium.titleSmall
    val title_3_semibold = Title_3_Semibold.titleSmall
    val headline_regular = Headline_Regular.headlineMedium
    val headline_medium = Headline_Medium.headlineMedium
    val text_regular = Text_Regular.bodyMedium
    val text_medium = Text_Medium.bodyMedium
    val caption_regular = Caption_Regular.bodyLarge
    val caption_semibold = Caption_Semibold.bodyLarge
    val caption_2_regular = Caption_2_Regular.bodySmall
    val caption_2_bold = Caption_2_Bold.bodySmall



}