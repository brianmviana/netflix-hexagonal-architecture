package dev.brianmviana.hexaarch.datasources.services.data.response.gitlab

import com.fasterxml.jackson.annotation.JsonProperty

data class GitlabNamespace(
    @JsonProperty("id") val id: Int? = 0,
    @JsonProperty("name") val name: String? = "",
    @JsonProperty("path") val path: String? = "",
    @JsonProperty("kind") val kind: String? = "",
    @JsonProperty("full_path") val fullPath: String? = "",
    @JsonProperty("parent_id") val parentId: String? = null,
    @JsonProperty("avatar_url") val avatarUrl: String? = "",
    @JsonProperty("web_url") val webUrl: String? = ""
)