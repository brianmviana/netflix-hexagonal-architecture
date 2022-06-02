package dev.brianmviana.hexaarch.transportlayers.converter
import dev.brianmviana.hexaarch.entities.GitRepo
import dev.brianmviana.hexaarch.transportlayers.data.response.Repository

fun GitRepo.convertToDTO() = Repository(
    name = this.name,
    fullName = this.fullName,
    description = this.description?.takeIf { it.isNotEmpty() }
)