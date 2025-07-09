package br.com.tlobras.springbootprogramaticallycircuirtbreaker.services

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ExecuteGetService(
    private val restTemplate: RestTemplate
) {

    fun execute(url: String, serviceName: String): String {
        return try {
            restTemplate.getForObject(url, String::class.java)
                ?: throw RuntimeException("Response is null for service: $serviceName")
        } catch (ex: Exception) {
            throw RuntimeException("Failed to execute GET request for service: $serviceName", ex)
        }
    }

}