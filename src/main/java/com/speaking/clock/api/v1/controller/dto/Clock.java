package com.speaking.clock.api.v1.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
public class Clock {
    String hours;
    String mins;
    String readableText;

}
