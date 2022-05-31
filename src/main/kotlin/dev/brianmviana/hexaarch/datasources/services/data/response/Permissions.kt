package dev.brianmviana.hexaarch.datasources.services.data.response

data class Permissions(val pull: Boolean? = false,
                       val admin: Boolean? = false,
                       val push: Boolean? = false)