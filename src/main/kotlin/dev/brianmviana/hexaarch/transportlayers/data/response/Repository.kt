package dev.brianmviana.hexaarch.transportlayers.data.response

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
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

