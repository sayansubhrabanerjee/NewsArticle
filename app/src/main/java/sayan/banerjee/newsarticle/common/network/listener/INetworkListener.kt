package sayan.banerjee.newsarticle.common.network.listener

interface INetworkListener {
    fun onConnectivityChange(connectionStatus: String)
}