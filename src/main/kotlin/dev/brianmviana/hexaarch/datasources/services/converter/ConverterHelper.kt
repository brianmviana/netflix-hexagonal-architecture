package dev.brianmviana.hexaarch.datasources.services.converter

import dev.brianmviana.hexaarch.datasources.services.data.response.github.GithubReporitoryResponse
import dev.brianmviana.hexaarch.datasources.services.data.response.gitlab.GitlabProjectResponse
import dev.brianmviana.hexaarch.entities.GitRepo

fun GithubReporitoryResponse.convertToModel() = GitRepo(
    name = this.name,
    fullName = this.fullName,
    description = this.description?.takeIf { it.isNotEmpty() }
)

fun GitlabProjectResponse.convertToModel() = GitRepo(
    name = this.name,
    fullName = this.pathWithNamespace,
    description = this.description?.takeIf { it.isNotEmpty() }
)
