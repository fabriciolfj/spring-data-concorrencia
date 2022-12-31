package com.github.fabriciolfj.inventaryserviceimperativo.controller;

import com.github.fabriciolfj.inventaryserviceimperativo.controller.dto.request.InventoryCreateRequest;
import com.github.fabriciolfj.inventaryserviceimperativo.controller.dto.request.InventoryRequest;
import com.github.fabriciolfj.inventaryserviceimperativo.controller.mappers.InventoryDTOMapper;
import com.github.fabriciolfj.inventaryserviceimperativo.usecase.domain.CreateInventoryUseCase;
import com.github.fabriciolfj.inventaryserviceimperativo.usecase.domain.UpdateInventory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/v1/inventories")
@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final CreateInventoryUseCase createInventoryUseCase;
    private final UpdateInventory updateDebitInventory;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void process(@Valid @RequestBody final InventoryCreateRequest request) {
        createInventoryUseCase.execute(InventoryDTOMapper.toEntity(request));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void process(@Valid @RequestBody final InventoryRequest request) {
        updateDebitInventory.execute(InventoryDTOMapper.toEntity(request));
    }
}
