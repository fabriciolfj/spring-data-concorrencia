package com.github.fabriciolfj.inventaryserviceimperativo.provider.repository;

import com.github.fabriciolfj.inventaryserviceimperativo.provider.repository.data.InventoryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryData, Long> {

    Optional<InventoryData> findFirstByProductOrderByDateRegistrationDesc(final String code);

}
