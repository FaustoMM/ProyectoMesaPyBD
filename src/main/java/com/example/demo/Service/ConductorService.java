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
    
}

