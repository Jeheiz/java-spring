package com.example.demo.controller;

import com.example.demo.model.Articulo;
import com.example.demo.service.ArticuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articulos")
@RequiredArgsConstructor
public class ArticuloController {
    private final ArticuloService articuloService;

    @GetMapping
    public List<Articulo> getAllArticulos() {
        return articuloService.findAll();
    }

    @GetMapping("/{id}")
    public Articulo getArticuloById(@PathVariable Long id) {
        return articuloService.findById(id).orElse(null);
    }

    @PostMapping
    public Articulo createArticulo(@RequestBody Articulo articulo) {
        return articuloService.save(articulo);
    }

    @PutMapping("/{id}")
    public Articulo updateArticulo(@PathVariable Long id, @RequestBody Articulo articulo) {
        if (articuloService.findById(id).isPresent()) {
            articulo.setId(id);
            return articuloService.save(articulo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteArticulo(@PathVariable Long id) {
        articuloService.deleteById(id);
    }
}
