package com.djosuep.jetpackcomposecomponentspractice.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.djosuep.jetpackcomposecomponentspractice.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

//Needs Internet connection and Coil implementation
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SlidingImageCard(){

    val imageList = listOf(
        "https://cdn.discordapp.com/attachments/1109581677199634522/1109581830883127406/576294.png",
        "https://cdn.discordapp.com/attachments/1109581677199634522/1109581862520766484/576296.png",
        "https://cdn.discordapp.com/attachments/1109581677199634522/1109581879872585859/576295.png"
    )

    val pagerState = rememberPagerState(initialPage = 0)

    var isLiked by remember { mutableStateOf(false) }
    var isBookmarked by remember { mutableStateOf(false) }
    var likesCount by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            /*.clickable {
                Clickable for navegation or something
            }*/,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        border = null,
        content = {

            HorizontalPager(
                count = imageList.size,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically
            ) { page ->

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageList[page])
                        .crossfade(true)
                        .scale(Scale.FILL)
                        .build(),
                    contentDescription = "Carousel image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            //Current image
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(imageList.size){
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(shape = CircleShape)
                            .size(5.dp)
                            .background(if (pagerState.currentPage == it) Color.DarkGray else Color.LightGray)
                    )
                }
            }
            
            //User
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                //Clickable segment in the row
                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .width(IntrinsicSize.Min)
                        .clickable {
                            /* TODO */
                        },
                    verticalAlignment = Alignment.CenterVertically
                ){
                    AsyncImage(
                        model = "https://cdn.discordapp.com/attachments/1029844385237569616/1116569644745097320/393368.png",
                        contentDescription = "User avatar",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(shape = CircleShape)
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    Text(
                        text = "Username"
                    )
                }
            }

            //Card information
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp)
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

            //Icon buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp, bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(
                    onClick = {

                        if (isLiked)
                            likesCount--
                        else
                            likesCount++

                        isLiked = !isLiked
                    }
                ) {
                    Row {
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

                        Spacer(modifier = Modifier.size(5.dp))
                        
                        Text(text = likesCount.toString())
                    }
                }

                IconButton(
                    onClick = {
                        isBookmarked = !isBookmarked
                    }
                ) {
                    if(isBookmarked){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_bookmark),
                            contentDescription = "Favorite"
                        )
                    }
                    else{
                        Icon(
                            painter = painterResource(id = R.drawable.ic_bookmark_border),
                            contentDescription = "Favorite"
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewSlidingImageCard(){
    MaterialTheme {
        Box(modifier = Modifier.padding(all = 12.dp)){
            SlidingImageCard()
        }
    }
}