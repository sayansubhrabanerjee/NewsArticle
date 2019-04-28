package sayan.banerjee.newsarticle.article.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_article_success.view.*
import sayan.banerjee.newsarticle.R
import sayan.banerjee.newsarticle.article.model.NewsFeed
import sayan.banerjee.newsarticle.article.viewmodel.FeedViewModel


class ArticleSuccessFragment : Fragment() {

    private var mContext: Context? = null
    private var mFeedViewModel: FeedViewModel? = null
    private var mNewsFeedAdapter: NewsFeedAdapter? = null
    private var mNewsFeedMutableList: MutableList<NewsFeed> = mutableListOf()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article_success, container, false)
        initViews(view)
        initFeedViewModel()
        setAdapter(view)
        makeRequestForNewsFeedList()
        return view
    }

    private fun initViews(v: View) {
        val linearLayoutManager = LinearLayoutManager(v.context)
        v.recycler_feed.addItemDecoration(
            DividerItemDecoration(
                v.context,
                DividerItemDecoration.VERTICAL
            )
        )
        v.recycler_feed.layoutManager = linearLayoutManager
    }

    private fun initFeedViewModel() {
        mFeedViewModel = ViewModelProviders.of(this@ArticleSuccessFragment).get(FeedViewModel::class.java)
        mFeedViewModel!!.getNewsFeed()
    }

    private fun setAdapter(v: View) {
        mNewsFeedAdapter = NewsFeedAdapter(mContext!!, mNewsFeedMutableList)
        v.recycler_feed.adapter = mNewsFeedAdapter
    }

    private fun makeRequestForNewsFeedList() {
        mFeedViewModel!!.getNewsFeedLiveData().observe(this@ArticleSuccessFragment, Observer {
            (activity as ArticleActivity).setActionBarTitle(it?.title.toString())
            mNewsFeedAdapter?.setData(it?.newsFeeds!!)
        })
    }
}
