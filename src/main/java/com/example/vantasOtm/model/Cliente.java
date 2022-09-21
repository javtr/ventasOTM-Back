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


}
