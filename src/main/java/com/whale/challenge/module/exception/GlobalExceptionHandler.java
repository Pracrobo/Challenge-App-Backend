package com.whale.challenge.module.exception;

import com.whale.challenge.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

import static com.whale.challenge.module.exception.GetPrintStackTrace.GetException;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDto> handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		// 인지할 수 없는 오류
		String URL = request.getRequestURL().toString();
		String exception = URL +
				lineSeparator() +
				GetException(e);

		ResponseDto exceptionResponse = new ResponseDto(exception, "0", "알 수 없는 오류가 발생했습니다.");
		log.error("알 수 없는 오류가 발생했습니다.");
		log.error(exception);
		return exceptionResponse.wrap();
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseDto> handleNoSuchElementException(HttpServletRequest request, HttpServletResponse response, NoSuchElementException e) {
		// 인지할 수 없는 오류
		String URL = request.getRequestURL().toString();
		String exception = URL +
				lineSeparator() +
				GetException(e);

		ResponseDto exceptionResponse = new ResponseDto(exception, "0", e.getMessage());
		log.error(e.getMessage());
		log.error(exception);
		return exceptionResponse.wrap();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseDto> handleConstraintViolationException(HttpServletRequest request, HttpServletResponse response, ConstraintViolationException e) {
		String URL = request.getRequestURL().toString();
		String exception = URL +
				lineSeparator() +
				GetException(e);

		String message = e.getConstraintViolations().stream()
				.map(ConstraintViolation::getMessage)
				.filter(StringUtils::hasText)
				.collect(joining(lineSeparator(), "", ""));

		ResponseDto exceptionResponse = new ResponseDto(exception, "0", message);
		log.error(e.getMessage());
		log.error(exception);

		return exceptionResponse.wrap();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(HttpServletRequest request, HttpServletResponse response, MethodArgumentNotValidException e) {
		String URL = request.getRequestURL().toString();
		String exception = URL +
				lineSeparator() +
				GetException(e);

		log.error(e.getAllErrors().toString());

		String message = e.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + " : " + error.getDefaultMessage())
				.filter(StringUtils::hasText)
				.collect(joining(lineSeparator(), "", ""));

		ResponseDto exceptionResponse = new ResponseDto(exception, "0", message);
		log.error(e.getMessage());
		log.error(exception);

		return exceptionResponse.wrap();
	}

}