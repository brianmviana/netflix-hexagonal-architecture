package dev.brianmviana.hexaarch.datasources

import dev.brianmviana.hexaarch.datasources.services.GithubRepositoriesClient
import dev.brianmviana.hexaarch.datasources.services.data.response.GithubRepositoryResponse
import dev.brianmviana.hexaarch.datasources.services.mapper.GitRepoListMapper
import dev.brianmviana.hexaarch.entities.GitRepoList
import dev.brianmviana.hexaarch.exceptions.InternalServerErrorException
import dev.brianmviana.hexaarch.exceptions.NotFoundException
import dev.brianmviana.hexaarch.repositories.GitRepoRepository
import feign.FeignException
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.http.HttpStatus.NOT_FOUND

@Component
@Primary
class GithubRepositoriesDataSource(
    val githubRepositoriesClient: GithubRepositoriesClient
): GitRepoRepository {

    override fun getGitRepoListByOwner(username: String): GitRepoList {
        var repos = GithubRepositoryResponse()
        try {
            repos = this.githubRepositoriesClient.getGitReposByOwner(username)
            println("repositories: " + repos)
        } catch (e: FeignException) {
            e.printStackTrace()
            if (NOT_FOUND.value() == e.status()) {
                throw NotFoundException("The owner could not be found.")
            }
            throw InternalServerErrorException()
        }

        val converter = Mappers.getMapper(GitRepoListMapper::class.java)
        return converter.map(repos)
    }

}
