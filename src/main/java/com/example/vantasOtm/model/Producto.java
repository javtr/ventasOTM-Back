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
    public Set<Cliente> clientesProducto;


    @JsonIgnore
    @ManyToMany(mappedBy = "productosPago")
    private Set<Pago> pagosProducto;



    public Producto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Set<Cliente> getClientesProducto() {
        return clientesProducto;
    }

    public void setClientesProducto(Set<Cliente> clientesProducto) {
        this.clientesProducto = clientesProducto;
    }

    public Set<Pago> getPagosProducto() {
        return pagosProducto;
    }

    public void setPagosProducto(Set<Pago> pagosProducto) {
        this.pagosProducto = pagosProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", clientesProducto=" + clientesProducto +
                ", pagosProducto=" + pagosProducto +
                '}';
    }
}

