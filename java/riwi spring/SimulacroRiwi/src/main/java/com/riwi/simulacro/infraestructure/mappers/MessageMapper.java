package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.create.MessageRequest;
import com.riwi.simulacro.api.dto.response.MessageResponse;
import com.riwi.simulacro.domain.entities.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MessageMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "senderId.id", source = "senderId"),
            @Mapping(target = "receiverId.id", source = "receiverId"),
            @Mapping(target = "courseId.id", source = "courseId")
    })
    Message toMessage(MessageRequest messageRequest);

    MessageResponse toMessageResponse(Message message);

    @Mappings({
            @Mapping(target = "senderId.id", source = "senderId"),
            @Mapping(target = "receiverId.id", source = "receiverId"),
            @Mapping(target = "courseId.id", source = "courseId")
    })
    void updateFromMessageRequest(MessageRequest messageRequest, @MappingTarget Message message);
}
