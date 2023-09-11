package com.bxlform.jsonapi_ex

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bxlform.jsonapi_ex.api.JsonPlaceHolderAPI
import com.bxlform.jsonapi_ex.api.RetrofitClient
import com.bxlform.jsonapi_ex.api.models.PostItem
import com.bxlform.jsonapi_ex.api.models.Posts
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val client = RetrofitClient.client.create(JsonPlaceHolderAPI::class.java)

    private var _posts : MutableLiveData<List<Posts>> = MutableLiveData(mutableListOf())
    val posts : LiveData<List<Posts>>
        get() = _posts

    private val _post : MutableLiveData<Posts> = MutableLiveData()


    val postOne : LiveData<Posts>
        get() = _post


    fun getPost() {
        viewModelScope.launch {
            _post.value = client.getPost()
        }
    }



    fun getAllPosts() {

        viewModelScope.launch {
            var post = client.getAllPosts()
            _posts.value = post!!.toMutableList()
        }

    }

    fun createPost(){
        viewModelScope.launch {

            var postItem = client.createPost(PostItem("1", 1,"Tilte new post created", 1))

        }
    }

    fun deletePost(){
        viewModelScope.launch{
            client.deletePost(2)
        }
    }



}