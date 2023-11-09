package com.droidcon.sduicompsemvvm.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

@Composable
fun NewsCard(data: NewsCardModel) {

    Card(
        modifier = Modifier
            .background(color = Color.White, RoundedCornerShape(8.dp))
            .shadow(8.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            AsyncImage(
                model = data.thumbnail,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                 contentDescription = ""
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                text = data.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp),
                text = data.shortDesc,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp)
                    .align(Alignment.End),
                text = data.date,
                fontSize = TextUnit(10f, TextUnitType.Sp)
            )
        }
    }
}

@Preview
@Composable
private fun Display() {
    val newsCard = NewsCardModel(
        id = "eewew",
        type = ComponentType.NewsCard,
        title = "This is test tile",
        shortDesc = "This is test short description",
        thumbnail = "http://sfasdfadfda",
        date = "30-10-2023 9:00 PM"
    )
    NewsCard(data = newsCard)
}