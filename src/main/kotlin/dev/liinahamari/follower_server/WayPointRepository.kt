package dev.liinahamari.follower_server

import org.springframework.data.jpa.repository.JpaRepository

interface WayPointRepository : JpaRepository<WayPoint, Long>