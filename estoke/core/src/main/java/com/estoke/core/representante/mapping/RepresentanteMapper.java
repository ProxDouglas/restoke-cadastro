package com.estoke.core.representante.mapping;

import com.estoke.core.representante.domain.Representante;
import com.estoke.core.representante.model.CadastroRepresentanteDTO;
import com.estoke.core.representante.model.RepresentanteDTO;
import com.estoke.core.representante.model.RepresentanteStub;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @author vitor.alves
 */
@Mapper(componentModel = "spring")
public interface RepresentanteMapper {

    RepresentanteDTO toModel(Representante representante);

    Representante toEntity(CadastroRepresentanteDTO fornecedorDTO);

    List<RepresentanteDTO> map(List<Representante> fornecedors);

    List<RepresentanteStub> mapStub(List<Representante> allById);

    RepresentanteStub toStub(Representante entity);
}
