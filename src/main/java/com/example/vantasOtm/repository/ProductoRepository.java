package com.example.vantasOtm.repository;

import com.example.vantasOtm.model.MedioPago;
import com.example.vantasOtm.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<Producto,Integer>
{
}
