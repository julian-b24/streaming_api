package com.stream.streaming_api.mapper;

import com.stream.streaming_api.dto.ContentDTO;
import com.stream.streaming_api.model.Content;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContentMapper {
    ContentDTO fromContentToDTO(Content content);
    Content fromDTOtoContent(ContentDTO contentDTO);
}
