package sayan.banerjee.newsarticle.article.model.service

import io.reactivex.Flowable
import retrofit2.http.GET
import sayan.banerjee.newsarticle.article.model.NewsFeedResponse
import sayan.banerjee.newsarticle.common.APIConstants.Companion.FEED_ID
import sayan.banerjee.newsarticle.common.APIConstants.Companion.FEED_NAME
import sayan.banerjee.newsarticle.common.APIConstants.Companion.FEED_TYPE
import sayan.banerjee.newsarticle.common.APIConstants.Companion.SEPERATOR

interface IFeedService {
    @GET(FEED_NAME.plus(SEPERATOR).plus(FEED_ID).plus(SEPERATOR).plus(FEED_TYPE))
    fun getFeeds(): Flowable<NewsFeedResponse>
}