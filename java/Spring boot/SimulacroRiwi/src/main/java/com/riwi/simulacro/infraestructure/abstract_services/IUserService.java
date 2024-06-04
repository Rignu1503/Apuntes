package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.create.UserRequest;
import com.riwi.simulacro.api.dto.request.update.UserUpdateRequest;
import com.riwi.simulacro.api.dto.response.UserResponse;

public interface IUserService extends
        CreateReadDeleteService<UserRequest, UserResponse, Long>,
        UpdateService<UserUpdateRequest, UserResponse, Long>
{
}
