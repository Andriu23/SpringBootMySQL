package com.interrapidisimo.sistema_logistico.service;


import com.interrapidisimo.sistema_logistico.model.Conductor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConductorServiceMemoryImp implements ConductorService{

    private final List<Conductor> conductores = new ArrayList<>();

    public ConductorServiceMemoryImp() {
        conductores.add(new Conductor(UUID.randomUUID().toString(), "Luis", "Villada", "LC-001", "3002345678", "Villada123"));
        conductores.add(new Conductor(UUID.randomUUID().toString(), "Natalia", "Guzman", "LC-002", "30087645312", "Natalia999"));
        conductores.add(new Conductor(UUID.randomUUID().toString(), "Paula", "Parra", "LC-003", "3002225555", "Paula222"));
        conductores.add(new Conductor(UUID.randomUUID().toString(), "Andrés", "Satoba", "LC-004", "3213456978", "Andres012"));
    }

    @Override
    public List<Conductor> findAll() {
        return new ArrayList<>(conductores);
    }

    @Override
    public Conductor findById(String id) {
        Optional<Conductor> conductor = conductores.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        return conductor.orElse(null);
    }

    @Override
    public Conductor save(Conductor conductor) {
        if (conductor.getId() == null || conductor.getId().isEmpty()) {
            conductor.setId(UUID.randomUUID().toString());
        }
        conductores.add(conductor);
        return conductor;
    }

    @Override
    public Conductor update(String id, Conductor conductorActualizado) {
        for (int i = 0; i < conductores.size(); i++) {
            if (conductores.get(i).getId().equals(id)) {
                conductorActualizado.setId(id);
                conductores.set(i, conductorActualizado);
                return conductorActualizado;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        conductores.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public List<Conductor> findByLicencia(String licencia) {
        return conductores.stream()
                .filter(c -> c.getLicencia().equalsIgnoreCase(licencia))
                .toList();
    }
}