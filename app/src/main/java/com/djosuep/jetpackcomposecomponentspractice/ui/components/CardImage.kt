package com.djosuep.jetpackcomposecomponentspractice.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djosuep.jetpackcomposecomponentspractice.R

@Composable
fun CardImage(){

    var isLiked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        border = null,
        content = {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(bottom = 5.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.img_example),
                contentDescription = "Example image"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 17.dp)
            ){
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "Title",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    text = "Just a description that has an overflow ellipsis enabled just in case",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(
                    onClick = {
                        isLiked = !isLiked
                    }
                ) {
                    if(isLiked){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_favorite),
                            contentDescription = "Favorite"
                        )
                    }
                    else{
                        Icon(
                            painter = painterResource(id = R.drawable.ic_favorite_border),
                            contentDescription = "Favorite"
                        )
                    }
                }

                IconButton(
                    onClick = {
                        /*TODO*/
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Download,
                        contentDescription = "Favorite"
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewCardImage(){
    MaterialTheme{
        Box(modifier = Modifier
            .padding(15.dp)
        ){
            CardImage()
        }
    }
}