package com.stream.streaming_api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TokenTime {

    ONE_MINUTE(60000l);

    private long time;

}
