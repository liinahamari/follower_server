package dev.liinahamari.follower_server

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoadDatabase {
    @Bean
    internal fun initDatabase(trackRepository: TrackRepository, wayPointRepository: WayPointRepository) = CommandLineRunner { _ ->
//        log.info("Preloading track " + trackRepository.save(Track(time = System.currentTimeMillis(), title = "one")))
//        log.info("Preloading track " + trackRepository.save(Track(time = System.currentTimeMillis(), title = "two")))


        log.info("Preloading wp " + wayPointRepository.save(WayPoint(3.3, 0.0, 2L, "GPS")))
        log.info("Preloading wp " + wayPointRepository.save(WayPoint(.1, .2, 1L, "none")))
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)
    }
}