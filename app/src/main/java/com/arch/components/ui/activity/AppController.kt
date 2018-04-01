package com.arch.components.ui.activity

import android.app.Application
import com.arch.components.injection.component.NetworkServiceComponent
import com.arch.components.injection.module.AppModule
import com.arch.components.injection.module.NetworkModule

import com.zplesac.connectionbuddy.ConnectionBuddy
import com.zplesac.connectionbuddy.ConnectionBuddyConfiguration

/**
 * Created by Yuvraj.
 */

open class AppController : Application() {

    override fun onCreate() {
        super.onCreate()
        val networkInspectorConfiguration = ConnectionBuddyConfiguration.Builder(this).build()
        ConnectionBuddy.getInstance().init(networkInspectorConfiguration)

        networkServiceComponent = DaggerNetworkServiceComponent.builder()
                .networkModule(NetworkModule())
                .appModule(AppModule(this))
                .build();
    }

    companion object {
        var networkServiceComponent: NetworkServiceComponent? = null

        fun getComponent(): NetworkServiceComponent? {
            return networkServiceComponent
        }
    }
}
