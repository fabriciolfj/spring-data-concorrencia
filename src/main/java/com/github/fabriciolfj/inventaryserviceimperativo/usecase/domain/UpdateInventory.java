package com.github.fabriciolfj.inventaryserviceimperativo.usecase.domain;

import com.github.fabriciolfj.inventaryserviceimperativo.domain.InventoryEntity;
import com.github.fabriciolfj.inventaryserviceimperativo.usecase.ProviderFindInventory;
import com.github.fabriciolfj.inventaryserviceimperativo.usecase.ProviderSaveInventory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateInventory {

    private final ProviderSaveInventory providerSaveInventory;
    private final ProviderFindInventory providerFindInventory;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void execute(final InventoryEntity entity) {
        var inventory = providerFindInventory.process(entity.getProduct())
                .getValidInventory();

        log.info("Inventory {}", inventory);
        providerSaveInventory.process(entity.updateBalance(inventory));
    }
}
