package com.americo.org.doacoes.controllers;

import com.americo.org.doacoes.model.entities.Produto;
import com.americo.org.doacoes.model.entities.Usuario;
import com.americo.org.doacoes.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;


    @PostMapping
    public @ResponseBody Produto novoCadastro(Produto produto) {
        try {
            produtoRepository.save(produto);
            Logger.info("salvo no bd corretamente!");
            return produto;
        } catch (Exception e) {
            Logger.error("Erro no cadastro!" + e);
            return null;
        }
    }

    @GetMapping
    public Iterable<Produto> consultarTodos() {
        try {
            Logger.info("Consulta de todos os cadastros no bd realizada corretamente");
            return produtoRepository.findAll();
        }catch (Exception e) {
            Logger.error("Erro: " + e);
            return null;
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> consultarPorId(@PathVariable Long id) {
        try {
            Logger.info("Consulta por id realizada com sucesso");
            return produtoRepository.findById(id);
        }catch (Exception e){
            Logger.error("Erro: " + e);
            return null;
        }
    }

    @PutMapping
    public @ResponseBody Produto alterar( Produto produto) {
        try {
            produtoRepository.save(produto);
            Logger.info("Update realizado no bd corretamente!");
            return produto;
        }catch (Exception e){
            Logger.error("Erro no update!" + e);
            return null;
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id){
        try {
            produtoRepository.deleteById(id);
            Logger.info("deletado corretamente");
        }catch (Exception e){
            Logger.info("Erro ao deletar" + e);
        }
    }
}