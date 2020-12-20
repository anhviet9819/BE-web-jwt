package com.example.intern.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/error")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ErrorController {
	//do nothing
}
