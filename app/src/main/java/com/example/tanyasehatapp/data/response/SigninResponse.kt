package com.example.tanyasehatapp.data.response

data class SigninResponse(
	val data: Data? = null,
	val message: String? = null,
	val status: Boolean? = null
)

data class Data(
	val name: String? = null,
	val id: Int? = null,
	val email: String? = null,
	val token: String? = null
)

