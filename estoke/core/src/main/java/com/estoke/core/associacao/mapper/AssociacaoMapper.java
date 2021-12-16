package com.estoke.core.associacao.mapper;

import com.estoke.core.associacao.domain.AssociacaoFornecedorRepresentante;
import com.estoke.core.associacao.model.AssociacaoDTO;
import com.estoke.core.associacao.model.CadastroAssociacaoModel;
import com.estoke.core.fornecedor.domain.Fornecedor;
import com.estoke.core.fornecedor.mapping.FornecedorMapper;
import com.estoke.core.fornecedor.repo.FornecedorRepository;
import com.estoke.core.representante.domain.Representante;
import com.estoke.core.representante.mapping.RepresentanteMapper;
import com.estoke.core.representante.repo.RepresentanteRepository;
import com.estoke.core.tec.exception.BusinessException;
import com.estoke.core.tec.message.MessageHolderImpl;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author vitor.alves
 */
@Mapper(componentModel = "spring")
public abstract class AssociacaoMapper {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private RepresentanteRepository representanteRepository;
    @Autowired
    protected FornecedorMapper fornecedorMapper;
    @Autowired
    protected RepresentanteMapper representanteMapper;

    @Mapping(target = "fornecedor", expression = "java(findFornecedor(model.getIdFornecedor()))")
    @Mapping(target = "representante", expression = "java(findRepresentante(model.getIdRepresentante()))")
    public abstract AssociacaoFornecedorRepresentante create(CadastroAssociacaoModel model);

    @Mapping(target = "id")
    @Mapping(target = "fornecedor", expression = "java(fornecedorMapper.toModel(entity.getFornecedor()))")
    @Mapping(target = "representante", expression = "java(representanteMapper.toModel(entity.getRepresentante()))")
    public abstract AssociacaoDTO toModel(AssociacaoFornecedorRepresentante entity);

    public abstract List<AssociacaoDTO> map(List<AssociacaoFornecedorRepresentante> entities);

    protected Representante findRepresentante(Long id) {
        return representanteRepository.findById(id).orElseThrow(() -> new BusinessException(new MessageHolderImpl("Erro ao criar associacao.")));
    }

    protected Fornecedor findFornecedor(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(() -> new BusinessException(new MessageHolderImpl("Erro ao criar associacao.")));
    }
}
