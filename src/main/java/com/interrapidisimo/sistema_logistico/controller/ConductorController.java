package com.interrapidisimo.sistema_logistico.controller;


import com.interrapidisimo.sistema_logistico.model.Conductor;
import com.interrapidisimo.sistema_logistico.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    @Autowired
    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @GetMapping
    public List<Conductor> getAllConductores() {
        return conductorService.findAll();
    }

    @GetMapping("/licencia/{licencia}")
    public List<Conductor> getConductoresByLicencia(@PathVariable String licencia) {
        return conductorService.findByLicencia(licencia);
    }

    @GetMapping("/{id}")
    public Conductor getConductoresById(@PathVariable Long id) {
        return conductorService.findById(id);
    }

    @PostMapping
    public Conductor createConductor(@RequestBody Conductor conductor) {
        return conductorService.save(conductor);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Conductor> getConductorByNombre(@PathVariable String nombre) {
        return conductorService.findByNombreContaining(nombre);
    }

    @PutMapping("/{id}")
    public Conductor updateConductor(@PathVariable Long id, @RequestBody Conductor conductor) {
        return conductorService.update(id, conductor);
    }

    @DeleteMapping("/{id}")
    public void deleteConductor(@PathVariable Long id) {
        conductorService.deleteById(id);
    }
}