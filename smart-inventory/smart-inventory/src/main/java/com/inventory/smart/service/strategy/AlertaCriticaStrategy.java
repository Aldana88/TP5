package com.inventory.smart.service.strategy;

import com.inventory.smart.model.NivelAlerta;
import org.springframework.stereotype.Component;

@Component
public class AlertaCriticaStrategy implements AlertaStrategy {

    @Override
    public NivelAlerta calcularNivel(int stock, int minimo, int critico) {

        if (stock <= critico) {
            return NivelAlerta.CRITICO;
        }

        if (stock <= minimo) {
            return NivelAlerta.BAJO;
        }

        return NivelAlerta.NORMAL;
    }
}