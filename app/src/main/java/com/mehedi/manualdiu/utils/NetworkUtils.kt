package com.mehedi.manualdiu.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

import com.mehedi.manualdiu.core.DataState
import okhttp3.ResponseBody
import retrofit2.Response

object NetworkUtils {

    /**
     * check if the network response is valid
     * **/
    fun isValidResponse(responseBody: DataState.Success<Response<ResponseBody>?>): Boolean {
        return responseBody.value?.headers()?.get(AppConstants.CONTENT_TYPE_KEY)
            ?.contains(AppConstants.JSON_VALID_KEY, true) ?: false
    }

    /**
     * check if the internet is available
     * **/
    fun isInternetAvailable(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = manager.activeNetwork ?: return false
        val capabilities = manager.getNetworkCapabilities(network) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}