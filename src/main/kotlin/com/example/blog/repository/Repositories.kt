package com.example.blog.repository

import com.example.blog.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface UserRepository : JpaRepository<User, Long> {

	fun findByUsername(username: String): List<User>


	@Query("from User u where u.username=:username")
	fun findUser(@Param("username") username: String): User


}

