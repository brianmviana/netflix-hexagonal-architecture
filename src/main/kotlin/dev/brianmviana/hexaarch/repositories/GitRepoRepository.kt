package dev.brianmviana.hexaarch.repositories

import dev.brianmviana.hexaarch.entities.GitRepo

interface GitRepoRepository {

    fun getGitRepoByOwner(username: String) : GitRepo

}