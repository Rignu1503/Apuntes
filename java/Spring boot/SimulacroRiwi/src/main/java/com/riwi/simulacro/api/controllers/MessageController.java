package com.riwi.simulacro.api.controllers;

import com.riwi.simulacro.api.dto.request.create.MessageRequest;
import com.riwi.simulacro.api.dto.response.MessageResponse;
import com.riwi.simulacro.infraestructure.abstract_services.IMessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class MessageController {
    @Autowired
    private final IMessageService messageService;

    @PostMapping
    public ResponseEntity<MessageResponse> saveMessage(@Validated @RequestBody MessageRequest messageRequest) {
        return ResponseEntity.ok(messageService.create(messageRequest));
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Page<MessageResponse>> getAllMessagesByCourse(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @PathVariable Long courseId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(messageService.findByCourseId(pageable, courseId));
    }

    @GetMapping
    public ResponseEntity<Page<MessageResponse>> getAllMessagesBySenderAndReceiver(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam Long senderId,
            @RequestParam Long receiverId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(messageService.findBySenderAndReceiver(pageable, senderId, receiverId));
    }
}
