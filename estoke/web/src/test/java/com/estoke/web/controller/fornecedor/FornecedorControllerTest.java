package com.estoke.web.controller.fornecedor;

import com.estoke.core.fornecedor.model.CadastroFornecedorDTO;
import com.estoke.core.fornecedor.model.FornecedorDTO;
import com.estoke.core.fornecedor.service.FornecedorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FornecedorController.class)
public class FornecedorControllerTest {

    @MockBean
    private FornecedorService fornecedorService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cadastrar() throws Exception {
        FornecedorDTO fornecedorDTOReturn = FornecedorDTO.builder()
                .id(1L)
                .cnpj("cnpj")
                .nomeFantasia("Teste")
                .build();
        Mockito.when(fornecedorService.cadastrar(any())).thenReturn(fornecedorDTOReturn);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/internal/v1/fornecedores")
                .content(asJsonString(CadastroFornecedorDTO.builder()
                        .cnpj("cnpj")
                        .nomeFantasia("Teste")
                        .build()))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.cnpj").value(fornecedorDTOReturn.getCnpj()))
                .andExpect(jsonPath("$.nome").value(fornecedorDTOReturn.getNomeFantasia()));
    }

    @Test
    public void cadastrarCnpjNull() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/internal/v1/fornecedores")
                .content(asJsonString(CadastroFornecedorDTO.builder()
                        .nomeFantasia("Teste")
                        .build()))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void findAll() throws Exception {
        Mockito.when(fornecedorService.findAll()).thenReturn(asList(FornecedorDTO.builder()
                        .id(1L)
                        .cnpj("cnpj")
                        .nomeFantasia("Teste")
                        .build(),
                FornecedorDTO.builder()
                        .id(2L)
                        .cnpj("cnpj2")
                        .nomeFantasia("Teste2")
                        .build()));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/internal/v1/fornecedores")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cnpj").exists())
                .andExpect(jsonPath("$[0].cnpj").isNotEmpty())
                .andExpect(jsonPath("$[1].cnpj").exists())
                .andExpect(jsonPath("$[1].cnpj").isNotEmpty());
    }

    @SneakyThrows
    private String asJsonString(CadastroFornecedorDTO fornecedorDTOPost) {
        return new ObjectMapper().writeValueAsString(fornecedorDTOPost);
    }

}
