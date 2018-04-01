package com.arch.components.injection.component

import com.arch.components.api.NetworkService
import com.arch.components.architecture.repository.BaseRepository
import com.arch.components.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class))
interface NetworkServiceComponent {

    val networkService: NetworkService

    val repository: BaseRepository

}
