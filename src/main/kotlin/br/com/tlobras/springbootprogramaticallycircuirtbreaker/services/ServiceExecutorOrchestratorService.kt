package br.com.tlobras.springbootprogramaticallycircuirtbreaker.services

import org.springframework.stereotype.Service

@Service
class ServiceExecutorOrchestratorService(
    private val executeGetService: ExecuteGetService
) {
    fun run() {
        executeGetService.execute("http://localhost:8080/api/success", "exampleService").let {
            println("Service response: $it")
        }

        executeGetService.execute("http://localhost:8080/api/error", "exampleService").let {
            println("Service response: $it")
        }
    }
}