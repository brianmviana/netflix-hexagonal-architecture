package dev.brianmviana.hexaarch.interactors

import dev.brianmviana.hexaarch.entities.GitRepoList
import dev.brianmviana.hexaarch.repositories.GitRepoRepository
import org.springframework.stereotype.Service

@Service
class GetGitRepositoryByOwnerUseCase(val gitRepoRepository: GitRepoRepository) {

    fun execute(username: String): GitRepoList {
        return this.gitRepoRepository.getGitRepoListByOwner(username)
    }

}
