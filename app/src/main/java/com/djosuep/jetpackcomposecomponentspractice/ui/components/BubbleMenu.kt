package com.djosuep.jetpackcomposecomponentspractice.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun FloatingBubbleNavigationButton(){

    var showNavigation by remember{ mutableStateOf(false) }
    var isChecked by remember{ mutableStateOf("Home") }

    val animatedCorners: Dp by animateDpAsState(targetValue = if (showNavigation) 16.dp else 50.dp)
    val animatedWidth: Dp by animateDpAsState(targetValue = if (showNavigation) 320.dp else 56.dp )

    val icons = listOf(
        Icons.Default.Home to "Home",
        Icons.Default.Notifications to "Notifications",
        Icons.Default.Person to "User"
    )

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                FloatingActionButton(
                    shape = RoundedCornerShape(animatedCorners),
                    modifier = Modifier
                        .size(height = 56.dp, width = animatedWidth),
                    onClick = {
                        if(!showNavigation){
                            showNavigation = !showNavigation
                        }
                    }
                ) {
                    if (showNavigation){
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            for((icon, description) in icons){
                                IconToggleButton(
                                    checked = description == isChecked,
                                    onCheckedChange = {
                                        isChecked = description

                                        /* TODO: Navigation */
                                    }
                                ) {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = description
                                    )
                                }
                            }
                        }
                    }
                    else{
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Navigate"
                        )
                    }
                }
            }
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = showNavigation,
                enter = scaleIn(),
                exit = scaleOut()
            ) {
                FloatingActionButton(
                    onClick = { showNavigation = !showNavigation },
                    shape = CircleShape
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close menu"
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ){ paddingValues ->
        paddingValues
    }
}

@Preview
@Composable
fun PreviewFloatingBubbleNavigationButton(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        FloatingBubbleNavigationButton()
    }
}