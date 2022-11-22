package com.americo.org.doacoes.repository;


import com.americo.org.doacoes.model.entities.Categoria;
import com.americo.org.doacoes.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

