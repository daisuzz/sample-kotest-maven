package com.daisuzz.samplekotestmaven

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleKotestMavenApplication(val fizzBazzGenerator: FizzBuzzGenerator) : CommandLineRunner {
    override fun run(vararg args: String?) {
        (1..100).map {
            println(fizzBazzGenerator.generate(it))
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SampleKotestMavenApplication>(*args)
}
