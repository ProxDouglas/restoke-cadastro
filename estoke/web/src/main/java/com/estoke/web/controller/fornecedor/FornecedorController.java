package com.estoke.web.controller.fornecedor;

import com.estoke.core.fornecedor.model.CadastroFornecedorDTO;
import com.estoke.core.fornecedor.model.FornecedorDTO;
import com.estoke.core.fornecedor.service.FornecedorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author vitor.alves
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/internal/v1/fornecedores")
@Validated
@AllArgsConstructor
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FornecedorDTO> cadastrar(@Valid @RequestBody CadastroFornecedorDTO fornecedorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorService.cadastrar(fornecedorDTO));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FornecedorDTO> findBy(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FornecedorDTO>> findAll() {
        return ResponseEntity.ok(fornecedorService.findAll());
    }
}
