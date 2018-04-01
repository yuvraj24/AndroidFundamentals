package com.arch.components.architecture.repository

import com.arch.components.api.NetworkService
import com.arch.components.ui.activity.AppController
import com.arch.components.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by Yuvraj on 27/03/18.
 */
open class BaseRepository {

    @Inject
    private var service: NetworkService? = null

    protected fun getNetworkService(): NetworkService {
        if (service == null) {
            DaggerDependancyInjection.builder()
                    .networkServiceComponent(AppController.getComponent())
                    .build()
                    .inject(this)
        }
        return service!!
    }
}