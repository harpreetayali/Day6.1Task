package com.harpreetayali.day61task.Models

data class UsersListModel(
    val ad: Ad,
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)