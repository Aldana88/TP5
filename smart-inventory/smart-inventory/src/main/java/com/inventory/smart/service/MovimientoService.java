package com.inventory.smart.service;

import com.inventory.smart.model.MovimientoInventario;
import java.util.List;

public interface MovimientoService {

    MovimientoInventario registrarMovimiento(MovimientoInventario movimiento);

    List<MovimientoInventario> findAll();

    MovimientoInventario findById(Long id);
}