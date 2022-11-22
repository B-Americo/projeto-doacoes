package com.americo.org.doacoes.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ItemStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String status;


    @JsonIgnore
   @OneToMany(mappedBy = "itemStatusProdutos")
   private List<Produto> produtoList = new ArrayList<>();


    @JoinColumn(name = "deposito_id")
    @ManyToOne
    private Deposito storage;


    public ItemStatus() {
    }

    public ItemStatus(Long id, String status, Deposito storage) {
        this.id = id;
        this.status = status;
        this.storage = storage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Deposito getStorage() {
        return storage;
    }

    public void setStorage(Deposito storage) {
        this.storage = storage;
    }

  public List<Produto> getProdutoList() {
       return produtoList;
   }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStatus that = (ItemStatus) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "StatusProduto{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
