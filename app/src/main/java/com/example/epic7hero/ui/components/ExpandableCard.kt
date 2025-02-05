package com.example.epic7hero.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.epic7hero.R
import com.example.epic7hero.ui.theme.Epic7HeroTheme

@Composable
fun ExpandableCard(
    title : String,
    content : @Composable () -> Unit,
) {
    var expandableState by remember { mutableStateOf(false) }
    val rotateDegree by animateFloatAsState(
        targetValue = if(expandableState) 180f else 0f
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .testTag("expandableCard"),
        shape = RoundedCornerShape(5.dp),
        onClick = {
            expandableState = !expandableState
        }
    ) {
        Column (
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary)
                .padding(12.dp)
                .fillMaxWidth()

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = title ,
                    modifier = Modifier
                        .weight(6f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                IconButton(
                    modifier = Modifier
                        .alpha(0.5F)
                        .weight(1f)
                        .rotate(rotateDegree),
                    onClick = {
                        expandableState = !expandableState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = stringResource(R.string.drop_down_icon),
                        tint = MaterialTheme.colorScheme.onSecondary

                    )
                }
            }
            if(expandableState){
                content()
            }
        }
    }
}


@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun ExpandableCardPreview(){
    Epic7HeroTheme {
        ExpandableCard(title = "test", content = {})
    }
}