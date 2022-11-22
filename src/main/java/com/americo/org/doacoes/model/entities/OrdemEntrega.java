package com.americo.org.doacoes.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class OrdemEntrega implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;


    @OneToMany(mappedBy = "ordemEntregas")
    private List<Produto> produtosEntrega = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;

    public OrdemEntrega() {
    }

    public OrdemEntrega(Long id, String data, Usuario user) {

        this.id = id;
        this.data = data;
        this.user = user;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



    public List<Produto> getProdutosEntrega() {
        return produtosEntrega;
    }

    public void setProdutosEntrega(List<Produto> produtosEntrega) {
        this.produtosEntrega = produtosEntrega;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemEntrega that = (OrdemEntrega) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
