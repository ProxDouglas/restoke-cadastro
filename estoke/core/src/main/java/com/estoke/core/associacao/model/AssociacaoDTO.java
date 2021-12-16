package com.estoke.core.associacao.model;

import com.estoke.core.fornecedor.model.FornecedorDTO;
import com.estoke.core.representante.model.RepresentanteDTO;
import lombok.Data;

/**
 * @author vitor.alves
 */
@Data
public class AssociacaoDTO {

    private Long id;
    private FornecedorDTO fornecedor;
    private RepresentanteDTO representante;

}
