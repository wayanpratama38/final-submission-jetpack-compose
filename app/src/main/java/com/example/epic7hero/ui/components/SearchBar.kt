package com.example.epic7hero.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.epic7hero.R
import com.example.epic7hero.ui.theme.Epic7HeroTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query : String,
    onQueryChange : (newQuery : String) -> Unit,
    modifier : Modifier = Modifier
){
    androidx.compose.material3.SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = {},
        active = false,
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.inversePrimary,
            dividerColor = MaterialTheme.colorScheme.surface,
            inputFieldColors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                cursorColor = MaterialTheme.colorScheme.surface,
            )
        ),
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search_icon),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        },
        placeholder = {
            Text(stringResource(R.string.search_bar_placeholder),
                color = MaterialTheme.colorScheme.onPrimary)
        },
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .shadow(56.dp)
    ){ }
}

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun SearchBarPreview(){
    Epic7HeroTheme {
        SearchBar(
            query ="Test",
            onQueryChange = {}
        )
    }
}
