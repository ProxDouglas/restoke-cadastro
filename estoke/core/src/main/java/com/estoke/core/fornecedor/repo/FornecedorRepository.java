package com.estoke.core.fornecedor.repo;

import com.estoke.core.fornecedor.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vitor.alves
 */
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
