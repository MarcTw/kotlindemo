package com.example.blog.controller

import com.example.blog.commons.findLastNo
import com.example.blog.model.User
import com.example.blog.repository.UserRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.bind.annotation.*
import java.util.regex.Pattern


@RestController
@RequestMapping("/api/user")
class UserApi(private val repository: UserRepository) {

	@GetMapping("/all")
	fun findAll() = repository.findAll()

	@PostMapping("/")
	fun createUser(@RequestBody user: User): User {
		autoCreateAcoount(user)
		return user

}


	fun autoCreateAcoount(user: User): User {
		var username = user.username
		val list = repository.findByUsername(username)
		var pattern = Pattern.compile("(.*?)(\\d+?)$")

		if (list.isNotEmpty()) {
			var number = 1

			if (pattern.matcher(username).matches()){
				//如果尾數為數字 => 數字+1
				number = findLastNo(username)
				username = username.substring(0,username.length-number.toString().length)
				number++
			}
			username = username + number.toString()
		}
		try {
			user.username = username
			repository.save(user)
		}catch (e : DataIntegrityViolationException){
			autoCreateAcoount(user)
		}

		return user
	}
}