package br.com.gmsdev04abi.springbootprogramaticallycircuirtbreaker

import br.com.gmsdev04abi.springbootprogramaticallycircuirtbreaker.services.ServiceExecutorOrchestratorService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootProgrammaticallyCircuitBreakerApplication(
	private val service: ServiceExecutorOrchestratorService
) : CommandLineRunner {
	override fun run(vararg args: String?) {
		service.run()
	}
}

fun main(args: Array<String>) {
	runApplication<SpringBootProgrammaticallyCircuitBreakerApplication>(*args)
}
