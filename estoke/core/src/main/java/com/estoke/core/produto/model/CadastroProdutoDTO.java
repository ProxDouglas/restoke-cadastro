package com.estoke.core.produto.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author vitor.alves
 */
@Data
public class CadastroProdutoDTO {

    @NotBlank
    private String nome;

    private String descricao;

    private String categoria;

    private String imagem;

    private Long fornecedor;
}
