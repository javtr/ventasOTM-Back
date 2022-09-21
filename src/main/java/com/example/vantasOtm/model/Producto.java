package com.example.vantasOtm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private double precio;

    @JsonIgnore
    @ManyToMany(mappedBy = "productosCliente")
    private Set<Cliente> clientesProducto;


    @JsonIgnore
    @ManyToMany(mappedBy = "productosPago")
    private Set<Pago> pagosProducto;



    public Producto() {
    }
}
