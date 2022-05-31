package dev.brianmviana.hexaarch.datasources.services.data.response.github

data class GithubOwnerResponse(
    val gistsUrl: String? = "",
    val reposUrl: String? = "",
    val followingUrl: String? = "",
    val starredUrl: String? = "",
    val login: String = "",
    val followersUrl: String? = "",
    val type: String? = "",
    val url: String? = "",
    val subscriptionsUrl: String? = "",
    val receivedEventsUrl: String? = "",
    val avatarUrl: String? = "",
    val eventsUrl: String? = "",
    val htmlUrl: String? = "",
    val siteAdmin: Boolean? = false,
    val id: Int = 0,
    val gravatarId: String? = "",
    val nodeId: String? = "",
    val organizationsUrl: String? = ""
)
