package com.example.demo.service;

import com.example.demo.model.Articulo;
import com.example.demo.repository.ArticuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticuloService {
    private final ArticuloRepository articuloRepository;

    public List<Articulo> findAll() {
        return articuloRepository.findAll();
    }

    public Optional<Articulo> findById(Long id) {
        return articuloRepository.findById(id);
    }

    public Articulo save(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    public void deleteById(Long id) {
        articuloRepository.deleteById(id);
    }
}
