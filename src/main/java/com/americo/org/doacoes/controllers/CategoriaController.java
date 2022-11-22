package com.americo.org.doacoes.controllers;

import com.americo.org.doacoes.model.entities.Categoria;
import com.americo.org.doacoes.model.entities.ItemStatus;
import com.americo.org.doacoes.model.entities.Produto;
import com.americo.org.doacoes.model.entities.Usuario;
import com.americo.org.doacoes.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;


    @PostMapping
    public ResponseEntity<Categoria> novoCadastro( Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            Logger.info("salvo no bd corretamente!");
            return ResponseEntity.ok().body(categoria);
        } catch (Exception e) {
            Logger.error("Erro no cadastro!" + e);
            return null;
        }
    }

    @GetMapping
    public Iterable<Categoria> consultarTodos() {
        try {
            Logger.info("Consulta de todos os cadastros no bd realizada corretamente");
            return categoriaRepository.findAll();
        }catch (Exception e) {
            Logger.error("Erro: " + e);
            return null;
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<Categoria> consultarPorId(@PathVariable Long id) {
        try {
            Logger.info("Consulta por id realizada com sucesso");
            return categoriaRepository.findById(id);
        }catch (Exception e){
            Logger.error("Erro: " + e);
            return null;
        }
    }

    @PutMapping
    public @ResponseBody Categoria alterar( Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            Logger.info("Update realizado no bd corretamente!");
            return categoria;
        }catch (Exception e){
            Logger.error("Erro no update!" + e);
            return null;
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id){
        try {
            categoriaRepository.deleteById(id);
            Logger.info("deletado corretamente");
        }catch (Exception e){
            Logger.info("Erro ao deletar" + e);
        }    }
}