package sayan.banerjee.newsarticle.article.view

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_article.*
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
        showHideProgress()
    }

    override fun initOfflineFlow() {
        initArticleErrorFragment()
        imageView_loading.visibility = View.GONE
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

    private fun animateProgressImage() {
        val rotateClockWise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise)
        imageView_loading.startAnimation(rotateClockWise)
    }

    private fun clearProgressImageAnimation() {
        imageView_loading.clearAnimation()
    }

    private fun showHideProgress() {
        imageView_loading.visibility = View.VISIBLE
        animateProgressImage()

        val thread = object : Thread() {
            override fun run() {
                try {
                    sleep(LOADING_TIMER)
                } catch (e: InterruptedException) { }
                runOnUiThread {
                    initArticleSuccessFragment()
                    clearProgressImageAnimation()
                    imageView_loading.visibility = View.GONE
                }
            }
        }
        thread.start()
    }

    companion object {
        const val LOADING_TIMER: Long = 1000
    }

}
