package com.stream.streaming_api.dto;

import com.stream.streaming_api.constants.ContentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDTO {

    private UUID id;

    private String genre;

    private ContentType type;

    private int views;

    private float rate;

}
