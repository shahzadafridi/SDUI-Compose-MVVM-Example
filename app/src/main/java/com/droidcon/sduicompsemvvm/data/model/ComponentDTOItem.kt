package com.droidcon.sduicompsemvvm.data.model


import com.google.gson.annotations.SerializedName

data class ComponentDTOItem(
    @SerializedName("date")
    val date: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("short_desc")
    val shortDesc: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)