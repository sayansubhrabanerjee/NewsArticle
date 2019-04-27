package sayan.banerjee.newsarticle.article.model.repository

import io.reactivex.Flowable
import sayan.banerjee.newsarticle.article.model.NewsFeedResponse
import sayan.banerjee.newsarticle.article.model.service.IFeedService
import sayan.banerjee.newsarticle.article.model.service.ServiceGenerator

open class BaseRepository {

    companion object {

        fun getNewsFeed(): Flowable<NewsFeedResponse> {
            val feedService = ServiceGenerator.createService(IFeedService::class.java)
            return feedService.getFeeds()
        }
    }
}