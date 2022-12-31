package com.github.fabriciolfj.inventaryserviceimperativo.usecase;

import com.github.fabriciolfj.inventaryserviceimperativo.domain.InventoryEntity;

public interface ProviderSaveInventory {

    void process(final InventoryEntity entity);
}
