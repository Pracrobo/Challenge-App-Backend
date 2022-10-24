package com.whale.challenge.controller;

import com.whale.challenge.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

	private final MainService mainService;

}
