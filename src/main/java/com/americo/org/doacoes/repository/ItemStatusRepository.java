package com.americo.org.doacoes.repository;

import com.americo.org.doacoes.model.entities.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemStatusRepository extends JpaRepository<ItemStatus, Long> {

}
