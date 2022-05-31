package dev.brianmviana.hexaarch.configs

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class RESTAPIException(
    val userMessage: String?,
    val developerMessage: String?,
    httpStatus: HttpStatus,
    val timestamp: LocalDateTime?
) {

    val status: Int?
    val error: String?

    init {
        this.status = httpStatus.value()
        this.error = httpStatus.name
    }

}
