package com.github.fabriciolfj.inventaryserviceimperativo.controller.mappers;

import com.github.fabriciolfj.inventaryserviceimperativo.controller.dto.request.InventoryCreateRequest;
import com.github.fabriciolfj.inventaryserviceimperativo.controller.dto.request.InventoryRequest;
import com.github.fabriciolfj.inventaryserviceimperativo.domain.InventoryEntity;
import com.github.fabriciolfj.inventaryserviceimperativo.domain.TypeOperation;

import java.time.LocalDateTime;
import java.util.UUID;

public class InventoryDTOMapper {

    private InventoryDTOMapper(){ }

    public static InventoryEntity toEntity(final InventoryRequest request) {
        return InventoryEntity
                .builder()
                .quantity(request.getQuantity())
                .code(UUID.randomUUID().toString())
                .typeOperation(TypeOperation.toEnum(request.getOperation()))
                .product(request.getProduct())
                .registration(LocalDateTime.now())
                .build();
    }

    public static InventoryEntity toEntity(final InventoryCreateRequest request) {
        return InventoryEntity
                .builder()
                .quantity(request.getQuantity())
                .code(UUID.randomUUID().toString())
                .typeOperation(TypeOperation.ENTRANCE)
                .product(request.getProduct())
                .balance(request.getQuantity())
                .registration(LocalDateTime.now())
                .build();
    }
}
