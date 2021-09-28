package com.example.moneywiseresearch

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.airbnb.lottie.compose.*

@Composable
fun TapToBegin(navigationEvent: ()->Unit){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.pigloop))

    // to control the animation
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = LottieConstants.IterateForever,


    )

    ConstraintLayout(

    ) {
        val (tapCallToAction, animationContainer) = createRefs()

        Scaffold(
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .constrainAs(tapCallToAction) {
                        top.linkTo(parent.top, margin = 20.dp)
                    }
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(20.dp)
                    .background(Color(0xFF8ad4f0))
            ) {
                Text("Tap to begin!", fontSize = 45.sp, fontWeight = FontWeight.Bold)
            }
            Box(
                modifier = Modifier
                    .constrainAs(animationContainer) {
                        top.linkTo(parent.top, margin = 15.dp)
                    }
                    .clickable{
                        navigationEvent()
                    }
            ) {
                LottieAnimation(composition, progress)
            }
        }
    }
}



//@Composable
//fun LottieExample() {
//
//    // to keep track if the animation is playing
//    // and play pause accordingly
//    var isPlaying by remember {
//        mutableStateOf(true)
//    }
//    // for speed
//    var speed by remember {
//        mutableStateOf(1f)
//    }
//
//    // remember lottie composition ,which
//    // accepts the lottie composition result
//    val composition by rememberLottieComposition(
//        LottieCompositionSpec
//            .RawRes(R.raw.code)
//    )
//
//
//    // to control the animation
//    val progress by animateLottieCompositionAsState(
//        // pass the composition created above
//        composition,
//
//        // Iterates Forever
//        iterations = LottieConstants.IterateForever,
//
//        // pass isPlaying we created above,
//        // changing isPlaying will recompose
//        // Lottie and pause/play
//        isPlaying = isPlaying,
//
//        // pass speed we created above,
//        // changing speed will increase Lottie
//        speed = speed,
//
//        // this makes animation to restart when paused and play
//        // pass false to continue the animation at which is was paused
//        restartOnPlay = false
//
//    )
//
//    // Column Composable
//    Column(
//        Modifier
//            .background(Color.White)
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Heading
//        Text(
//            text = "Lottie",
//            color = Color.Gray,
//            fontSize = 70.sp,
//            fontWeight = FontWeight.SemiBold,
//            fontStyle = FontStyle.Italic,
//            modifier = Modifier.padding(10.dp)
//        )
//
//        // LottieAnimation
//        // Pass the composition and the progress state
//        LottieAnimation(
//            composition,
//            progress,
//            modifier = Modifier.size(400.dp)
//        )
//
//        // Buttons to control the animation
//        Row(
//            horizontalArrangement = Arrangement.SpaceAround,
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//                // Button to decrease speed
//                Button(
//                    onClick = {
//                        // check to prevent speed going negative
//                        speed = max(speed - 0.25f, 0f)
//                    },
//                    // Button background color
//                    colors = ButtonDefaults.buttonColors(
//                        backgroundColor = Color(0xFF0F9D58)
//                    )
//                ) {
//                    Text(
//                        text = "-",
//                        color = Color.White,
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//
//                        )
//                }
//
//                // Button to Increase speed
//                Text(
//                    text = "Speed ( $speed ) ",
//                    color = Color.Black,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 15.sp, modifier = Modifier.padding(horizontal = 10.dp)
//
//                )
//                Button(
//                    onClick = {
//                        // Increase the speed by 0.25
//                        speed += 0.25f
//                    },
//                    colors = ButtonDefaults.buttonColors(
//                        backgroundColor = Color(0xFF0F9D58)
//                    )
//                ) {
//                    Text(
//                        text = "+",
//                        color = Color.White,
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp
//                    )
//                }
//            }
//
//            // Button to pause and play
//            Button(
//                onClick = {
//                    // change isPlaying state to pause/play
//                    isPlaying = !isPlaying
//                },
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = Color(0xFF0F9D58)
//                )
//            ) {
//                Text(
//                    // display text according to state
//                    text = if (isPlaying) "Pause" else "Play",
//                    color = Color.White
//                )
//            }
//        }
//    }
//}
