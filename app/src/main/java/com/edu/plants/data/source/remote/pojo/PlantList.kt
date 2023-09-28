package com.edu.plants.data.source.remote.pojo

data class PlantList(
	val perPage: Int? = null,
	val total: Int? = null,
	val data: List<PlantItem?>? = null,
	val lastPage: Int? = null,
	val from: Int? = null,
	val to: Int? = null,
	val currentPage: Int? = null
)

data class PlantItem(
	val question: String? = null,
	val answer: String? = null,
	val defaultImage: DefaultImage? = null,
	val id: Int? = null,
	val tags: List<String?>? = null
)

data class DefaultImage(
	val license: Int? = null,
	val regularUrl: String? = null,
	val licenseName: String? = null,
	val originalUrl: String? = null,
	val mediumUrl: String? = null,
	val licenseUrl: String? = null
)
