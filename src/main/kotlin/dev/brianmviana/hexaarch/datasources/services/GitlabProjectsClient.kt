package dev.brianmviana.hexaarch.datasources.services

import dev.brianmviana.hexaarch.datasources.services.data.response.gitlab.GitlabProjectResponse
import dev.brianmviana.hexaarch.datasources.services.data.response.gitlab.GitlabUserResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "gitlab-projects", url = "\${webservices.gitlab.services.users}")
interface GitlabProjectsClient {

    @GetMapping("/{userId}/projects")
    fun getProjectsByNameAndUserId(@PathVariable("userId") userId: Int): MutableList<GitlabProjectResponse>

    @GetMapping
    fun getUsersByUsername(@RequestParam("username") username: String): MutableList<GitlabUserResponse>

}