package com.example.marciarocha.feedapp.ui

import com.example.marciarocha.feedapp.BasePresenter
import com.example.marciarocha.feedapp.R
import com.example.marciarocha.feedapp.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostPresenter(postView: PostView): BasePresenter<PostView>(postView) {

    @Inject
    lateinit var postApi: PostApi
    private var subscription: Disposable? = null


    override fun onViewCreated() {
        loadPosts()
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun loadPosts() {
        view.showLoading()
        subscription = postApi.getPost().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).doOnTerminate { view.hideLoading() }
                .subscribe ({ postList -> view.updatePosts(postList) }, {view.showError(R.string.error)})
    }

}