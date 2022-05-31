package dev.brianmviana.hexaarch.datasources.services.data.response.github

data class GithubPermissionsResponse(
    val pull: Boolean? = false,
    val admin: Boolean? = false,
    val push: Boolean? = false
)
