package br.com.tlobras.springbootprogramaticallycircuirtbreaker.services

import org.springframework.stereotype.Service

@Service
class ServiceExecutorOrchestratorService(
    private val executeGetService: ExecuteGetService
) {
    fun run() {
        val urls = listOf(
            "http://localhost:8080/api/success" to "successService",
            "http://localhost:8080/api/error" to "errorService"
        )

        repeat(10) {
            urls.forEach { (url, serviceName) ->
                executeGetService.execute(url, serviceName).let {
                    println("Service response: $it")
                }.also {
                    Thread.sleep(1000)
                }
            }
        }
    }
}