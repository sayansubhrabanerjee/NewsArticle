package sayan.banerjee.newsarticle.article.model.repository


class NewsFeedRepository : BaseRepository() {

    fun getFeeds() = getNewsFeed()

}