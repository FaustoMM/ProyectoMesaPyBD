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
    private boolean estado = true;


    @OneToOne 
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    public Viaje(){

    }

    public Viaje(Long id, TipoViaje tipo, double costo, boolean estado){
        this.id = id;
        this.tipo = tipo;
        this.costo = costo;
        this.estado = estado;
    }

    public Long getId(){
        return id;
     }
    
     public void setId(Long id){
        this.id = id;
     }

     public TipoViaje Tipo() {
        return tipo;
     }

     public void setTipo(TipoViaje tipo){
        this.tipo = tipo;
     }

     public double Costo() {
        return costo;
     }

     public void setCosto(double costo){
        this.costo = costo;
     }

     public boolean Estado() {
        return estado;
     }

     public void setEstado(boolean estado){
        this.estado = estado;
     }

}