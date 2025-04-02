package com.challenge.master_detail.list.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ListScreen(viewModel: ListViewModel = hiltViewModel()) {
    ListContent(
        viewModel::navigateToDetail,
    )
}

@Composable
fun ListContent(onClick: () -> Unit = {}) {
    Text(text = "List")
    Button(onClick = onClick) {
        Text(text = "Detail")
    }
}

@Preview(showBackground = true)
@Composable
private fun ListScreenPreview() {
    ListScreen()
}
