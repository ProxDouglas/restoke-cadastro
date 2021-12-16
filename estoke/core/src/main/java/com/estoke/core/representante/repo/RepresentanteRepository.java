package com.estoke.core.representante.repo;

import com.estoke.core.representante.domain.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vitor.alves
 */
@Repository
public interface RepresentanteRepository extends JpaRepository<Representante, Long>  {
}
