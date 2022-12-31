package com.github.fabriciolfj.inventaryserviceimperativo.usecase.domain;

import com.github.fabriciolfj.inventaryserviceimperativo.domain.InventoryEntity;
import com.github.fabriciolfj.inventaryserviceimperativo.usecase.ProviderSaveInventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateInventoryUseCase {

    private final ProviderSaveInventory providerSaveInventory;

    @Transactional(propagation = Propagation.REQUIRED)
    public void execute(final InventoryEntity entity) {
        providerSaveInventory.process(entity);
    }
}
