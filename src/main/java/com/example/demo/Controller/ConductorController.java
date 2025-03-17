package com.example.demo.Controller;

import com.example.demo.Model.Conductor;
import com.example.demo.Service.ConductorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    public ConductorController (ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    //Mostrar lista de conductores activos
    @GetMapping
    public String listarConductores (Model model) {
        List<Conductor> conductores = conductorService.listarConductores();
        model.addAttribute("conductores", conductores);
        return "index"; //Vista html
    }

    //Mostrar formulario de registro
    @GetMapping("/nuevo")
    public String mostrarFormRegistro (Model model) {
        model.addAttribute("conductor", new Conductor());
        return "/formConductor"; //Vista html para crear un conductor
    }

    //guardar nuevo conductor
    @PostMapping("/guardar")
    public String registrarConductor (@ModelAttribute Conductor conductor) {
        conductorService.crearConductor(conductor);
        return "redirect:/conductores"; //redirige a la lista
    }

    //Eliminar (desactivar) un conductor 
    @PostMapping("/eliminar/{id}")
    public String eliminarConductor (@PathVariable Integer id) {
        conductorService.eliminarConductor(id); //se desactiva estado = false
        return "redirect:/conductores"; //redirige la lista
    }

    public String mostrarDetallesConductor (@PathVariable Integer id, Model model) {
        //llamamos al servicio para obtener el conductor
        Conductor conductor = conductorService.obtenerUnConductorPorId(id);

        if (conductor == null) {
            return "redirect:/conductores"; //si no existe, vuelve a la lista
        }

        Integer edad = Period.between(conductor.getFechaNacimiento(), LocalDate.now()).getYears();
        model.addAttribute("edad", edad); //agrega la edad calculada

        model.addAttribute("conductor", conductor);
        return "detalleConductor"; //vista de detalle


    }


}
