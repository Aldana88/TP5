package com.inventory.smart.controller;

import com.inventory.smart.model.MovimientoInventario;
import com.inventory.smart.service.MovimientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping
    public List<MovimientoInventario> listar() {
        return movimientoService.findAll();
    }

    @GetMapping("/{id}")
    public MovimientoInventario buscarPorId(@PathVariable Long id) {
        return movimientoService.findById(id);
    }

    @PostMapping
    public MovimientoInventario crear(
            @RequestBody MovimientoInventario movimiento) {

        return movimientoService.registrarMovimiento(movimiento);
    }
}