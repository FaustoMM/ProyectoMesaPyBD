package com.example.demo.Model;

import jakarta.persistence.*;


@Entity
public class Viaje {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoViaje tipo;

    @Column
    private double costo; 
    @Column
    private String nombreCliente;
    @Column
    private String telefonoCliente;
    @Column
    private String puntoPartida;
    @Column
    private String destino;
    @Column
    private boolean estado = true;


    @ManyToOne 
    @JoinColumn(name = "conductor_id") //unir columna y trae id conductor
    private Conductor conductor;

    //Constructor Vacio
    public Viaje(){

    }

    //Constructor con parametros
    public Viaje(TipoViaje tipo, double costo, String nombreCliente, String telefonoCliente, String puntoPartida, String destino, Conductor conductor){
        this.tipo = tipo;
        this.costo = calcularCosto(tipo, conductor);
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.puntoPartida = puntoPartida;
        this.destino = destino;
        this.conductor = conductor;
    }


    // Método para calcular el costo del viaje
    private double calcularCosto(TipoViaje tipo, Conductor conductor) {
      double precioBase = switch (tipo) {
          case CORTA -> 7000;
          case MEDIA -> 10000;
          case LARGA -> 20000;
      };
      
      double adicional = switch (conductor.getTipoAutomovil()) {
          case BASE -> 0;
          case LUXE -> precioBase * 0.10;
          case PREMIUM -> precioBase * 0.20;
      };
      
      return precioBase + adicional;
  }

    //Getters and Setters
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

     public Conductor getConductor() {
      return conductor;
   }
   public void setConductor(Conductor conductor){
      this.conductor = conductor;
      this.costo = calcularCosto(this.tipo, conductor);
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

     public boolean isEstado() {
        return estado;
     }
     public void setEstado(boolean estado){
        this.estado = estado;
     }

}