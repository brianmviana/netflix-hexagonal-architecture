package dev.brianmviana.hexaarch.transportlayers

import dev.brianmviana.hexaarch.entities.GitRepo
import dev.brianmviana.hexaarch.interactors.GetGitRepositoryByOwnerUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/repos")
class GitRepoApiImpl(val getGitRepositoryByOwnerUseCase: GetGitRepositoryByOwnerUseCase) {

    @GetMapping
    fun getRepositories(@RequestParam username: String): ResponseEntity<List<GitRepo>> {
        var repositories = this.getGitRepositoryByOwnerUseCase.execute(username)
        return ResponseEntity.ok(repositories)
    }


}