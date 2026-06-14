package com.inventory.smart.service;

import com.inventory.smart.model.Producto;
import java.util.List;

public interface AlertaService {

    List<Producto> obtenerProductosEnAlerta();
}