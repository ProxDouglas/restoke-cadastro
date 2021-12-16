package com.estoke.core.produto.service;

import com.estoke.core.produto.domain.Produto;
import com.estoke.core.produto.mapping.ProdutoMapper;
import com.estoke.core.produto.model.CadastroProdutoDTO;
import com.estoke.core.produto.model.ProdutoDTO;
import com.estoke.core.produto.model.ProdutoStub;
import com.estoke.core.produto.repo.ProdutoRepository;
import com.estoke.core.tec.exception.BusinessException;
import com.estoke.core.tec.message.MessageHolderImpl;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author vitor.alves
 */
@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    @Transactional
    public ProdutoDTO cadastrar(CadastroProdutoDTO cadastroProdutoDTO) {
        return mapper.toModel(repository.save(mapper.toEntity(cadastroProdutoDTO)));
    }

    public ProdutoDTO findById(Long id) {
        return repository.findById(id)
            .map(mapper::toModel)
            .orElseThrow(() -> new BusinessException(new MessageHolderImpl(String.format("Nao existe produto com o id: %s", id))));
    }

    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAll() {
        return mapper.map(repository.findAll());
    }

    public List<ProdutoDTO> findAllByRepresentante(Long fornecedorId) {
        return repository.findAllByFornecedorId(fornecedorId).stream().map(mapper::toModel).collect(Collectors.toList());
    }

    public List<ProdutoStub> findAllStubsByIds(List<Long> ids) {
        return mapper.mapStub(repository.findAllById(ids));
    }

    @Transactional
    public ProdutoDTO delete(Long id) {
        Produto produto = repository.findById(id)
            .orElseThrow(() -> new BusinessException(new MessageHolderImpl(String.format("Nao existe produto com o id: %s", id))));
        repository.delete(produto);
        return mapper.toModel(produto);
    }
}
