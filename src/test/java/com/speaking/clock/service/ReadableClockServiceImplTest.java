package com.speaking.clock.service;

import com.speaking.clock.api.v1.controller.dto.Clock;
import com.speaking.clock.api.v1.controller.dto.ReadableTime;
import com.speaking.clock.exception.TimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReadableClockServiceImplTest {


    @InjectMocks
    ReadableClockServiceImpl readableClockService;

    Clock clock = new Clock();
    ReadableTime readableTime = new ReadableTime();

    @Test
    void testConvertDigitalTimeToReadableTime() throws TimeException {

        ReadableTime results = readableClockService.convertDigitalTimeToReadableTime("11:30");
        Assertions.assertEquals(results.getTime(), "Half pass Elevan");

        results = readableClockService.convertDigitalTimeToReadableTime("13:10");
        Assertions.assertEquals(results.getTime(), "Ten pass One");

        results = readableClockService.convertDigitalTimeToReadableTime("14:50");
        Assertions.assertEquals(results.getTime(), "Ten to Three");


        results = readableClockService.convertDigitalTimeToReadableTime("00:30");
        Assertions.assertEquals(results.getTime(), "Half pass Twelve");

        results = readableClockService.convertDigitalTimeToReadableTime("00:00");
        Assertions.assertEquals(results.getTime(), "Twelve o'clock");

        results = readableClockService.convertDigitalTimeToReadableTime("01:00");
        Assertions.assertEquals(results.getTime(), "One o'clock");

    }

    @Test
    void whenInvalidTime_ThrowsBankException() {
        Exception exception = assertThrows(TimeException.class, () -> {
            readableClockService.convertDigitalTimeToReadableTime("abc");
        });
        String expectedMessage = "Invalid Time";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void whenInvalidHour_ThrowsBankException() {
        Exception exception = assertThrows(TimeException.class, () -> {
            readableClockService.convertDigitalTimeToReadableTime("25:00");
        });
        String expectedMessage = "Invalid Hour";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void whenInvalidMin_ThrowsBankException() {
        Exception exception = assertThrows(TimeException.class, () -> {
            readableClockService.convertDigitalTimeToReadableTime("11:66");
        });
        String expectedMessage = "Invalid Min";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
}