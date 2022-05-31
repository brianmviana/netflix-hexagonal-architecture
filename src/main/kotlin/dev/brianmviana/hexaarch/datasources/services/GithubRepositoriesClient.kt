package dev.brianmviana.hexaarch.datasources.services

import dev.brianmviana.hexaarch.datasources.services.data.response.GithubRepositoryResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "github-repos", url = "\${webservices.github.services.users}")
interface GithubRepositoriesClient {

    @GetMapping("{username}/repos")
    fun getGitReposByOwner(@PathVariable("username") username: String): GithubRepositoryResponse

}
