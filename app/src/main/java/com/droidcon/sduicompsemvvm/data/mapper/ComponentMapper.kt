package com.droidcon.sduicompsemvvm.data.mapper

import com.droidcon.sduicompsemvvm.data.model.ComponentDTOItem
import com.droidcon.sduicompsemvvm.model.Component
import com.droidcon.sduicompsemvvm.model.ComponentType
import com.droidcon.sduicompsemvvm.model.InvalidModel
import com.droidcon.sduicompsemvvm.model.NewsCardModel
import com.droidcon.sduicompsemvvm.model.PodcastCardModel


class ComponentMapper {

    fun toComponent(item: ComponentDTOItem): Component {
        return when(item.type) {
            "news-card" -> NewsCardModel(
                id = item.id,
                title = item.title,
                shortDesc = item.shortDesc,
                thumbnail = item.thumbnail,
                date = item.date,
                type = item.type.toComponentType()
            )
            "podcast-card" -> PodcastCardModel(
                id = item.id,
                title = item.title,
                shortDesc = item.shortDesc,
                thumbnail = item.thumbnail,
                date = item.date,
                duration = item.duration,
                type = item.type.toComponentType()
            )
            else -> InvalidModel()
        }
    }

    private fun String.toComponentType(): ComponentType {
        return when(this) {
            "news-card" -> ComponentType.NewsCard
            "podcast-card" -> ComponentType.PodcastCard
            else -> ComponentType.Invalid
        }
    }

}