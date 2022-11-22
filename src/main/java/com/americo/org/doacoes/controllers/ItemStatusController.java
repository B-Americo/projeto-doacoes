package com.americo.org.doacoes.controllers;

import com.americo.org.doacoes.model.entities.ItemStatus;
import com.americo.org.doacoes.model.entities.Usuario;
import com.americo.org.doacoes.repository.ItemStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.Optional;

@RestController
@RequestMapping("statusitem")
public class ItemStatusController {

    @Autowired
    private ItemStatusRepository itemStatusRepository;

    @PostMapping
    public @ResponseBody ItemStatus novoCadastro( ItemStatus itemStatus) {
        try {
            itemStatusRepository.save(itemStatus);
            Logger.info("salvo no bd corretamente!");
            return itemStatus;
        } catch (Exception e) {
            Logger.error("Erro no cadastro!" + e);
            return null;
        }
    }

    @GetMapping
    public Iterable<ItemStatus> consultarTodos() {
        try {
            Logger.info("Consulta de todos os cadastros no bd realizada corretamente");
            return itemStatusRepository.findAll();
        }catch (Exception e) {
            Logger.error("Erro: " + e);
            return null;
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<ItemStatus> consultarPorId(@PathVariable Long id) {
        try {
            Logger.info("Consulta por id realizada com sucesso");
            return itemStatusRepository.findById(id);
        }catch (Exception e){
            Logger.error("Erro: " + e);
            return null;
        }
    }

    @PutMapping
    public @ResponseBody ItemStatus alterar( ItemStatus itemStatus) {
        try {
            itemStatusRepository.save(itemStatus);
            Logger.info("Update realizado no bd corretamente!");
            return itemStatus;
        }catch (Exception e){
            Logger.error("Erro no update!" + e);
            return null;
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id){
        try {
            itemStatusRepository.deleteById(id);
            Logger.info("deletado corretamente");
        }catch (Exception e){
            Logger.info("Erro ao deletar" + e);
        }
    }
}

