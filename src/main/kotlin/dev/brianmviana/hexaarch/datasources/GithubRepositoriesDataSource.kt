package dev.brianmviana.hexaarch.datasources

import dev.brianmviana.hexaarch.datasources.services.GithubRepositoriesClient
import dev.brianmviana.hexaarch.datasources.services.data.response.GithubReporitoryResponse
import dev.brianmviana.hexaarch.datasources.services.converter.convertToModel
import dev.brianmviana.hexaarch.entities.GitRepo
import dev.brianmviana.hexaarch.exceptions.InternalServerErrorException
import dev.brianmviana.hexaarch.exceptions.NotFoundException
import dev.brianmviana.hexaarch.repositories.GitRepoRepository
import feign.FeignException
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.http.HttpStatus.NOT_FOUND

@Component
@Primary
class GithubRepositoriesDataSource(
    val githubRepositoriesClient: GithubRepositoriesClient
): GitRepoRepository {

    override fun getGitRepoListByOwner(username: String): MutableList<GitRepo> {
        var repos = mutableListOf<GithubReporitoryResponse>()
        try {
            repos = this.githubRepositoriesClient.getGitReposByOwner(username)
        } catch (e: FeignException) {
            e.printStackTrace()
            if (NOT_FOUND.value() == e.status()) {
                throw NotFoundException("The owner could not be found.")
            }
            throw InternalServerErrorException()
        }
        var repoList = mutableListOf<GitRepo>()
        repos.forEach {
            repoList.add(it.convertToModel())
        }
        return repoList
    }

}
