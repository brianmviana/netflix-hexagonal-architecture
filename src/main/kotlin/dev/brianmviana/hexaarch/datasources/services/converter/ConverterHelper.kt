package dev.brianmviana.hexaarch.datasources.services.converter

import dev.brianmviana.hexaarch.datasources.services.data.response.GithubReporitoryResponse
import dev.brianmviana.hexaarch.entities.GitRepo

fun GithubReporitoryResponse.convertToModel() = GitRepo(
    name = this.name,
    fullName = this.fullName,
    description = this.description?.takeIf { it.isNotEmpty() }
)