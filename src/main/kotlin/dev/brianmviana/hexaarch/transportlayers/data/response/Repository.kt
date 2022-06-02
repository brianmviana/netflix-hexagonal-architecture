package dev.brianmviana.hexaarch.transportlayers.data.response

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * GitRepository model
 * @param name 
 * @param fullName 
 * @param description 
 */
data class Repository(

    @Schema(example = "repository name", required = true, description = "")
    @field:JsonProperty("name", required = true) val name: kotlin.String,

    @Schema(example = "user/repository-name", required = true, description = "")
    @field:JsonProperty("fullName", required = true) val fullName: kotlin.String,

    @Schema(example = "description of the repository", description = "")
    @field:JsonProperty("description") val description: kotlin.String? = null
) {

}

