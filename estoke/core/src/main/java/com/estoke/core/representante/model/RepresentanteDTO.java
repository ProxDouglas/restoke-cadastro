package com.estoke.core.representante.model;

import lombok.Data;

/**
 * @author vitor.alves
 */
@Data
public class RepresentanteDTO {

    private Long id;

    private String nome;

    private String cnpj;

    private String email;

    private String numContato;

    private String imagem;
}
