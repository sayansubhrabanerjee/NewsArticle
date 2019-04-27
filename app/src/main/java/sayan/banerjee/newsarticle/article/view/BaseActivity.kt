package sayan.banerjee.newsarticle.article.view

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import sayan.banerjee.newsarticle.R
import sayan.banerjee.newsarticle.common.network.listener.INetworkListener
import sayan.banerjee.newsarticle.common.network.receiver.NetworkReceiver
import sayan.banerjee.newsarticle.common.network.util.NetworkConstants
import sayan.banerjee.newsarticle.common.network.util.NetworkUtil
import sayan.banerjee.newsarticle.common.displayToast

open class BaseActivity : AppCompatActivity(), INetworkListener {
    private var mNetworkReceiver: NetworkReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        NetworkUtil.setConnectivityListener(this)
        registerNetworkReceiver()
    }

    private fun registerNetworkReceiver() {
        mNetworkReceiver = NetworkReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        this.registerReceiver(mNetworkReceiver, intentFilter)
    }

    override fun onConnectivityChange(connectionStatus: String) {
        when (connectionStatus) {
            NetworkConstants.OPTIMAL_NETWORK -> {
                mIsNetworkAvailable = true
                mIsConnectivityPoor = false
                this.displayToast(getString(R.string.optimal_network))
            }
            NetworkConstants.POOR_NETWORK -> {
                mIsNetworkAvailable = true
                mIsConnectivityPoor = true
                this.displayToast(getString(R.string.poor_network))
            }
            NetworkConstants.TYPE_WIFI -> {
                mIsNetworkAvailable = true
                mIsConnectivityPoor = false
                this.displayToast(getString(R.string.wifi_network))
            }
            NetworkConstants.TYPE_NOT_CONNECTED -> {
                mIsNetworkAvailable = false
                mIsConnectivityPoor = false
                this.displayToast(getString(R.string.no_network))
            }
        }

        if (mIsNetworkAvailable) initOnlineFlow() else initOfflineFlow()
    }

    open fun initOnlineFlow() {
        //Needs to be implemented in respective activity/fragments
    }

    open fun initOfflineFlow() {
        //Needs to be implemented in respective activity/fragments
    }

    companion object {
        var mIsNetworkAvailable: Boolean = false
        var mIsConnectivityPoor: Boolean = false
    }

}