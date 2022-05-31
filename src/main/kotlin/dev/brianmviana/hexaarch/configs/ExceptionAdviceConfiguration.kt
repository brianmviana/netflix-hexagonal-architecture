package dev.brianmviana.hexaarch.configs

import dev.brianmviana.hexaarch.exceptions.InternalServerErrorException
import dev.brianmviana.hexaarch.exceptions.NotFoundException
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class ExceptionAdviceConfiguration: ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    fun repositoryNotFoundExceptionHandler(e: NotFoundException, request: WebRequest): ResponseEntity<Any?>? {
        logger.error("Error " + e + " path " + (request as ServletWebRequest).request.requestURI)
        val apiError = RESTAPIException(e.message, e.message, NOT_FOUND, LocalDateTime.now())
        return ResponseEntity(apiError, NOT_FOUND)
    }

    @ExceptionHandler(InternalServerErrorException::class)
    fun repositoryInternalServerErrorExceptionHandler(
        e: InternalServerErrorException,
        request: WebRequest
    ): ResponseEntity<Any?>? {
        logger.error("Error " + e + " path " + (request as ServletWebRequest).request.requestURI)
        val apiError =
            RESTAPIException(e.message, e.message, INTERNAL_SERVER_ERROR, LocalDateTime.now())
        return ResponseEntity(apiError, INTERNAL_SERVER_ERROR)
    }

}