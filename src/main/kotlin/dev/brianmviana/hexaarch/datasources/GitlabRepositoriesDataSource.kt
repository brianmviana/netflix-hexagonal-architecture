package dev.brianmviana.hexaarch.datasources

import dev.brianmviana.hexaarch.datasources.services.GitlabProjectsClient
import dev.brianmviana.hexaarch.datasources.services.converter.convertToModel
import dev.brianmviana.hexaarch.datasources.services.data.response.gitlab.GitlabUserResponse
import dev.brianmviana.hexaarch.entities.GitRepo
import dev.brianmviana.hexaarch.exceptions.NotFoundException
import dev.brianmviana.hexaarch.repositories.GitRepoRepository
import org.springframework.stereotype.Component

@Component
class GitlabRepositoriesDataSource(
    val gitlabProjectsClient: GitlabProjectsClient
): GitRepoRepository {

    private val gitlabUserCache: HashMap<String, GitlabUserResponse> = HashMap()

    override fun getGitRepoListByOwner(username: String): MutableList<GitRepo> {
        val repoList = mutableListOf<GitRepo>()
        val gitlabUserId: Int = this.getGitlabUserByUsername(username).id
        val repos = this.gitlabProjectsClient.getProjectsByNameAndUserId(gitlabUserId)
        repos.forEach {
            repoList.add(it.convertToModel())
        }
        return repoList
    }

    private fun getGitlabUserByUsername(username: String): GitlabUserResponse {
        return this.gitlabProjectsClient.getUsersByUsername(username)
            .stream()
            .findFirst()
            .orElseThrow { NotFoundException() }
    }

}
