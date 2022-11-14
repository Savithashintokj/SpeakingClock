package com.speaking.clock.api.v1.controller;

import com.speaking.clock.api.v1.controller.dto.ReadableTime;

import com.speaking.clock.exception.TimeException;
import com.speaking.clock.service.ReadableClockService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReadableClockControllerTest {

    @InjectMocks
    ReadableClockController readableClockController;

    @Mock
    ReadableClockService readableClockService;

    ReadableTime readableTime = new ReadableTime();

    @Test
    public void testGetTime() throws TimeException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        readableTime.setTime("Half pass one");

        when(readableClockService.convertDigitalTimeToReadableTime(any(String.class))).thenReturn(readableTime);
        ResponseEntity<ReadableTime> responseEntity = readableClockController.getReadableTime("01:30");
        ReadableTime results = responseEntity.getBody();
        Assertions.assertEquals(results.getTime(), readableTime.getTime());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void whenInvalidCustomerNumber_ThrowsBankException() throws TimeException {
        when(readableClockService.convertDigitalTimeToReadableTime(any(String.class))).thenThrow(TimeException.class);

        Assertions.assertThrows(TimeException.class, () -> {
            readableClockController.getReadableTime("Invalid");
        });
    }

}