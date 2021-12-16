package com.estoke.web.controller.produto;

import com.estoke.core.produto.model.CadastroProdutoDTO;
import com.estoke.core.produto.model.ProdutoDTO;
import com.estoke.core.produto.model.ProdutoStub;
import com.estoke.core.produto.service.ProdutoService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vitor.alves
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/internal/v1/produtos")
@Validated
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> cadastrar(@Valid @RequestBody CadastroProdutoDTO cadastroProdutoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(cadastroProdutoDTO));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> findBy(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/fornecedor/{fornecedorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutoDTO>> findAllByFornecedor(@PathVariable Long fornecedorId) {
        return ResponseEntity.ok(service.findAllByRepresentante(fornecedorId));
    }

    @GetMapping(path = "/stubs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutoStub>> findAllByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllStubsByIds(ids));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ProdutoDTO> deleteBy(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
