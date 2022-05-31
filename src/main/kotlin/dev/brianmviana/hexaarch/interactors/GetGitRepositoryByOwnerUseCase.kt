package dev.brianmviana.hexaarch.interactors

import dev.brianmviana.hexaarch.entities.GitRepo
import dev.brianmviana.hexaarch.repositories.GitRepoRepository
import org.springframework.stereotype.Service

@Service
class GetGitRepositoryByOwnerUseCase(val gitRepoRepository: GitRepoRepository) {

    fun execute(username: String): GitRepo {
        return this.gitRepoRepository.getGitRepoByOwner(username)
    }

}