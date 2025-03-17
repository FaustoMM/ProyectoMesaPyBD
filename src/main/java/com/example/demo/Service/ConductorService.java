package com.example.demo.Service;


import com.example.demo.Model.Conductor;
import com.example.demo.Repository.ConductorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;
    
    //Lista-Obtine todos los Conductores verdaderos por estado
    public List<Conductor> listarConductores() {
        return conductorRepository.findByEstadoTrue();
    }

    
    //Trae-obtiene un solo Conductor por su id
    public Conductor obtenerUnConductorPorId (Integer id) {
        if(id == null) {
            throw new IllegalArgumentException("El ID NO puede ser nulo.");
        }
        return conductorRepository.findById(id).orElse(null);
    }


     //Crea al Conductor
     public Conductor crearConductor (Conductor conductor) {
        if (conductor == null) {
            throw new IllegalArgumentException("El Conductor NO puede ser nulo.");
        }
        return conductorRepository.save(conductor);
        }

        
        //Elimina el cConductor en la vista (Pasa el Estado de True a False en BD)
        public Conductor eliminarConductor (Integer id) {
            if (id == null) {
                throw new IllegalArgumentException("El ID NO PUEDE SER NULO.");
            }
            Conductor conductor = conductorRepository.findById(id).orElse(null);
            if (conductor != null) {
                conductor.setEstado(false);
                return conductorRepository.save(conductor);
            }
            return null;
        }


}

