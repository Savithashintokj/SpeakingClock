package com.speaking.clock.service;

import com.speaking.clock.api.v1.controller.dto.ReadableTime;
import com.speaking.clock.exception.TimeException;

/**
 * Created by Savitha Shinto.
 */
public interface ReadableClockService {
    ReadableTime convertDigitalTimeToReadableTime(String time) throws TimeException;
}
