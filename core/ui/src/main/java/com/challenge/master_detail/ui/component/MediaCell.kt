import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.challenge.master_detail.ui.R
import com.challenge.master_detail.ui.component.CardSurface
import com.challenge.master_detail.ui.theme.MasterDetailTheme
import java.time.LocalDateTime


@Composable
fun MediaCell(title: String, date: LocalDateTime?, modifier: Modifier = Modifier,
              onClick: () -> Unit = {},
              onDelete: () -> Unit = {}) {
    CardSurface(modifier = modifier) {
        SwipeBox(
            onDelete = onDelete,
        ) {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_list_horizontal))
                    .clickable { onClick() }
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                )
                Text(
                    text = date?.toString() ?: "",
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MediaCellPreview(){
    MasterDetailTheme{
        MediaCell(title = "Title", date = LocalDateTime.now())
    }
}
