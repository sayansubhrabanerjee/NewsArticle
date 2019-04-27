package sayan.banerjee.newsarticle.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import sayan.banerjee.newsarticle.R

class CommonUtils {

    companion object {

        fun getFeedBaseURL(): String = APIConstants.FEED_BASE_URL

        fun configureGlideForFeed(
            imageView: ImageView
            , iconUrl: String
            , context: Context
        ) {

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.icon_error)

            Glide
                .with(context)
                .applyDefaultRequestOptions(
                    requestOptions
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .load(iconUrl)
                .into(imageView)
        }
    }
}