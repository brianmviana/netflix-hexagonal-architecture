package dev.brianmviana.hexaarch.datasources.services.data.response

data class PermissionsResponse(
    val pull: Boolean? = false,
    val admin: Boolean? = false,
    val push: Boolean? = false
)
