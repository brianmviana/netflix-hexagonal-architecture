package dev.brianmviana.hexaarch.transportlayers.restapi

import dev.brianmviana.hexaarch.interactors.GetGitRepositoryByOwnerUseCase
import dev.brianmviana.hexaarch.transportlayers.converter.convertToDTO
import dev.brianmviana.hexaarch.transportlayers.openapi.api.RepositoryApi
import dev.brianmviana.hexaarch.transportlayers.openapi.model.Repository
import io.swagger.annotations.Api
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(tags = ["Repositories"])
class RepositoryApiImpl(val getGitRepositoryByOwnerUseCase: GetGitRepositoryByOwnerUseCase): RepositoryApi {

    override fun getGitRepositories(username: String): ResponseEntity<List<Repository>> {
        val gitRepositories = this.getGitRepositoryByOwnerUseCase.execute(username)
        val repositories = mutableListOf<Repository>()
        gitRepositories.forEach {
            repositories.add(it.convertToDTO())
        }
        return ResponseEntity.ok(repositories)
    }

}