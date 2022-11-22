package com.americo.org.doacoes.controllers;

import com.americo.org.doacoes.model.entities.Usuario;
import com.americo.org.doacoes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public @ResponseBody Usuario novoCadastro(Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
            Logger.info("salvo no bd corretamente!");
            return usuario;
        } catch (Exception e) {
            Logger.error("Erro no cadastro!" + e);
            return null;
        }
    }

    @GetMapping
    public Iterable<Usuario> consultarTodos() {
        try {
            Logger.info("Consulta de todos os cadastros no bd realizada corretamente");
            return usuarioRepository.findAll();
        }catch (Exception e) {
            Logger.error("Erro: " + e);
            return null;
        }

    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> consultarPorId(@PathVariable Long id) {
        try {
            Logger.info("Consulta por id realizada com sucesso");
            return usuarioRepository.findById(id);
        }catch (Exception e){
            Logger.error("Erro: " + e);
            return null;
        }

    }

    @PutMapping
    public @ResponseBody Usuario alterar(Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
            Logger.info("Update realizado no bd corretamente!");
            return usuario;
        }catch (Exception e){
            Logger.error("Erro no update!" + e);
            return null;
        }
    }
    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id){
        try {
            usuarioRepository.deleteById(id);
            Logger.info("deletado corretamente");
        }catch (Exception e){
            Logger.info("Erro ao deletar" + e);
        }

    }
}
