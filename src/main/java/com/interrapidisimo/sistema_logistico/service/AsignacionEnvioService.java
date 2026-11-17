package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.AsignacionEnvio;

import java.util.List;

public interface AsignacionEnvioService {

    List<AsignacionEnvio> findAll();
    AsignacionEnvio findById(Long id);
    AsignacionEnvio save(
            Long envioId,
            Long conductorId,
            String responsable,
            String observaciones
    );
    AsignacionEnvio update(
            Long id,
            String responsable,
            String observaciones
    );
    void deleteById(Long id);
    List<AsignacionEnvio> findByEnvioId(Long envioId);
    List<AsignacionEnvio> findByConductorId(Long conductorId);

}
