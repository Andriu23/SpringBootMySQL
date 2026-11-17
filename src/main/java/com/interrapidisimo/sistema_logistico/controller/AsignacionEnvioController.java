package com.interrapidisimo.sistema_logistico.controller;

import com.interrapidisimo.sistema_logistico.model.AsignacionEnvio;
import com.interrapidisimo.sistema_logistico.service.AsignacionEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionEnvioController {

    private final AsignacionEnvioService asignacionEnvioService;

    @Autowired
    public AsignacionEnvioController(AsignacionEnvioService asignacionEnvioService) {
        this.asignacionEnvioService = asignacionEnvioService;
    }

    @GetMapping
    public List<AsignacionEnvio> getAllAsignaciones() {
        return asignacionEnvioService.findAll();
    }

    @GetMapping("/{id}")
    public AsignacionEnvio getAsignacionById(@PathVariable Long id) {
        return asignacionEnvioService.findById(id);
    }

    @GetMapping("/envio/{envioId}")
    public List<AsignacionEnvio> getAsignacionesByEnvio(
            @PathVariable Long envioId) {
        return asignacionEnvioService.findByEnvioId(envioId);
    }

    @GetMapping("/conductor/{conductorId}")
    public List<AsignacionEnvio> getAsignacionesByConductor(
            @PathVariable Long conductorId) {
        return asignacionEnvioService.findByConductorId(conductorId);
    }

    @PostMapping
    public AsignacionEnvio createAsignacion(
            @RequestParam Long envioId,
            @RequestParam Long conductorId,
            @RequestParam String responsable,
            @RequestParam(required = false) String observaciones) {

        return asignacionEnvioService.save(
                envioId,
                conductorId,
                responsable,
                observaciones
        );
    }

    @PutMapping("/{id}")
    public AsignacionEnvio updateAsignacion(
            @PathVariable Long id,
            @RequestParam String responsable,
            @RequestParam(required = false) String observaciones) {

        return asignacionEnvioService.update(
                id,
                responsable,
                observaciones
        );
    }

    @DeleteMapping("/{id}")
    public void deleteAsignacion(@PathVariable Long id) {
        asignacionEnvioService.deleteById(id);
    }
}
