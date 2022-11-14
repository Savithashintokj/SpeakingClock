package com.speaking.clock.service;

import com.speaking.clock.api.v1.controller.dto.Clock;
import com.speaking.clock.api.v1.controller.dto.ReadableTime;

import com.speaking.clock.errors.TimeErrors;
import com.speaking.clock.exception.TimeException;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Savitha Shinto.
 */
@Service
public class ReadableClockServiceImpl implements ReadableClockService {
    Map<Integer, String> hours = new HashMap<>();
    Map<Integer, String> mins = new HashMap<>();

    @Override
    public ReadableTime convertDigitalTimeToReadableTime(String time) throws TimeException {
        String digitalTime[] = null;
        int digitalHours = 0;
        int digitalMins = 0;
        try {
            digitalTime = time.split(":");
            digitalHours = Integer.parseInt(digitalTime[0]);
            digitalMins = Integer.parseInt(digitalTime[1]);
        } catch (Exception ex) {
            throw new TimeException(TimeErrors.INVALID_TIME);
        }
        try {
            if (digitalHours > 24 || digitalHours < 0) {
                throw new TimeException(TimeErrors.INVALID_HOUR);
            }
        } catch (Exception ex) {
            throw new TimeException(TimeErrors.INVALID_HOUR);
        }
        try {

            if (digitalMins > 60 || digitalHours < 0) {
                throw new TimeException(TimeErrors.INVALID_MIN);
            }
        } catch (Exception ex) {
            throw new TimeException(TimeErrors.INVALID_MIN);
        }

        getHours();
        getMins();
        Clock clock = new Clock();

        ReadableTime readableTime = new ReadableTime();
        if (digitalMins <= 30 && digitalMins != 0) {
            clock.setReadableText(" pass ");
            clock.setHours(hours.get(digitalHours));

        } else if (digitalMins != 0 && digitalMins > 30) {
            clock.setReadableText(" to ");
            if (digitalHours == 23) {
                clock.setHours(hours.get(12));
            } else {
                clock.setHours(hours.get(digitalHours + 1));
            }
        } else {
            clock.setHours(hours.get(digitalHours));
        }

        clock.setMins(mins.get(digitalMins));

        readableTime.setTime((clock.getMins() != null ? clock.getMins() : "") +
                (clock.getReadableText() != null ? clock.getReadableText() : "") +
                (clock.getHours() != null ? clock.getHours() : "") +
                (clock.getReadableText() == null ? " o'clock" : "")
        );
        return readableTime;

    }

    private void getMins() {
        mins.put(5, "Five");
        mins.put(10, "Ten");
        mins.put(15, "Quarter");
        mins.put(20, "Twenty");
        mins.put(25, "Twenty Five");
        mins.put(30, "Half");
        mins.put(35, "Five");
        mins.put(40, "Twenty");
        mins.put(45, "Quarter");
        mins.put(50, "Ten");
        mins.put(55, "Five");

    }

    private void getHours() {
        hours.put(1, "One");
        hours.put(2, "Two");
        hours.put(3, "Three");
        hours.put(4, "Four");
        hours.put(5, "Five");
        hours.put(6, "Six");
        hours.put(7, "Seven");
        hours.put(8, "Eight");
        hours.put(9, "Nine");
        hours.put(10, "Ten");
        hours.put(11, "Elevan");
        hours.put(12, "Twelve");
        hours.put(13, "One");
        hours.put(14, "Two");
        hours.put(15, "Three");
        hours.put(16, "Four");
        hours.put(17, "Five");
        hours.put(18, "Six");
        hours.put(19, "Seven");
        hours.put(20, "Eight");
        hours.put(21, "Nine");
        hours.put(22, "Ten");
        hours.put(23, "Elevan");
        hours.put(00, "Twelve");

    }
}