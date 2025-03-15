package com.example.demo.Model;


import java.time.LocalDate;
import jakarta.persistence.*;


public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private LocalDate fechaNacimiento;
    @Column
    private String automovil;

    @Enumerated(EnumType.STRING) //Para Ennumerar los TIPOS DE VEHICULO
    private TipoAutomovil tipoAutomovil;

    @OneToOne(mappedBy = "conductor", cascade = CascadeType.ALL) 
    private Viaje viaje;

    @Column
    private boolean estado = true;

    //Constructor vacio
    public Conductor(){

    }

    //constructor con parametros
    public Conductor(Integer id, String nombre, String apellido, LocalDate fechaNacimiento, String automovil, TipoAutomovil tipoAutomovil, boolean estado){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.automovil = automovil;
        this.tipoAutomovil = tipoAutomovil;
        this.estado = estado;
    }
    
    //getters and setters
 public Integer getId(){
    return id;
 }
 public void setId(Integer id){
    this.id = id;
 }

 public String getNombre(){
    return nombre;
 }
 public void setNombre(String nombre){
    this.nombre = nombre;
 }

 public String getApellido(){
    return apellido;
 }
 public void setApellido(String apellido){
    this.apellido = apellido;
 }

 public LocalDate getFechaNacimiento(){
    return fechaNacimiento;
 }
 public void setFechaNacimiento(LocalDate fechaNacimiento){
    this.fechaNacimiento = fechaNacimiento;
 }

 public String getAutomovil(){
    return automovil;
 }
 public void setAutomovil(String automovil){
    this.automovil = automovil;
 }

 public TipoAutomovil getTipoAutomovil(){
    return tipoAutomovil;
 }
 public void setTipoAutomovil(TipoAutomovil tipoAutomovil){
    this.tipoAutomovil = tipoAutomovil;
 }

 public boolean getEstado(){
    return estado;
 }
 public void setEstado(boolean estado){
    this.estado = estado;
 }

}
