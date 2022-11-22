package com.americo.org.doacoes.repository;


import com.americo.org.doacoes.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//Criar repositório onde possa abstrair todos os acessos a dados
//camada de acesso a dados
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

