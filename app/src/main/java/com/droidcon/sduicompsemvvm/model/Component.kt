package com.droidcon.sduicompsemvvm.model

sealed class ComponentType {
    object NewsCard: ComponentType()
    object PodcastCard: ComponentType()
    object Invalid: ComponentType()
}

open class Component(open val id: String, open val type: ComponentType)

data class NewsCardModel(
    override val id: String,
    override val type: ComponentType,
    val title: String,
    val shortDesc: String,
    val thumbnail: String,
    val date: String,
): Component(id, type)

data class PodcastCardModel(
    override val id: String,
    override val type: ComponentType,
    val title: String,
    val shortDesc: String,
    val thumbnail: String,
    val date: String,
    val duration: String,
): Component(id, type)

data class InvalidModel(override val id: String = "", override val type: ComponentType = ComponentType.Invalid): Component(id,type)