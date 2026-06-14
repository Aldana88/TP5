package com.inventory.smart.service.strategy;

import com.inventory.smart.model.NivelAlerta;

public interface AlertaStrategy {
    NivelAlerta calcularNivel(int stock, int minimo, int critico);
}