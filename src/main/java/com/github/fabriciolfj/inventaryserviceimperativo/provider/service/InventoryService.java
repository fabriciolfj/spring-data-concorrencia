package com.github.fabriciolfj.inventaryserviceimperativo.provider.service;

import com.github.fabriciolfj.inventaryserviceimperativo.domain.InventoryEntity;
import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.InventoryNotFoundException;
import com.github.fabriciolfj.inventaryserviceimperativo.provider.repository.InventoryRepository;
import com.github.fabriciolfj.inventaryserviceimperativo.provider.repository.mappers.InventoryDataMapper;
import com.github.fabriciolfj.inventaryserviceimperativo.usecase.ProviderFindInventory;
import com.github.fabriciolfj.inventaryserviceimperativo.usecase.ProviderSaveInventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService implements ProviderFindInventory, ProviderSaveInventory {

    private final InventoryRepository repository;

    @Override
    public void process(final InventoryEntity entity) {
        repository.save(InventoryDataMapper.toData(entity));
    }

    @Override
    public InventoryEntity process(final String code) {
        return repository.findFirstByProductOrderByDateRegistrationDesc(code)
                .map(InventoryDataMapper::toEntity)
                .orElseThrow(InventoryNotFoundException::new);
    }
}
