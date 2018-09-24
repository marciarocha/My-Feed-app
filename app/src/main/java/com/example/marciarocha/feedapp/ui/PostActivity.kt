package com.example.marciarocha.feedapp.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.marciarocha.feedapp.BaseActivity
import com.example.marciarocha.feedapp.R
import com.example.marciarocha.feedapp.databinding.ActivityMainBinding
import com.example.marciarocha.feedapp.model.Post

class PostActivity : BaseActivity<PostPresenter>(),PostView{

    private lateinit var binding: ActivityMainBinding

    private val postAdapter = PostAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.adapter = postAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        presenter.onViewCreated()
    }

    override fun instantiatePresenter(): PostPresenter {
        return PostPresenter(this)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun updatePosts(posts: List<Post>) {
        postAdapter.updatePosts(posts)
    }

}
