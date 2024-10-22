package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.create.MessageRequest;
import com.riwi.simulacro.api.dto.response.MessageResponse;
import com.riwi.simulacro.domain.entities.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMessageService extends
        CreateReadDeleteService<MessageRequest, MessageResponse, Long>,
        UpdateService<MessageRequest, MessageResponse, Long>
{
    Page<MessageResponse> findByCourseId(Pageable pageable, Long courseId);
    Page<MessageResponse> findBySenderAndReceiver(Pageable pageable, Long senderId, Long receiverId);
}
