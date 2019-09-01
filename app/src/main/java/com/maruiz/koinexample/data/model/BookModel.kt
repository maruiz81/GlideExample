package com.maruiz.koinexample.data.model

import com.google.gson.annotations.SerializedName

data class BookModel(val bookId: Int = 0, val title: String = "", val author: String = "",
                     @SerializedName("short_synopsis") val shortSynopsis: String, val synopsis: String = "",
                     val image: String = "")