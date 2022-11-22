package com.americo.org.doacoes.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String condicao;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "statusproducts_id")
    private ItemStatus itemStatusProdutos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ordem_entrega_id")
    private OrdemEntrega ordemEntregas; //adicionado para testes


    @ManyToMany
    @JoinTable(name = "produtos_categoria", joinColumns = @JoinColumn(name = "produtos_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, String condicao, OrdemEntrega ordemEntregas, ItemStatus itemStatusProdutos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.condicao = condicao;
        this.ordemEntregas = ordemEntregas;
        this.itemStatusProdutos = itemStatusProdutos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public OrdemEntrega getOrdemEntregas() {
        return ordemEntregas;
    }

    public void setOrdemEntregas(OrdemEntrega ordemEntregas) {
        this.ordemEntregas = ordemEntregas;
    }

    public ItemStatus getStatusProdutos() {
        return itemStatusProdutos;
    }

    public void setStatusProdutos(ItemStatus itemStatusProdutos) {
        this.itemStatusProdutos = itemStatusProdutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produtos = (Produto) o;
        return id.equals(produtos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
