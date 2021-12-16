package com.estoke.core.associacao.domain;

import com.estoke.core.fornecedor.domain.Fornecedor;
import com.estoke.core.representante.domain.Representante;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author vitor.alves
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASSC_FOR_REP")
@SequenceGenerator(name = "SEQ_ASSC", sequenceName = "SEQ_ASSC")
public class AssociacaoFornecedorRepresentante {

    @Id
    @GeneratedValue(generator = "SEQ_ASSC")
    @Column(name = "COD_ASSC")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_FORN")
    private Fornecedor fornecedor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_REP")
    private Representante representante;
}
