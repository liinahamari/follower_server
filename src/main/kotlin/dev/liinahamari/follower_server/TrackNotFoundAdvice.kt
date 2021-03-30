package dev.liinahamari.follower_server

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
internal class TrackNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TrackNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun trackNotFoundHandler(ex: TrackNotFoundException): String? = ex.message
}