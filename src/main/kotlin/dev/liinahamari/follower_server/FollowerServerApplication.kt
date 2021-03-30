package dev.liinahamari.follower_server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FollowerServerApplication

fun main(args: Array<String>) {
	runApplication<FollowerServerApplication>(*args)
}
