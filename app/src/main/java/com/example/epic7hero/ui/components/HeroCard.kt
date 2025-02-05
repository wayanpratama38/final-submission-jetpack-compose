package com.example.epic7hero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.epic7hero.R



@Composable
fun HeroCard(
    id : Long,
    name : String,
    profileImage : String,
    element : String,
    rarity : String,
    classes : String,
    zodiac : String,
    isFavorite : Boolean,
    onFavoriteClick : (id: Long,newState : Boolean) -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(15.dp))
            .wrapContentSize()
            .background(MaterialTheme.colorScheme.primary)
            .testTag("heroCard"),
        contentAlignment = Alignment.CenterStart,

    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            SubcomposeAsyncImage(
                model = profileImage,
                contentDescription = stringResource(R.string.hero_profile_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp)
                    .clip(CircleShape),
                loading = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(64.dp),
                            color = MaterialTheme.colorScheme.onPrimary,
                            trackColor = MaterialTheme.colorScheme.onSurface,
                            strokeWidth = 1.dp,
                        )
                    }

                }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SubcomposeAsyncImage(
                        model = classes,
                        contentDescription = stringResource(R.string.hero_class),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                        loading = {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(64.dp),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    trackColor = MaterialTheme.colorScheme.onSurface,
                                    strokeWidth = 1.dp,
                                )
                            }

                        }
                    )
                    Text(
                        text = name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SubcomposeAsyncImage(
                        model = element,
                        contentDescription = "Hero Element",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp),
                        loading = {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.fillMaxSize(),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    trackColor = MaterialTheme.colorScheme.onSurface,
                                    strokeWidth = 1.dp,
                                )
                            }
                        }
                    )

                    SubcomposeAsyncImage(
                        model = zodiac,
                        contentDescription = "Hero Zodiac",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                        loading = {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.fillMaxSize(),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    trackColor = MaterialTheme.colorScheme.onSurface,
                                    strokeWidth = 1.dp,
                                )
                            }
                        }
                    )
                    SubcomposeAsyncImage(
                        model = rarity,
                        contentDescription = "Hero Rarity",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(width = 91.dp, height = 21.dp),
                        loading = {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(24.dp),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    trackColor = MaterialTheme.colorScheme.onSurface,
                                    strokeWidth = 1.dp,
                                )
                            }
                        }
                    )
                }
            }

            Icon(
                imageVector = if (!isFavorite) Icons.Outlined.FavoriteBorder else Icons.Outlined.Favorite,
                contentDescription = null,
                tint = if(!isFavorite) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .clickable {
                        onFavoriteClick(id, !isFavorite)
                    }
                    .size(32.dp)
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp)
                    .clip(CircleShape)
                    .testTag("favoriteButton")
            )

        }
    }
}



@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun HeroCardPreview(){
    HeroCard(
        id = 1,
        name = "Abigail",
        profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abigail/profile/abigail.png",
        element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/Fire-circle.png",
        rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
        classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/warrior.png",
        zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/aries.png",
        isFavorite = false,
        onFavoriteClick = {_,_->}
    )
}