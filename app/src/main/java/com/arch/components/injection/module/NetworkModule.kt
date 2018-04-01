package com.arch.components.injection.module

import com.arch.components.api.NetworkService
import com.arch.components.architecture.repository.BaseRepository
import com.arch.components.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Yuvraj.
 */
@Module(includes = arrayOf(AppModule::class))
class NetworkModule {

    private val retrofitConnection: Retrofit
        @Provides
        @Singleton
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS).addInterceptor(logging)
                    .build()


            return Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

    val repository: BaseRepository
        @Provides
        @Singleton
        get() = BaseRepository()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService {
        val retrofit = retrofitConnection
        return retrofit.create(NetworkService::class.java)
    }

    //    @Provides
    //    @Singleton
    //    public PreferenceUtils providePreference(@Named("context") Context context) {
    //        return new PreferenceUtils(context);
    //    }
}
