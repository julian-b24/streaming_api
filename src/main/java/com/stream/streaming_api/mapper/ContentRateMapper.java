package com.stream.streaming_api.mapper;

import com.stream.streaming_api.dto.ContentRateDTO;
import com.stream.streaming_api.model.ContentRate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContentRateMapper {
    ContentRate fromDTOtoContentRate(ContentRateDTO contentRateDTO);
}
