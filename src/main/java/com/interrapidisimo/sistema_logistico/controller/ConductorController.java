/*
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
    public Conductor GetConductoresById(@PathVariable String id) {
        return conductorService.findById(id);
    }

    @PostMapping
    public Conductor CreateConductor(@RequestBody Conductor conductor) {
        return conductorService.save(conductor);
    }

    @PutMapping("/{id}")
    public Conductor updateConductor(@PathVariable String id, @RequestBody Conductor conductor) {
        return conductorService.update(id, conductor);
    }

    @DeleteMapping("/{id}")
    public void deleteConductor(@PathVariable String id) {
        conductorService.deleteById(id);
    }
}
 */