package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Conductor;
import java.util.List;

public interface ConductorRepository extends JpaRepository<Conductor, Integer> {
    List<Conductor> findByEstadoTrue();
}