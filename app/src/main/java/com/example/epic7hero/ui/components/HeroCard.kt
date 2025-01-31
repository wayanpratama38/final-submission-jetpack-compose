package com.example.epic7hero.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.epic7hero.R


@Composable
fun HeroCard(
    name : String,
    profileImage : String,
    element : String,
    rarity : String,
    classes : String,
    zodiac : String,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.CenterStart
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = profileImage,
                placeholder = painterResource(R.drawable.profile_image_placeholder),
                contentDescription = "Hero Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(112.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = classes,
                        placeholder = painterResource(R.drawable.classes_image_placeholder),
                        contentDescription = "Hero Class",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp)
                    )
                    Text(
                        text = name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AsyncImage(
                        model = element,
                        placeholder = painterResource(R.drawable.element_image_placeholder),
                        contentDescription = "Hero Element",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp)
                    )
                    AsyncImage(
                        model = zodiac,
                        placeholder = painterResource(R.drawable.zodiac_image_placeholder),
                        contentDescription = "Hero Zodiac",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp)
                    )
                    AsyncImage(
                        model = rarity,
                        placeholder = painterResource(R.drawable.rarity_image_placeholder),
                        contentDescription = "Hero Rarity",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(width = 91.dp, height = 21.dp)
                    )
                }
            }

            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.CenterVertically)
            )

        }
    }
}



@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun HeroCardPreview(){
    HeroCard(
        name = "Abigail",
        profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abigail/profile/abigail.png",
        element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/Fire-circle.png",
        rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
        classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/warrior.png",
        zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/aries.png",
    )
}