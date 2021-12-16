package com.estoke.core.produto.domain;

import com.estoke.core.fornecedor.domain.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author vitor.alves
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUTO")
@SequenceGenerator(name = "SEQ_PROD", sequenceName = "SEQ_PROD")
public class Produto {

    @Id
    @GeneratedValue(generator = "SEQ_PROD")
    @Column(name = "COD_PROD")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DESC")
    private String descricao;

    @Column(name = "IMG")
    @Lob
    private String imagem;

    @Column(name = "CAT")
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "COD_FORN", nullable = false)
    private Fornecedor fornecedor;
}
