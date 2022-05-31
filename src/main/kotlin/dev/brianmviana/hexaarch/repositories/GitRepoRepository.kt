package dev.brianmviana.hexaarch.repositories

import dev.brianmviana.hexaarch.entities.GitRepo

interface GitRepoRepository {

    fun getGitRepoListByOwner(username: String) : MutableList<GitRepo>

}
