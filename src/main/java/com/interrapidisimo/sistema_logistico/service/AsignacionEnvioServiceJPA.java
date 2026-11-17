package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.AsignacionEnvio;
import com.interrapidisimo.sistema_logistico.model.Conductor;
import com.interrapidisimo.sistema_logistico.model.Envio;
import com.interrapidisimo.sistema_logistico.repository.AsignacionEnvioRepository;
import com.interrapidisimo.sistema_logistico.repository.ConductorRepository;
import com.interrapidisimo.sistema_logistico.repository.EnvioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AsignacionEnvioServiceJPA implements AsignacionEnvioService{

    private final AsignacionEnvioRepository asignacionEnvioRepository;
    private final EnvioRepository envioRepository;
    private final ConductorRepository conductorRepository;

    public AsignacionEnvioServiceJPA(
            AsignacionEnvioRepository asignacionEnvioRepository,
            EnvioRepository envioRepository,
            ConductorRepository conductorRepository) {
        this.asignacionEnvioRepository = asignacionEnvioRepository;
        this.envioRepository = envioRepository;
        this.conductorRepository = conductorRepository;
    }

    @Override
    public List<AsignacionEnvio> findAll() {
        return asignacionEnvioRepository.findAll();
    }

    @Override
    public AsignacionEnvio findById(Long id) {
        return asignacionEnvioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada con ID: " + id));
    }

    @Override
    @Transactional
    public AsignacionEnvio save(Long envioId, Long conductorId, String responsable, String observaciones) {
        Envio envio = envioRepository.findById(envioId)
                .orElseThrow(() -> new RuntimeException("Envío no encontrado con ID: " + envioId));

        Conductor conductor = conductorRepository.findById(conductorId)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado con ID: " + conductorId));

        AsignacionEnvio asignacion = new AsignacionEnvio(
                envio,
                conductor,
                LocalDate.now(),
                responsable,
                observaciones
        );
        return asignacionEnvioRepository.save(asignacion);
    }

    @Override
    public AsignacionEnvio update(Long id, String responsable, String observaciones) {
        AsignacionEnvio existente = asignacionEnvioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada con ID: " + id));

        existente.setResponsable(responsable);
        existente.setObservaciones(observaciones);

        return asignacionEnvioRepository.save(existente);
    }

    @Override
    public void deleteById(Long id) {
        if (!asignacionEnvioRepository.existsById(id)) {
            throw new RuntimeException("Asignación no encontrada con ID: " + id);
        }
        asignacionEnvioRepository.deleteById(id);
    }

    @Override
    public List<AsignacionEnvio> findByEnvioId(Long envioId) {
        return asignacionEnvioRepository.findByEnvio_id(envioId);
    }

    @Override
    public List<AsignacionEnvio> findByConductorId(Long conductorId) {
        return asignacionEnvioRepository.findByConductor_id(conductorId);
    }
}
