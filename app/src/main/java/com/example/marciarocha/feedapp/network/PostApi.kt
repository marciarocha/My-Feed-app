package com.example.marciarocha.feedapp.network


import com.example.marciarocha.feedapp.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPost(): Observable<List<Post>>
}