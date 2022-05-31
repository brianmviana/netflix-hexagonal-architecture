package dev.brianmviana.hexaarch.datasources.services.data.response.gitlab

import com.fasterxml.jackson.annotation.JsonProperty

data class GitlabProjectResponse(
    @JsonProperty("id") val id: Int? = 0,
    @JsonProperty("description") val description: String? = "",
    @JsonProperty("name") val name: String = "",
    @JsonProperty("name_with_namespace") val nameWithNamespace: String? = "",
    @JsonProperty("path") val path: String = "",
    @JsonProperty("path_with_namespace") val pathWithNamespace: String = "",
    @JsonProperty("created_at") val createdAt: String? = "",
    @JsonProperty("default_branch") val defaultBranch: String? = "",
    @JsonProperty("ssh_url_to_repo") val sshUrlToRepo: String? = "",
    @JsonProperty("http_url_to_repo") val httpUrlToRepo: String? = "",
    @JsonProperty("web_url") val webUrl: String? = "",
    @JsonProperty("readme_url") val readmeUrl: String? = "",
    @JsonProperty("avatar_url") val avatarUrl: String? = null,
    @JsonProperty("forks_count") val forksCount: Int? = 0,
    @JsonProperty("star_count") val starCount: Int? = 0,
    @JsonProperty("last_activity_at") val lastActivityAt: String? = "",
    @JsonProperty("namespace") val namespace: GitlabNamespace?
)
