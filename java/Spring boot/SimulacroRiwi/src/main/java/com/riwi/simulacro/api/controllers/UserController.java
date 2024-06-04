package com.riwi.simulacro.api.controllers;

import com.riwi.simulacro.api.dto.request.create.UserRequest;
import com.riwi.simulacro.api.dto.request.update.UserUpdateRequest;
import com.riwi.simulacro.api.dto.response.UserResponse;
import com.riwi.simulacro.infraestructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@Validated @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.create(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @Validated @RequestBody UserUpdateRequest userRequest
    ) {
        return ResponseEntity.ok(userService.update(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponse>> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }
}
