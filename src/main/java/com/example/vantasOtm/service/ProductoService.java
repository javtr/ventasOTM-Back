package com.example.vantasOtm.service;

import com.example.vantasOtm.model.Pago;
import com.example.vantasOtm.model.Producto;

import java.util.List;

public interface ProductoService {

    public Producto saveProducto(Producto producto);
    public Producto getProducto(Integer id);
    public List<Producto> getAllProducto();
    public void deleteProducto(Integer id);

}
