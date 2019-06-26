package com.example.blog.model

import javax.persistence.*

@Entity @Table(name = "user")
data class User(
		var username: String,
		@Id @GeneratedValue var userid: Long? = null)

data class Greeting(val id: Long, val content: String)