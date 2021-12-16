package com.estoke.core.produto.mapping;

import com.estoke.core.fornecedor.domain.Fornecedor;
import com.estoke.core.fornecedor.mapping.FornecedorMapper;
import com.estoke.core.fornecedor.repo.FornecedorRepository;
import com.estoke.core.produto.domain.Produto;
import com.estoke.core.produto.model.CadastroProdutoDTO;
import com.estoke.core.produto.model.ProdutoDTO;
import com.estoke.core.produto.model.ProdutoStub;
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
public abstract class ProdutoMapper {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    protected FornecedorMapper fornecedorMapper;

    @Mapping(target = "fornecedor", expression = "java(fornecedorMapper.toModel(produto.getFornecedor()))")
    public abstract ProdutoDTO toModel(Produto produto);

    @Mapping(target = "fornecedor", expression = "java(this.getFornecedor(cadastroProdutoDTO))")
    public abstract Produto toEntity(CadastroProdutoDTO cadastroProdutoDTO);

    public abstract List<ProdutoDTO> map(List<Produto> produtos);

    public abstract List<ProdutoStub> mapStub(List<Produto> produtos);

    public abstract ProdutoStub toStub(Produto entity);

    protected Fornecedor getFornecedor(CadastroProdutoDTO entity) {
        return fornecedorRepository.findById(entity.getFornecedor())
            .orElseThrow(() -> new BusinessException(new MessageHolderImpl(String.format("Nao existe fornecedor com o id: %s", entity.getFornecedor()))));
    }
}
