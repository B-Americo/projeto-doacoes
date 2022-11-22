package com.americo.org.doacoes.config;

import com.americo.org.doacoes.model.entities.*;
import com.americo.org.doacoes.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private OrdemEntregaRepository ordemDoacaoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtosRepository;

    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private ItemStatusRepository itemStatusRepository;

    @Override
    public void run(String... args) throws Exception{


       /*Usuario u1 = new Usuario(null,"Flavio Arruda", "156411651", "8197898419");
     //   Usuario u2 = new Usuario( null,"Lucas Almeida", "151565161", "aceito");

        OrdemEntrega o1 = new OrdemEntrega(null, "14/11/2022", u1);
      // OrdemEntrega o2 = new OrdemEntrega(null, Instant.parse("2022-11-08T20:03:53Z"), u2);
      // OrdemEntrega o3 = new OrdemEntrega(null, Instant.parse("2022-10-08T22:04:52Z"), u2);



        Deposito d1 = new Deposito(null, "Lar Doce Lar", "TA10001", "lardocelar@email.com", "8198784");
        depositoRepository.saveAll(Arrays.asList(d1));

        ItemStatus sp1 = new ItemStatus(null, "Recebido", d1);

        itemStatusRepository.saveAll(Arrays.asList(sp1));

        usuarioRepository.saveAll(Arrays.asList(u1));
        ordemDoacaoRepository.saveAll(Arrays.asList(o1));

        Categoria categoria1 = new Categoria(null,"Livros");
       // Categoria categoria2 = new Categoria(null,"Roupas");
      //  Categoria categoria3 = new Categoria(null,"Eletrodomésticos");

          Produto produtos1 = new Produto(null, "Memática", " livro matemática 1 ano", "Bom", o1, sp1);
   //     Produto produtos2 = new Produto(null, "Fogão", "condidsda", "Muito bom", o2);
    //    Produto produtos3 = new Produto(null, "Geladeira", "dadasd", "Excelente", o3);
   //     Produto produtos4 = new Produto(null, "Microondas", "dadasd", "Bom",o2);
    //    Produto produtos5 = new Produto(null, "camiseta", "azul", "Muito bom",o2);

        categoriaRepository.saveAll(Arrays.asList(categoria1));
       // produtosRepository.saveAll(Arrays.asList(produtos1));

          produtos1.getCategorias().add(categoria1);
   //     produtos2.getCategorias().add(categoria3);
   //     produtos3.getCategorias().add(categoria3);
   //     produtos4.getCategorias().add(categoria3);
   //     produtos5.getCategorias().add(categoria2);

        produtosRepository.saveAll(Arrays.asList(produtos1));*/

    }
}
