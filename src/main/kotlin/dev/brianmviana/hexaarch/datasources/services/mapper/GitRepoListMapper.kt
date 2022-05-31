package dev.brianmviana.hexaarch.datasources.services.mapper

import dev.brianmviana.hexaarch.datasources.services.data.response.GithubRepositoryResponse
import dev.brianmviana.hexaarch.entities.GitRepoList
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface GitRepoListMapper {

    fun map(githubRepositoryResponse: GithubRepositoryResponse): GitRepoList

}