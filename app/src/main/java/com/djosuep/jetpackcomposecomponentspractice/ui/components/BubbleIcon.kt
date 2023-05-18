package com.djosuep.jetpackcomposecomponentspractice.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.djosuep.jetpackcomposecomponentspractice.R

@Composable
fun BubbleIcon(icon: Int, description: Int){
    Surface(
        shape = CircleShape,
        color = Color.White,
        modifier = Modifier
            .size(53.dp, 53.dp)
            .padding(start = 5.dp, top = 1.dp, bottom = 1.dp)
            .shadow(elevation = 5.dp, shape = CircleShape)
    ) {
        IconButton(
            onClick = { /*TODO*/ }
        ) {
                painter = painterResource(id = icon),
                contentDescription = stringResource(id = description),
                modifier = Modifier.fillMaxSize(0.8f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    BubbleIcon(
        R.drawable.ic_notes,
        R.string.Notes
    )
}