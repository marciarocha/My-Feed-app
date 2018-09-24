package com.example.marciarocha.feedapp

import com.example.marciarocha.feedapp.injection.ContextModule
import com.example.marciarocha.feedapp.injection.NetworkModule
import com.example.marciarocha.feedapp.injection.component.DaggerPresentInjector
import com.example.marciarocha.feedapp.injection.component.PresentInjector
import com.example.marciarocha.feedapp.ui.PostPresenter

abstract class BasePresenter<out V:BaseView>(protected val view: V) {

    private val injector: PresentInjector = DaggerPresentInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated(){
    }

    open fun onViewDestroyed(){}

    private fun inject(){
        when(this){
            is PostPresenter -> injector.inject(this)
        }
    }
}