package com.example.epic7hero.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        placeholder = {
            Text("Search Bar")
        },
        shape = MaterialTheme.shapes.large,
        modifier = modifier.padding(16.dp).fillMaxWidth()
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
