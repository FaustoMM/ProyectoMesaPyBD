package com.example.demo.Model;

import jakarta.persistence.*;


@Entity
public class Viaje {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoViaje tipo;

    private double costo; //en duda
    private String nombreCliente;
    private String telefonoCliente;
    private String puntoPartida;
    private String destino;
    private boolean estado = true;


    @OneToOne 
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    public Viaje(){

    }

    public Viaje(Long id, TipoViaje tipo, double costo, String nombreCliente, String telefonoCliente, String puntoPartida, String destino, boolean estado){
        this.id = id;
        this.tipo = tipo;
        this.costo = costo;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.puntoPartida = puntoPartida;
        this.destino = destino;
        this.estado = estado;
    }

    public Long getId(){
        return id;
     }
    
     public void setId(Long id){
        this.id = id;
     }

     public TipoViaje getTipo() {
        return tipo;
     }

     public void setTipo(TipoViaje tipo){
        this.tipo = tipo;
     }

     public double getCosto() {
        return costo;
     }

     public void setCosto(double costo){
        this.costo = costo;
     }

     public String getNombreCliente() {
        return nombreCliente;
     }

     public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
     }

     public String getTelefonoCliente() {
        return telefonoCliente;
     }

     public void setTelefonoCliente(String telefonoCliente){
        this.telefonoCliente = telefonoCliente;
     }

     public String getPuntoPartida() {
        return puntoPartida;
     }

     public void setPuntoPartida(String puntoPartida){
        this.puntoPartida = puntoPartida;
     }

     public String getDestino() {
        return destino;
     }

     public void setDestino(String destino){
        this.destino = destino;
     }

     public boolean getEstado() {
        return estado;
     }

     public void setEstado(boolean estado){
        this.estado = estado;
     }

}