package com.github.fabriciolfj.inventaryserviceimperativo.provider.repository.mappers;


import com.github.fabriciolfj.inventaryserviceimperativo.domain.InventoryEntity;
import com.github.fabriciolfj.inventaryserviceimperativo.domain.TypeOperation;
import com.github.fabriciolfj.inventaryserviceimperativo.provider.repository.data.InventoryData;

public class InventoryDataMapper {

    private static final long QUANTIY_ZERO = 0;
    private InventoryDataMapper() { }

    public static InventoryData toData(final InventoryEntity entity) {
        return InventoryData
                .builder()
                .exit(entity.isExit() ? entity.getQuantity() : QUANTIY_ZERO)
                .entrance(entity.isEntrance() ? entity.getQuantity() : QUANTIY_ZERO)
                .code(entity.getCode())
                .product(entity.getProduct())
                .balance(entity.getBalance())
                .dateRegistration(entity.getRegistration())
                .build();
    }

    public static InventoryEntity toEntity(final InventoryData data) {
        return InventoryEntity.builder()
                .quantity(data.getEntrance() > 0? data.getEntrance() : data.getExit())
                .balance(data.getBalance())
                .registration(data.getDateRegistration())
                .code(data.getCode())
                .product(data.getProduct())
                .typeOperation(data.getEntrance() > 0? TypeOperation.ENTRANCE : TypeOperation.EXIT)
                .build();
    }
}
