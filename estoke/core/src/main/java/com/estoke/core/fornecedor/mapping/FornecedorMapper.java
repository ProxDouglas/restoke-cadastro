package com.estoke.core.fornecedor.mapping;

import com.estoke.core.fornecedor.domain.Fornecedor;
import com.estoke.core.fornecedor.model.CadastroFornecedorDTO;
import com.estoke.core.fornecedor.model.FornecedorDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author vitor.alves
 */
@Mapper(componentModel = "spring")
public interface FornecedorMapper {

    FornecedorDTO toModel(Fornecedor fornecedor);

    Fornecedor toEntity(CadastroFornecedorDTO fornecedorDTO);

    List<FornecedorDTO> map(List<Fornecedor> fornecedors);
}
