package com.riwi.beautySalon.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.beautySalon.api.dto.request.ClientReq;
import com.riwi.beautySalon.api.dto.response.ClientResp;
import com.riwi.beautySalon.infraestructure.abtract_service.IClientService;
import com.riwi.beautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/client")
@AllArgsConstructor

public class ClienteController {

    @Autowired
    private final IClientService client;

    @GetMapping
    public ResponseEntity<Page<ClientResp>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }

        return ResponseEntity.ok(client.getAll(page -1, size, sortType));
    }

    @PostMapping
    public ResponseEntity<ClientResp> create(
        @Validated @RequestBody ClientReq resquest
    ){
        return ResponseEntity.ok(client.create(resquest));
    }

    
}
