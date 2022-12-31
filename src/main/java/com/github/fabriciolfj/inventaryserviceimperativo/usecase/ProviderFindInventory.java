package com.github.fabriciolfj.inventaryserviceimperativo.usecase;

import com.github.fabriciolfj.inventaryserviceimperativo.domain.InventoryEntity;

public interface ProviderFindInventory {

    InventoryEntity process(final String product);
}
