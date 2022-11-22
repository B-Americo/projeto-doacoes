package com.americo.org.doacoes.controllers;

import com.americo.org.doacoes.model.entities.Deposito;
import com.americo.org.doacoes.model.entities.ItemStatus;
import com.americo.org.doacoes.model.entities.Usuario;
import com.americo.org.doacoes.repository.DepositoRepository;
import com.americo.org.doacoes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.Optional;

@RestController
@RequestMapping("deposito")
public class DepositoController {

    @Autowired
    private DepositoRepository depositoRepository;

    @PostMapping
    public @ResponseBody Deposito novoCadastro( Deposito deposito) {
        try {
            depositoRepository.save(deposito);
            Logger.info("salvo no bd corretamente!");
            return deposito;
        } catch (Exception e) {
            Logger.error("Erro no cadastro!" + e);
            return null;
        }
    }

    @GetMapping
    public Iterable<Deposito> consultarTodos() {
        try {
            Logger.info("Consulta de todos os cadastros no bd realizada corretamente");
            return depositoRepository.findAll();
        }catch (Exception e) {
            Logger.error("Erro: " + e);
            return null;
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<Deposito> consultarPorId(@PathVariable Long id) {
        try {
            Logger.info("Consulta por id realizada com sucesso");
            return depositoRepository.findById(id);
        }catch (Exception e){
            Logger.error("Erro: " + e);
            return null;
        }
    }

    @PutMapping
    public @ResponseBody Deposito alterar( Deposito deposito) {
        try {
            depositoRepository.save(deposito);
            Logger.info("Update realizado no bd corretamente!");
            return deposito;
        }catch (Exception e){
            Logger.error("Erro no update!" + e);
            return null;
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id){
        try {
            depositoRepository.deleteById(id);
            Logger.info("deletado corretamente");
        }catch (Exception e){
            Logger.info("Erro ao deletar" + e);
        }
    }
}