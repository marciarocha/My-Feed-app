package com.example.marciarocha.feedapp.injection

import android.app.Application
import android.content.Context
import com.example.marciarocha.feedapp.BaseView
import dagger.Module
import dagger.Provides


@Module
object ContextModule {

    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }

    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}