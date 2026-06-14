package com.inventory.smart.controller;

import com.inventory.smart.model.Producto;
import com.inventory.smart.service.AlertaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @GetMapping("/stock-bajo")
    public List<Producto> productosEnAlerta() {
        return alertaService.obtenerProductosEnAlerta();
    }
}