package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Conductor;
import com.example.demo.Model.TipoViaje;
import com.example.demo.Model.Viaje;
import com.example.demo.Service.ConductorService;
import com.example.demo.Service.ViajeService;

@Controller
@RequestMapping("/viajes")
public class ViajeController {

    private final ViajeService viajeService;
    private final ConductorService conductorService;

    public ViajeController (ViajeService viajeService, ConductorService conductorService) {
        this.viajeService = viajeService;
        this.conductorService = conductorService;
    }

    //MUESTRA EL FORM CON EL CONDUCTOR QUE SE ELIGIO
    @GetMapping("/formReserva/{idConductor}")
    public String mostrarFormulario(@PathVariable("idConductor") Integer idConductor, Model model) {
        Conductor conductor = conductorService.obtenerUnConductorPorId(idConductor);
        if (conductor == null) {
            return "redirect:/conductores?error=ConductorNoEncontrado";
        }
        model.addAttribute("tiposViaje", TipoViaje.values());
        model.addAttribute("conductor", conductor);
        return "solicitarViaje";
    }


    //iMPRIME Y MUESTRA EL RESUMEN DEL VIAJE
    @PostMapping("/confirmarViaje")
    public String confirmarViaje (@RequestParam("tipoViaje") TipoViaje tipoViaje, 
    @RequestParam("nombreCliente") String nombreCliente, @RequestParam("telefonoCliente") String telefonoCliente, 
    @RequestParam("puntoPartida") String puntoPartida, @RequestParam("destino") String destino, 
    @RequestParam("conductorId") Integer conductorId, Model model) {

        Conductor conductor = conductorService.obtenerUnConductorPorId(conductorId);
        if (conductor == null) {
            return "redirect:/conductores?error=ConductorNoEncontrado";
        }
        Viaje nuevoViaje = new Viaje(tipoViaje, conductorId, nombreCliente, telefonoCliente, puntoPartida, destino, conductor);
        viajeService.guardarViaje(nuevoViaje);

        model.addAttribute("viaje", nuevoViaje);
        return "resumenViaje";
            //(TipoViaje, nombreCliente, telefonoCliente, puntoPartida, destino, conductorId);
    }
}
