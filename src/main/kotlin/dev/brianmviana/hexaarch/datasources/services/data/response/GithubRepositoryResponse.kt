package dev.brianmviana.hexaarch.datasources.services.data.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class GithubRepositoryResponse(val repositories: MutableList<GithubRepository> = mutableListOf()) {}