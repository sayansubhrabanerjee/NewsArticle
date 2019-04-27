package sayan.banerjee.newsarticle.article.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsFeedResponse {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("rows")
    @Expose
    var rows: List<NewsFeed>? = null

}
