package com.bxlform.jsonapi_ex.api.models

data class Comment (

    val postId : Int = 0,
    val id : Int = 0,
    val name : String = "",
    val email : String = "",
    val commentText : String = "",

    )