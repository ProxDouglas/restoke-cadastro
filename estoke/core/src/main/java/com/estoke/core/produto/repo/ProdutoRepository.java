package com.estoke.core.produto.repo;

import com.estoke.core.produto.domain.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vitor.alves
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByFornecedorId(Long fornecedorId);
}
