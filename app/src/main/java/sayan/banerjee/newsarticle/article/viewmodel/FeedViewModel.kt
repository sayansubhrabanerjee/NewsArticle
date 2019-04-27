package sayan.banerjee.newsarticle.article.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import sayan.banerjee.newsarticle.article.model.NewsFeedResponse
import sayan.banerjee.newsarticle.article.model.repository.NewsFeedRepository

class FeedViewModel : ViewModel() {
    private var mNewsFeedRepo: NewsFeedRepository = NewsFeedRepository()
    private var mCompositeDisposable: CompositeDisposable? = CompositeDisposable()
    private val mNewsFeedMutableRepo = MutableLiveData<NewsFeedResponse>()

    fun getNewsFeedLiveData(): LiveData<NewsFeedResponse> {
        return mNewsFeedMutableRepo
    }

    fun getNewsFeed() {
        mCompositeDisposable?.add(
            mNewsFeedRepo.getFeeds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mNewsFeedMutableRepo.value = it
                }, {
                    Log.i(TAG, "error: ${it.message}")
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.clear()
            mCompositeDisposable = null
        }
    }

    companion object {
        val TAG: String = FeedViewModel::class.java.simpleName
    }

}