package com.arch.components.architecture.viewmodels

import android.arch.lifecycle.ViewModel
import com.arch.components.api.NetworkService
import com.arch.components.architecture.repository.MainBaseRepository
import com.arch.components.ui.activity.AppController
import javax.inject.Inject


/**
 * Created by Yuvraj on 27/03/18.
 */
public open class BaseViewModel : ViewModel() {

    @Inject
    private var repository : MainBaseRepository? = null;

    public fun getRepository(): MainBaseRepository {
        if (repository == null) {
            DaggerDependancyInjection.builder()
                    .networkServiceComponent(AppController.getComponent())
                    .build()
                    .inject(this)
        }
        return repository!!
    }
}
