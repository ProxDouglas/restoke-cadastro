package com.estoke.core.fornecedor.service;

import com.estoke.core.fornecedor.domain.Fornecedor;
import com.estoke.core.fornecedor.mapping.FornecedorMapperImpl;
import com.estoke.core.fornecedor.model.CadastroFornecedorDTO;
import com.estoke.core.fornecedor.model.FornecedorDTO;
import com.estoke.core.fornecedor.repo.FornecedorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class FornecedorServiceTest {

    @Mock
    private FornecedorRepository fornecedorRepository;

    @Captor
    private ArgumentCaptor<Fornecedor> fornecedorArgumentCaptor;

    private FornecedorService fornecedorService;

    @Before
    public void setUp() {
        fornecedorService = new FornecedorService(fornecedorRepository, new FornecedorMapperImpl());
    }

    @Test
    public void cadastrar() {
        Fornecedor fornecedor = Fornecedor.builder()
                .id(1L)
                .cnpj("cnpj")
                .nomeFantasia("Teste")
                .build();
        Mockito.when(fornecedorRepository.save(any())).thenReturn(fornecedor);
        FornecedorDTO cadastrar = fornecedorService.cadastrar(CadastroFornecedorDTO.builder().cnpj("cnpj").nome("Teste").build());
        Mockito.verify(fornecedorRepository).save(fornecedorArgumentCaptor.capture());
        assertEquals(1L, cadastrar.getId().longValue());
        assertEquals("cnpj", cadastrar.getCnpj());
        assertEquals("Teste", cadastrar.getNomeFantasia());
    }

    @Test
    public void findAll() {
        Fornecedor fornecedor = Fornecedor.builder()
                .id(1L)
                .cnpj("cnpj")
                .nomeFantasia("Teste")
                .build();
        Fornecedor fornecedor2 = Fornecedor.builder()
                .id(2L)
                .cnpj("cnpj2")
                .nomeFantasia("Teste2")
                .build();
        Mockito.when(fornecedorRepository.findAll()).thenReturn(asList(fornecedor, fornecedor2));
        List<FornecedorDTO> all = fornecedorService.findAll();
        Mockito.verify(fornecedorRepository).findAll();
        assertEquals(2, all.size());
        FornecedorDTO cadastrar = all.get(0);
        assertEquals(1L, cadastrar.getId().longValue());
        assertEquals("cnpj", cadastrar.getCnpj());
        assertEquals("Teste", cadastrar.getNomeFantasia());
        cadastrar = all.get(1);
        assertEquals(2L, cadastrar.getId().longValue());
        assertEquals("cnpj2", cadastrar.getCnpj());
        assertEquals("Teste2", cadastrar.getNomeFantasia());
    }
}
