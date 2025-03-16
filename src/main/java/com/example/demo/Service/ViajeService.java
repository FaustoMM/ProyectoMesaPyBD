package com.example.demo.Service;


import com.example.demo.Model.Viaje;
import com.example.demo.Repository.ViajeRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
//import java.util.List;


@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    //Guarda un viaje en la BD
    public Viaje guardarViaje (Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    //Busca un Viaje por id
    public Viaje obtenerUnViajePorId (Long id) {
        return viajeRepository.findById(id).orElse(null);
    }

    
}
