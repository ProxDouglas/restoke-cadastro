package com.estoke.core.representante.model;

import lombok.Data;

/**
 * @author vitor.alves
 */
@Data
public class CadastroRepresentanteDTO {

    private String nome;

    private String cnpj;

    private String email;

    private String numContato;

    private String imagem;
}
