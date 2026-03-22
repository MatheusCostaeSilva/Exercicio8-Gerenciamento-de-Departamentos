package com.example.demo.controllers;

import com.example.demo.models.DepartamentoModel;
import com.example.demo.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;

    @PostMapping
    public DepartamentoModel criarDepartamento(@RequestBody DepartamentoModel departamento) {
        return departamentoService.criarDepartamento(departamento);
    }

    @GetMapping
    public List<DepartamentoModel> listarDepartamentos() {
        return departamentoService.listarDepartamentos();
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> buscarDepartamento(@PathVariable Long id) {
        return departamentoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarDepartamento(@PathVariable Long id) {
        departamentoService.deletarDepartamento(id);
    }

    @PutMapping("/{id}")
    public DepartamentoModel atualizarDepartamento(@PathVariable Long id, @RequestBody DepartamentoModel departamentoModel) {
        return departamentoService.atualizarDepartamento(id, departamentoModel);
    }
}
