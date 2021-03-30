package dev.liinahamari.follower_server

import org.springframework.data.jpa.repository.JpaRepository

internal interface TrackRepository : JpaRepository<Track, Long>
