package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Conductor;
import com.interrapidisimo.sistema_logistico.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorServiceJPA implements ConductorService{

    private final ConductorRepository conductorRepository;

    @Autowired
    public ConductorServiceJPA(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    @Override
    public List<Conductor> findAll() {
        return conductorRepository.findAll();
    }

    @Override
    public Conductor findById(Long id) {
        return conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado con ID: " + id));
    }

    @Override
    public Conductor save(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public Conductor update(Long id, Conductor conductorActualizado) {
        Conductor existente = conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado con ID: " + id));

        existente.setNombre(conductorActualizado.getNombre());
        existente.setApellido(conductorActualizado.getApellido());
        existente.setLicencia(conductorActualizado.getLicencia());
        existente.setTelefono(conductorActualizado.getTelefono());

        // Actualizar contraseña solamente si se envía una nueva
        if (conductorActualizado.getContrasena() != null
            && !conductorActualizado.getContrasena().isBlank()) {
            existente.setContrasena(conductorActualizado.getContrasena());
        }

        return conductorRepository.save(existente);
    }

    @Override
    public void deleteById(Long id) {
        if (!conductorRepository.existsById(id)) {
            throw new RuntimeException("Conductor no encontrado con ID: " + id);
        }
        conductorRepository.deleteById(id);
    }

    @Override
    public List<Conductor> findByLicencia(String licencia) {
        return conductorRepository.findByLicencia(licencia);
    }

    @Override
    public List<Conductor> findByNombreContaining(String nombre) {
        return conductorRepository.findByNombreContaining(nombre);
    }
}
