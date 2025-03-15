package com.example.demo.Service;

import com.example.demo.Model.Viaje;
import com.example.demo.Repository.ViajeRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

}
