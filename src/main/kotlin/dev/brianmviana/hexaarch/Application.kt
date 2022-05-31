package dev.brianmviana.hexaarch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class NetflixHexagonalArchitectureApplication

fun main(args: Array<String>) {
	runApplication<NetflixHexagonalArchitectureApplication>(*args)
}
