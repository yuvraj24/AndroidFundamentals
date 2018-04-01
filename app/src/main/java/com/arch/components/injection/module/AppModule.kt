package com.arch.components.injection.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppModule(private var mApplication: Application) {

    @Provides
    @Named("context")
    internal fun providesApplication(): Context {
        return mApplication
    }


    @Provides
    @Named(RESOURCES)
    internal fun providesResources(): Resources {
        return mApplication.resources
    }

    companion object {
        const val RESOURCES = "resources"
    }
}
