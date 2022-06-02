package dev.brianmviana.hexaarch.transportlayers.restapi

import dev.brianmviana.hexaarch.interactors.GetGitRepositoryByOwnerUseCase
import dev.brianmviana.hexaarch.transportlayers.converter.convertToDTO
import dev.brianmviana.hexaarch.transportlayers.data.response.Repository
import io.swagger.annotations.Api
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
@Api(tags = ["Repositories"])
class RepositoryApiImpl(val getGitRepositoryByOwnerUseCase: GetGitRepositoryByOwnerUseCase) {

    @Operation(
        summary = "Get Git Repositories",
        operationId = "getGitRepositories",
        description = "get a Repositories by username",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Response List of the Git Repository",
                content = [Content(schema = Schema(implementation = Repository::class))])
        ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/repository"],
        produces = ["application/json"]
    )
    fun getGitRepositories(
        @NotNull
        @Parameter(description = "username of the Git User", required = true)
        @Valid
        @RequestParam(value = "username", required = true)
        username: kotlin.String): ResponseEntity<List<Repository>> {

        val gitRepositories = this.getGitRepositoryByOwnerUseCase.execute(username)
        val repositories = mutableListOf<Repository>()
        gitRepositories.forEach {
            repositories.add(it.convertToDTO())
        }
        return ResponseEntity.ok(repositories)
    }

}