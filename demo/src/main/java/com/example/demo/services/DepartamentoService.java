package com.example.demo.services;

import com.example.demo.models.DepartamentoModel;
import com.example.demo.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DepartamentoService {

    public static final Logger log = Logger.getLogger(DepartamentoService.class.getName());

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoModel criarDepartamento(DepartamentoModel departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<DepartamentoModel> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoModel> buscarPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    public void deletarDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }

    public DepartamentoModel atualizarDepartamento(Long id, DepartamentoModel departamento) {
        DepartamentoModel newDepartamento = departamentoRepository.findById(id).get();
        newDepartamento.setNome(departamento.getNome());
        newDepartamento.setLocalizacao(departamento.getLocalizacao());
        return departamentoRepository.save(newDepartamento);
    }
}
