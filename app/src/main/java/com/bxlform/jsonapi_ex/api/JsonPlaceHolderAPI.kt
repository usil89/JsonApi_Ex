package com.bxlform.jsonapi_ex.api

import com.bxlform.jsonapi_ex.api.models.Comment
import com.bxlform.jsonapi_ex.api.models.Post
import com.bxlform.jsonapi_ex.api.models.PostItem
import com.bxlform.jsonapi_ex.api.models.Posts
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface JsonPlaceHolderAPI {

    @GET("posts/1")
    suspend fun getPost(): Posts

    @GET("/posts")
    suspend fun  getAllPosts(): Post

    @POST
    suspend fun createPost(@Body postItem : PostItem) : PostItem

    @PATCH
    suspend fun putPost(@Path("id") id : Int, @Body postItem :PostItem)

    @DELETE("/posts/{id}")
    suspend fun deletePost(@Path("id") id : Int)

    @GET("/posts/{id}")
    suspend fun  getPostById(@Path("id") id : Int) : Posts

    @GET("/posts/{id}/comments")
    suspend fun getCommentsById(@Path("id") id : Int) : Comment

    @GET("/comments")
    suspend fun  getComments() : Comment


}