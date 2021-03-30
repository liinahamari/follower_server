package dev.liinahamari.follower_server

import javax.persistence.*

@Entity
data class Track(@Id var time: Long,
                          var title: String,
                          @Lob
                          var wayPoints: Array<Pair<Double, Double>>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Track

        if (time != other.time) return false
        if (title != other.title) return false
        if (!wayPoints.contentEquals(other.wayPoints)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = time.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + wayPoints.contentHashCode()
        return result
    }
}

@Entity
data class WayPoint(val lon: Double, val lat: Double, val time: Long, val provider: String) {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "track_id", nullable = false)
    lateinit var track: Track
}