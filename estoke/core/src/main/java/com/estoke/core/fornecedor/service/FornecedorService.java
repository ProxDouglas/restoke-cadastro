package com.estoke.core.fornecedor.service;

import com.estoke.core.fornecedor.mapping.FornecedorMapper;
import com.estoke.core.fornecedor.model.CadastroFornecedorDTO;
import com.estoke.core.fornecedor.model.FornecedorDTO;
import com.estoke.core.fornecedor.repo.FornecedorRepository;
import com.estoke.core.tec.exception.BusinessException;
import com.estoke.core.tec.message.MessageHolderImpl;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author vitor.alves
 */
@Service
@AllArgsConstructor
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;

    @Transactional
    public FornecedorDTO cadastrar(CadastroFornecedorDTO fornecedorDTO) {
        return fornecedorMapper.toModel(fornecedorRepository.save(fornecedorMapper.toEntity(fornecedorDTO)));
    }

    public FornecedorDTO findById(Long id) {
        return fornecedorRepository.findById(id).map(fornecedorMapper::toModel)
            .orElseThrow(() -> new BusinessException(new MessageHolderImpl(String.format("Nao existe fornecedor com o id: %s", id))));
    }

    @Transactional(readOnly = true)
    public List<FornecedorDTO> findAll() {
        return fornecedorMapper.map(fornecedorRepository.findAll());
    }
}
