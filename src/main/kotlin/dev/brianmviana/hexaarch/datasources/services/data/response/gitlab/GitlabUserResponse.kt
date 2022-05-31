package dev.brianmviana.hexaarch.datasources.services.data.response.gitlab

import com.fasterxml.jackson.annotation.JsonProperty

data class GitlabUserResponse(
    @JsonProperty("id") val id: Int = 0,
    @JsonProperty("username") val username: String = "",
    @JsonProperty("name") val name: String = "",
    @JsonProperty("state") val state: String? = "",
    @JsonProperty("avatar_url") val avatarUrl: String? = "",
    @JsonProperty("web_url") val webUrl: String? = ""
)
