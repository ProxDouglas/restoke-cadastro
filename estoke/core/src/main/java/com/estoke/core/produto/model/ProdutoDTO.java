package com.estoke.core.produto.model;

import com.estoke.core.fornecedor.model.FornecedorDTO;
import lombok.Data;

/**
 * @author vitor.alves
 */
@Data
public class ProdutoDTO {

    private Long id;

    private String nome;

    private String descricao;

    private String categoria;

    private String imagem;

    private FornecedorDTO fornecedor;
}
