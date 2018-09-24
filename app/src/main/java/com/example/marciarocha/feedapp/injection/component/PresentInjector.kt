package com.example.marciarocha.feedapp.injection.component

import com.example.marciarocha.feedapp.BaseView
import com.example.marciarocha.feedapp.injection.ContextModule
import com.example.marciarocha.feedapp.injection.NetworkModule
import com.example.marciarocha.feedapp.ui.PostPresenter
import dagger.BindsInstance
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresentInjector {

    fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresentInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView):Builder
    }
}