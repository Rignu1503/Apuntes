package com.riwi.simulacro.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private Long id;
    private String messageContent;
    private Date sentDate;
    private UserResponse senderId;
    private UserResponse receiverId;
    private CourseResponse courseId;
}
