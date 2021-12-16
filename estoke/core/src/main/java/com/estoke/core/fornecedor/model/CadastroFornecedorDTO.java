package com.estoke.core.fornecedor.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author vitor.alves
 */
@Data
@Builder
public class CadastroFornecedorDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String nomeFantasia;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String txtApresentacao;

    private String fraseImpacto;

    @NotBlank
    private String contatoFabrica;

    @NotBlank
    private String endereco;

    @NotBlank
    private String email;

    @NotBlank
    private String numContato;

    private String site;
}
