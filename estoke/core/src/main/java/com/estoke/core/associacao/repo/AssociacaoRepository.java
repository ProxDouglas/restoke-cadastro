package com.estoke.core.associacao.repo;

import com.estoke.core.associacao.domain.AssociacaoFornecedorRepresentante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author vitor.alves
 */
public interface AssociacaoRepository extends JpaRepository<AssociacaoFornecedorRepresentante, Long> {

}
