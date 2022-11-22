package com.americo.org.doacoes.repository;

import com.americo.org.doacoes.model.entities.Deposito;
import com.americo.org.doacoes.model.entities.OrdemEntrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoRepository extends JpaRepository<Deposito, Long> {

}

