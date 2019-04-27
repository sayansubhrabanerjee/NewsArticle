package sayan.banerjee.newsarticle.article.view

import android.os.Bundle
import sayan.banerjee.newsarticle.R

class ArticleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
    }

    fun setActionBarTitle(title: String) {
        supportActionBar!!.title = title
    }

    override fun initOnlineFlow() {
        initArticleSuccessFragment()
    }

    override fun initOfflineFlow() {
        initArticleErrorFragment()
    }



    private fun initArticleErrorFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.layout_container,
                ArticleErrorFragment()
            )
            .commit()
    }

    private fun initArticleSuccessFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.layout_container,
                ArticleSuccessFragment()
            )
            .commit()
    }

}
