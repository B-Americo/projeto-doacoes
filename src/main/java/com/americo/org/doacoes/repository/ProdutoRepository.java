package com.americo.org.doacoes.repository;


import com.americo.org.doacoes.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

