package dev.brianmviana.hexaarch.repositories

import dev.brianmviana.hexaarch.entities.GitRepoList

interface GitRepoRepository {

    fun getGitRepoListByOwner(username: String) : GitRepoList

}
