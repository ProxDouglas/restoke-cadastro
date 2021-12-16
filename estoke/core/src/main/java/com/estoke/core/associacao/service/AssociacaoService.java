package com.estoke.core.associacao.service;

import com.estoke.core.associacao.mapper.AssociacaoMapper;
import com.estoke.core.associacao.model.AssociacaoDTO;
import com.estoke.core.associacao.model.CadastroAssociacaoModel;
import com.estoke.core.associacao.repo.AssociacaoRepository;
import com.estoke.core.tec.exception.BusinessException;
import com.estoke.core.tec.message.MessageHolderImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author vitor.alves
 */
@Service
@RequiredArgsConstructor
public class AssociacaoService {

    private final AssociacaoMapper mapper;
    private final AssociacaoRepository repository;

    public AssociacaoDTO cadastrar(CadastroAssociacaoModel cadastroAssociacaoModel) {
        return mapper.toModel(repository.save(mapper.create(cadastroAssociacaoModel)));
    }

    public AssociacaoDTO findById(Long id) {
        return repository.findById(id).map(mapper::toModel)
            .orElseThrow(() -> new BusinessException(new MessageHolderImpl(String.format("Nao existe associacao com o id: %s", id))));
    }

    public List<AssociacaoDTO> findAll() {
        return mapper.map(repository.findAll());
    }
}
