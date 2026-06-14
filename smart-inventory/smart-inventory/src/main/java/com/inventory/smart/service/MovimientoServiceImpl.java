package com.inventory.smart.service;

import com.inventory.smart.model.MovimientoInventario;
import com.inventory.smart.model.TipoMovimiento;
import com.inventory.smart.repository.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public MovimientoInventario registrarMovimiento(MovimientoInventario movimiento) {

        if (movimiento.getTipo() == TipoMovimiento.ENTRADA) {

            movimiento.getProducto()
                    .incrementarStock(movimiento.getCantidad());

        } else if (movimiento.getTipo() == TipoMovimiento.SALIDA) {

            if (movimiento.getProducto().getStock() < movimiento.getCantidad()) {
                throw new RuntimeException(
                        "Stock insuficiente. Disponible: "
                                + movimiento.getProducto().getStock()
                );
            }

            movimiento.getProducto()
                    .decrementarStock(movimiento.getCantidad());
        }

        return movimientoRepository.save(movimiento);
    }

    @Override
    public List<MovimientoInventario> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public MovimientoInventario findById(Long id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Movimiento no encontrado"));
    }
}