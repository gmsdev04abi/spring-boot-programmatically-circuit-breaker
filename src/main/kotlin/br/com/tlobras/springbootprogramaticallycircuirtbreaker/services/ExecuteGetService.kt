package br.com.tlobras.springbootprogramaticallycircuirtbreaker.services

import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ExecuteGetService(
    private val restTemplate: RestTemplate,
    private val circuitBreakerRegistry: CircuitBreakerRegistry
) {

    fun execute(url: String, serviceName: String): String {
        val circuitBreaker: CircuitBreaker = circuitBreakerRegistry.circuitBreaker(serviceName)

        return try {
            circuitBreaker.executeSupplier {
                restTemplate.getForObject(url, String::class.java)
                    ?: throw RuntimeException("Response is null for service: $serviceName")
            }
        } catch (ex: Exception) {
            "Fallback for [$serviceName]: ${ex.message}"
        }
    }

}