package restfullapi.notes.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import restfullapi.notes.model.WebResponse

@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(ex: IllegalArgumentException): ResponseEntity<WebResponse<String>> {
        val response = WebResponse<String>(
            data = null,
            error = ex.message ?: "Terjadi kesalahan input"
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST) // 400
    }
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleArgumentNotValid(ex: MethodArgumentNotValidException): ResponseEntity<WebResponse<String>> {
        val response = WebResponse<String>(
            data = null,
            error = "Terjadi kesalahan input"
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST) // 400
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneral(ex: Exception): ResponseEntity<WebResponse<String>> {
        val response = WebResponse<String>(
            data = null,
            error = "Terjadi kesalahan sistem: $ex"
        )
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR) // 500
    }
}