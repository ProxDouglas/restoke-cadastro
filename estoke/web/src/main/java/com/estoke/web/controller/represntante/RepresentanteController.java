package com.estoke.web.controller.represntante;

import com.estoke.core.representante.model.CadastroRepresentanteDTO;
import com.estoke.core.representante.model.RepresentanteDTO;
import com.estoke.core.representante.model.RepresentanteStub;
import com.estoke.core.representante.service.RepresentanteService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vitor.alves
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/internal/v1/represntantes")
@Validated
@AllArgsConstructor
public class RepresentanteController {

    private final RepresentanteService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RepresentanteDTO> cadastrar(@Valid @RequestBody CadastroRepresentanteDTO representanteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(representanteDTO));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RepresentanteDTO> findBy(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RepresentanteDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/stub/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RepresentanteStub> findStubById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findStubById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RepresentanteDTO> deleteBy(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
