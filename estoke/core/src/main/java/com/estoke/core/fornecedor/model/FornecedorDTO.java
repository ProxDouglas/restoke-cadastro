package com.estoke.core.fornecedor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author vitor.alves
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorDTO {

    private Long id;

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
