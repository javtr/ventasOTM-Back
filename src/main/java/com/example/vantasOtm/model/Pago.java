package com.example.vantasOtm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private String fechaCompra;

    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private String fechaPago;

    private double valorPago;
    private double valorFee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medioPago_id")
    private MedioPago medioPago;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoPago_id")
    private TipoPago tipoPago;


    @ManyToMany
    @JoinTable(
            name = "pagoProducto",
            joinColumns = @JoinColumn(name = "pago_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    Set<Producto> productosPago;



    public Pago() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorFee() {
        return valorFee;
    }

    public void setValorFee(double valorFee) {
        this.valorFee = valorFee;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Set<Producto> getProductosPago() {
        return productosPago;
    }

    public void setProductosPago(Set<Producto> productosPago) {
        this.productosPago = productosPago;
    }
}
