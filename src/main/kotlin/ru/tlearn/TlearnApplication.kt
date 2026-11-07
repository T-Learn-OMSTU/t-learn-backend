package ru.tlearn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TlearnApplication

fun main(args: Array<String>) {
	runApplication<TlearnApplication>(*args)
}
