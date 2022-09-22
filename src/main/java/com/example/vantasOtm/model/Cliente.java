package com.example.vantasOtm.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String correo;

    @ManyToMany
    @JoinTable(
            name = "compra",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    Set<Producto> productosCliente;


    public Cliente() {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Set<Producto> getProductosCliente() {
        return productosCliente;
    }

    public void setProductosCliente(Set<Producto> productosCliente) {
        this.productosCliente = productosCliente;
    }
}
