package com.springboot.jpa.controller;

import com.springboot.jpa.data.dto.ValidRequestDto;
import com.springboot.jpa.data.group.ValidationGroup1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    private final Logger LOGGER = LoggerFactory.getLogger(ValidationController.class);

    @PostMapping("/valid")
    public ResponseEntity<String> checkValidationByValid(@Validated(ValidationGroup1.class) @RequestBody ValidRequestDto validRequestDto) {
        LOGGER.info(validRequestDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(validRequestDto.toString());

    }

}
