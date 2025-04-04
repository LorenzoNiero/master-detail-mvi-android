package com.challenge.master_detail.list.presentation


import MediaCell
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.challenge.master_detail.common.model.MediaModel
import com.challenge.master_detail.common.model.MediaModelType
import com.challenge.master_detail.list.R
import kotlinx.coroutines.delay
import com.challenge.master_detail.ui.R as R_UI

@Composable
fun ListScreen(viewModel: ListViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState()
    val uiLoadingState = viewModel.loadingUiState.collectAsState()

    ListContent(
        uiState = uiState.value,
        isLoading = uiLoadingState.value,
        onIntent = { intent -> viewModel.handleIntent(intent) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListContent(
    uiState: ListUiState,
    isLoading: Boolean = false,
    onIntent: (ListIntent) -> Unit
) {
    PullToRefreshBox(
        isRefreshing = isLoading,
        onRefresh = { onIntent(ListIntent.Refresh) },
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            when (uiState) {
                ListUiState.Empty -> {
                    ContentWithRetryButton(onClick = { onIntent(ListIntent.Refresh) }) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 16.dp),
                            textAlign = TextAlign.Center,
                            text = stringResource(R.string.empty_list_message)
                        )
                    }
                }

                is ListUiState.Error -> {
                    ContentWithRetryButton(onClick = { onIntent(ListIntent.Refresh) }) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = dimensionResource(R_UI.dimen.padding_list_vertical)),
                            textAlign = TextAlign.Center,
                            text = stringResource(R_UI.string.error_label, uiState.message ?: "")
                        )
                    }
                }

                is ListUiState.Result -> {

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(
                            vertical = dimensionResource(R_UI.dimen.padding_list_vertical),
                            horizontal = dimensionResource(R_UI.dimen.padding_list_horizontal)
                        ),
                        verticalArrangement = Arrangement.spacedBy(dimensionResource(R_UI.dimen.spacing_between_items))
                    ) {
                        items(items = uiState.list, key = { media -> media.id }) { media ->

                            var visible by remember(media.id) { mutableStateOf(true) }

                            AnimatedVisibility(
                                visible = visible,
                                exit = shrinkVertically(animationSpec = tween(300))
                            ) {
                                MediaCell(
                                    modifier = Modifier.fillMaxWidth(),
                                    title = media.title,
                                    subTitle = media.formatDate(),
                                    onClick = {
                                        onIntent(ListIntent.Click(media))
                                    },
                                    onDelete = {
                                        visible = false
                                        delay(300)
                                        onIntent(ListIntent.Delete(media))
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ContentWithRetryButton(onClick: () -> Unit, content: @Composable ColumnScope.() -> Unit) {
    Column (
        modifier = Modifier
            .padding(dimensionResource(R_UI.dimen.normal))
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R_UI.dimen.spacing_between_items), Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
        Button(onClick = onClick) {
            Text(text = stringResource(R.string.try_again))
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun ListScreenPreview() {
    ListContent(
        ListUiState.Result(
            listOf(
                MediaModel(
                    id = 1,
                    url = "https://.....jpg",
                    urlBig = "https://.....jpg",
                    type = MediaModelType.PDF,
                    date = null,
                    title = "Title",
                ),
                MediaModel(
                    id = 2,
                    url = "https://.....jpg",
                    urlBig = "https://.....jpg",
                    type = MediaModelType.PDF,
                    date = null,
                    title = "Title",
                )
            ),
        ),
        onIntent = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ListScreen_Error_Preview() {
    ListContent(
        ListUiState.Error("Text error"),
        onIntent = {}
    )
}
