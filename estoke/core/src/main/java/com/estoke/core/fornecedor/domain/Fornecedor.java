package com.estoke.core.fornecedor.domain;

import com.estoke.core.produto.domain.Produto;
import com.estoke.core.utils.converter.CnpjConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author vitor.alves
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FORNECEDOR")
@SequenceGenerator(name = "SEQ_FORN", sequenceName = "SEQ_FORN")
public class Fornecedor {

    @Id
    @GeneratedValue(generator = "SEQ_FORN")
    @Column(name = "COD_FORN")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nomeFantasia;

    @Column(name = "CNPJ", nullable = false, unique = true, length = 20)
    @Convert(converter = CnpjConverter.class)
    private String cnpj;

    @Column(name = "APESENTACAO")
    private String txtApresentacao;

    @Column(name = "FRS_IMPAC")
    private String fraseImpacto;

    @Column(name = "CONT")
    private String contatoFabrica;

    @Column(name = "ENDER")
    private String endereco;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NUM_CONT")
    private String numContato;

    @Column(name = "SITE")
    private String site;

    @OneToMany(mappedBy = "fornecedor", orphanRemoval = true)
    private List<Produto> produtos;
}
