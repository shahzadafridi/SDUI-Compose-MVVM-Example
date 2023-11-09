package com.droidcon.sduicompsemvvm.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.droidcon.sduicompsemvvm.R
import com.droidcon.sduicompsemvvm.model.ComponentType
import com.droidcon.sduicompsemvvm.model.NewsCardModel
import com.droidcon.sduicompsemvvm.model.PodcastCardModel

@Composable
fun PodcastCard(data: PodcastCardModel) {

    Card(
        modifier = Modifier
            .background(color = Color.White, RoundedCornerShape(8.dp))
            .shadow(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Row {
                AsyncImage(
                    model = data.thumbnail,
                    modifier = Modifier
                        .size(90.dp),
                    contentDescription = ""
                )
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = data.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = data.shortDesc,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = data.duration,
                    fontSize = TextUnit(10f, TextUnitType.Sp)
                )
                Text(
                    text = data.date,
                    fontSize = TextUnit(10f, TextUnitType.Sp)
                )
            }
        }
    }

}

@Preview
@Composable
private fun Display() {
    val podcastCardModel = PodcastCardModel(
        id = "eewew",
        type = ComponentType.NewsCard,
        title = "This is test tile",
        shortDesc = "This is test short description",
        thumbnail = "http://sfasdfadfda",
        date = "30-10-2023 9:00 PM",
        duration = "4:00 mins"
    )
    PodcastCard(data = podcastCardModel)
}