package com.example.marciarocha.feedapp.ui

import android.support.annotation.StringRes
import com.example.marciarocha.feedapp.BaseView
import com.example.marciarocha.feedapp.model.Post

interface PostView: BaseView {

    fun updatePosts(posts: List<Post>)

    fun showError(error: String)
    fun showError(@StringRes errorResId: Int){
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}