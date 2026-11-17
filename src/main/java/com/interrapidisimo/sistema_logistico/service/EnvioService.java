package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.AsignacionEnvio;
import com.interrapidisimo.sistema_logistico.model.Envio;

import java.time.LocalDate;
import java.util.List;

public interface EnvioService {

    List<Envio> findAll();
    Envio findById(Long id);
    Envio save(Envio envio);
    Envio update(Long id, Envio envio);
    void deleteById(Long id);
    List<Envio> findByEstado(String estado);

    AsignacionEnvio asignarConductorAEnvio(
            Long envioId,
            Long conductorId,
            //LocalDate fechaAsignacion, No se debe pedir porque el service la genera
            String responsable,
            String observaciones
    );
}
