package com.example.demo.controllers;

import com.example.demo.models.DepartamentoModel;
import com.example.demo.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> listarDepartamentos() {
        List<DepartamentoModel> lista = departamentoService.listarDepartamentos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> buscarDepartamento(@PathVariable Long id) {
        return departamentoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamento) {
        DepartamentoModel novo = departamentoService.criarDepartamento(departamento);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id) {
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> atualizarDepartamento(@PathVariable Long id, @RequestBody DepartamentoModel departamentoModel) {
        DepartamentoModel atualizado = departamentoService.atualizarDepartamento(id, departamentoModel);
        return ResponseEntity.ok().body(atualizado);
    }
}