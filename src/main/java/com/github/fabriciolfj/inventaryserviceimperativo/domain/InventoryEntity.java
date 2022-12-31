package com.github.fabriciolfj.inventaryserviceimperativo.domain;


import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.InventoryNegativeException;
import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.UpdateInvalidInventoryException;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InventoryEntity {

    private static final long BALANCE_INIT = 0;

    @EqualsAndHashCode.Include
    private String code;
    private String product;
    private long quantity;
    private long balance;
    private TypeOperation typeOperation;
    private LocalDateTime registration;

    public boolean isExit() {
        return this.typeOperation.getDescription().equals(TypeOperation.EXIT.getDescription());
    }

    public boolean isEntrance() {
        return this.typeOperation.getDescription().equals(TypeOperation.ENTRANCE.getDescription());
    }

    public boolean isNegative() {
        return this.balance < BALANCE_INIT;
    }

    public InventoryEntity updateBalance(final InventoryEntity entity) {
        return process(entity.getBalance());
    }

    public InventoryEntity getValidInventory() {
        if (this.balance == BALANCE_INIT) {
            throw new UpdateInvalidInventoryException();
        }

        return this;
    }

    private InventoryEntity process(final long balance) {
        if (isExit() && balance == BALANCE_INIT) {
            throw new UpdateInvalidInventoryException();
        }

        if (isExit()) {
            return debit(balance - this.quantity);
        }

        this.balance = balance + this.quantity;

        return this;
    }

    private InventoryEntity debit(long balance) {
        this.balance = balance;

        if (this.balance <  BALANCE_INIT) {
            throw new InventoryNegativeException();
        }

        return this;
    }
}