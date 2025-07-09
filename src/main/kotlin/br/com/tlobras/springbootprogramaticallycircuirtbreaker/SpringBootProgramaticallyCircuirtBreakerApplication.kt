package br.com.tlobras.springbootprogramaticallycircuirtbreaker

import br.com.tlobras.springbootprogramaticallycircuirtbreaker.services.ExecuteGetService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootProgrammaticallyCircuitBreakerApplication(
	private val executeGetService: ExecuteGetService
) : CommandLineRunner {
	override fun run(vararg args: String?) {
		val result = executeGetService.execute("http://example.com", "exampleService")
		println("Service response: $result")
	}
}

fun main(args: Array<String>) {
	runApplication<SpringBootProgrammaticallyCircuitBreakerApplication>(*args)
}
