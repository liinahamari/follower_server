package dev.liinahamari.follower_server

import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
internal class TrackController(private val trackRepo: TrackRepository) {
    @GetMapping("/tracks")
    fun getAllTracks(): List<Track> = trackRepo.findAll()

    @PostMapping("/tracks")
    fun newTrack(@RequestBody newTrack: Track): Track = trackRepo.save(newTrack)

    @GetMapping("/tracks/{time}")
    fun getTrack(@PathVariable id: Long): Track = trackRepo.findById(id)
        .orElseThrow { TrackNotFoundException(id) }

    @PutMapping("/tracks/{time}")
    fun replaceTrack(@RequestBody newTrack: Track, @PathVariable time: Long): Track = trackRepo.findById(time)
        .map { track: Track ->
            track.title = newTrack.title
            track.wayPoints = newTrack.wayPoints
            trackRepo.save(track)
        }
        .orElseGet {
            trackRepo.save(newTrack)
        }

    @DeleteMapping("/tracks/{id}")
    fun deleteTrack(@PathVariable id: Long) {
        trackRepo.deleteById(id)
    }

//    @GetMapping("/employees/{id}")
//    fun one(@PathVariable id: Long): EntityModel<Employee> = EntityModel.of(repository.findById(id).orElseThrow { EmployeeNotFoundException(id) },
//            linkTo(methodOn(EmployeeController::class.java).one(id)).withSelfRel(),
//            linkTo(methodOn(EmployeeController::class.java).all()).withRel("employees")
//        )
}

internal class TrackNotFoundException(id: Long) : RuntimeException("Could not find Track $id")