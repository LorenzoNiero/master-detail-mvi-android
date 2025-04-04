package com.challenge.master_detail.detail.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.challenge.master_detail.detail.R
import com.challenge.master_detail.ui.R as R_UI
import com.challenge.master_detail.common.model.MediaModel
import com.challenge.master_detail.common.model.MediaModelType
import com.challenge.master_detail.detail.openPdfInExternalApp
import com.challenge.master_detail.ui.theme.MasterDetailTheme
import java.time.LocalDateTime

@Composable
fun DetailScreen(viewModel: DetailViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState()
    DetailContent(
        uiState.value,
        onIntent = viewModel::handleIntent
    )
}

@Composable
fun DetailContent(
    uiState: DetailUiState,
    onIntent: (DetailIntent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(dimensionResource(R_UI.dimen.medium))
            .fillMaxSize()
    ) {
        when (uiState) {
            is DetailUiState.Detail -> {

                val context = LocalContext.current

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R_UI.dimen.spacing_between_items)),
                ){
                    val media = uiState.media
                    Text(media.title,
                        style = MaterialTheme.typography.titleLarge)
                    Text(media.formatDate())
                    Text(media.url)
                    if (media.url.isNotBlank() && media.type == MediaModelType.PDF) {
                        Button(onClick = {
                            onIntent(DetailIntent.ClickAndOpenExternal(media.url, context))
                        }) {
                            Text(stringResource(R.string.open_url_pdf))
                        }
                    }

                    Text(media.urlBig)
                    if (media.urlBig.isNotBlank() && media.type == MediaModelType.PDF) {
                        Button(onClick = {
                            onIntent(DetailIntent.ClickAndOpenExternal(media.urlBig, context))
                        }) {
                            Text(stringResource(R.string.open_url_big))
                        }
                    }
                }
            }
            is DetailUiState.Error -> {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = dimensionResource(R_UI.dimen.padding_list_vertical)),
                    textAlign = TextAlign.Center,
                    text = stringResource(R_UI.string.error_label, uiState.message ?: "")
                )
            }

            DetailUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    MasterDetailTheme {
        DetailContent(
            DetailUiState.Detail(
                media = MediaModel(
                    id = 1,
                    url = "https://.....pdf",
                    urlBig = "https://.....pdf",
                    type = MediaModelType.PDF,
                    date = LocalDateTime.now(),
                    title = "Title example",
                )
            ),
            onIntent = {}
        )
    }
}
