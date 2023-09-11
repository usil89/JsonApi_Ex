package com.bxlform.jsonapi_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bxlform.jsonapi_ex.adapters.PostAdapter
import com.bxlform.jsonapi_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding

    private lateinit var adapter: PostAdapter

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)

        setRv()

        observeVm()
        //setListeners()

       //setContentView(binding.root)



        //binding = ActivityMainBinding.inflate((layoutInflater))

        viewModel.getAllPosts()
        //viewModel.getPost()


//        binding.btnSubmitMainActivity.setOnClickListener(){
//
//            val idPost = binding.etNameMainActivity.id
//
//
//
//
//        }

        //viewModel.getPost()
        //viewModel.getAllPosts()


//        viewModel.postOne.observe(this) {
//
//            val id1 = "Id1 : ${it.id.toString()}"
//            val title1 = "Title1 : ${it.title}"
//            val body1 = "Body1 : ${it.body}"
//            val userId1 = "Title : ${it.userId.toString()}"
//        }


//        viewModel.posts.observe(this) {
//
//            val id = "Id : ${it.first().id.toString()}"
//            val title = "Title : ${it.first().title}"
//            val body = "Body : ${it.first().body}"
//            val userId = "Title : ${it.first().userId.toString()}"
//
//            /*Glide
//                .with(this)
//                .load(AVATAR_URL)
//                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .skipMemoryCache(true)
//                .into(binding.imageView)*/
//
//            binding.tvPredictionMainActivity.text = id
//            binding.tvIdMainActivity.text = id
//            binding.tvTitleMainActivity.text = title
//            binding.tvBodyMainActivity.text = body
//            binding.tvUserIdMainActivity.text = userId
//
//
//        }

        setContentView(binding.root)
    }

    private fun setRv() {
        binding.rvPostsMainActivity.layoutManager = LinearLayoutManager(this)
        adapter = PostAdapter()

        binding.rvPostsMainActivity.adapter = adapter
    }

    private fun setListeners() {
        TODO("Not yet implemented")
    }

    private fun observeVm() {
        viewModel.posts.observe(this, Observer {
            adapter.updatePosts(it.toMutableList())
            Log.i("MainActivity", "observeVm: Load data : ${it.size}")
            Toast.makeText(this, "observeVm: Load data : ${it.size}", Toast.LENGTH_LONG).show()
        }
    )


    }


}