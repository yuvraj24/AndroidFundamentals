package com.arch.components.injection

import com.arch.components.architecture.repository.BaseRepository
import com.arch.components.architecture.viewmodels.BaseViewModel
import com.arch.components.injection.component.NetworkServiceComponent
import com.arch.components.injection.scopes.ActivityScope
import com.arch.components.ui.activity.BaseActivity
import dagger.Component

/**
 * Created by Yuvraj on 26/03/18.
 */
@ActivityScope
@Component(dependencies = [(NetworkServiceComponent::class)])
interface DependencyInjection {
    fun inject(baseActivity: BaseActivity)
    fun inject(baseRepository: BaseRepository)
    fun inject(baseViewModel: BaseViewModel)
}
