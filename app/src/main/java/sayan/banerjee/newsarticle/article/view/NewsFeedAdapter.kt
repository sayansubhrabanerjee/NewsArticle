package sayan.banerjee.newsarticle.article.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_feed.view.*
import sayan.banerjee.newsarticle.R
import sayan.banerjee.newsarticle.article.model.NewsFeed
import sayan.banerjee.newsarticle.common.CommonUtils


open class NewsFeedAdapter(private val context: Context, private val newsFeeds: MutableList<NewsFeed>) :
    RecyclerView.Adapter<NewsFeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FeedViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_feed, parent, false)
        return FeedViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsFeeds.size
    }

    override fun onBindViewHolder(feedViewHolder: FeedViewHolder, position: Int) {
        val newsFeed = newsFeeds[position]
        feedViewHolder.bindData(newsFeed)
    }

    fun setData(newsFeedsList: List<NewsFeed>) {
        for (i in 0..newsFeedsList.size) {
            newsFeeds.add(i, newsFeedsList[i])
            //newsFeeds.addAll(newsFeedsList)
            notifyDataSetChanged()
        }
    }

    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(newsFeeds: NewsFeed?) {
            newsFeeds?.let {
                if (it.title.isNullOrEmpty()) {
                    itemView.textView_item_title.text = context.resources.getString(R.string.title_not_available)
                } else {
                    itemView.textView_item_title.text = it.title
                }
                if (it.description.isNullOrEmpty()) {
                    itemView.textView_item_desc.text = context.resources.getString(R.string.description_not_available)
                } else {
                    itemView.textView_item_desc.text = it.description
                }
                it.imageHref?.let { it1 ->
                    CommonUtils.configureGlideForFeed(
                        itemView.imageView_item_image_href,
                        it1, context
                    )
                }
            }
        }
    }
}