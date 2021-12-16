package com.estoke.core.representante.service;

import com.estoke.core.representante.domain.Representante;
import com.estoke.core.representante.mapping.RepresentanteMapper;
import com.estoke.core.representante.model.CadastroRepresentanteDTO;
import com.estoke.core.representante.model.RepresentanteDTO;
import com.estoke.core.representante.model.RepresentanteStub;
import com.estoke.core.representante.repo.RepresentanteRepository;
import com.estoke.core.tec.exception.BusinessException;
import com.estoke.core.tec.message.MessageHolderImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author vitor.alves
 */
@Service
@RequiredArgsConstructor
public class RepresentanteService {

    private final RepresentanteRepository repository;
    private final RepresentanteMapper mapper;

    @Transactional
    public RepresentanteDTO cadastrar(CadastroRepresentanteDTO fornecedorDTO) {
        return mapper.toModel(repository.save(mapper.toEntity(fornecedorDTO)));
    }

    public RepresentanteDTO findById(Long id) {
        return repository.findById(id).map(mapper::toModel)
            .orElseThrow(() -> new BusinessException(new MessageHolderImpl(String.format("Nao existe representante com o id: %s", id))));
    }

    @Transactional(readOnly = true)
    public List<RepresentanteDTO> findAll() {
        return mapper.map(repository.findAll());
    }

    public RepresentanteStub findStubById(Long id) {
        return mapper.toStub(repository.findById(id)
            .orElseThrow(() -> new BusinessException(new MessageHolderImpl(String.format("Nao existe representante com o id: %s.", id)))));
    }

    @Transactional
    public RepresentanteDTO delete(Long id) {
        Representante representante = repository.findById(id)
            .orElseThrow(() -> new BusinessException(new MessageHolderImpl(String.format("Nao existe representante com o id: %s.", id))));
        repository.delete(representante);
        return mapper.toModel(representante);
    }
}
