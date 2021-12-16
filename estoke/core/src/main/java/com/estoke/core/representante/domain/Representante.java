package com.estoke.core.representante.domain;

import com.estoke.core.utils.converter.CnpjConverter;
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
@Table(name = "REPRESENTANTE")
@SequenceGenerator(name = "SEQ_REP", sequenceName = "SEQ_REP")
public class Representante {

    @Id
    @GeneratedValue(generator = "SEQ_REP")
    @Column(name = "COD_REP")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CNPJ", nullable = false, unique = true, length = 20)
    @Convert(converter = CnpjConverter.class)
    private String cnpj;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NUM_CONT")
    private String numContato;

    @Column(name = "IMG")
    @Lob
    private String imagem;
}
