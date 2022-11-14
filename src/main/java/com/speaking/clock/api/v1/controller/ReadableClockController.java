package com.speaking.clock.api.v1.controller;

import com.speaking.clock.api.v1.controller.dto.ReadableTime;

import com.speaking.clock.exception.TimeException;
import com.speaking.clock.service.ReadableClockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clock")
public class ReadableClockController {
    Logger logger = LoggerFactory.getLogger(ReadableClockController.class);
    private final ReadableClockService readableClockService;

    public ReadableClockController(ReadableClockService readableClockService) {
        this.readableClockService = readableClockService;
    }

    @Operation(method = "GET",
            summary="This service is to convert digital time to readable time"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conversion of digital time to readable time is successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReadableClockController.class)) }),
    })

    @GetMapping(value = "/{time}")
    public ResponseEntity<ReadableTime> getReadableTime(@PathVariable("time") String time) throws TimeException {
        logger.info("Convert digital time to readable time");
        return new ResponseEntity<>(readableClockService.convertDigitalTimeToReadableTime(time), HttpStatus.OK);
    }

}
