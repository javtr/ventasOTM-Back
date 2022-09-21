package com.example.vantasOtm.repository;

import com.example.vantasOtm.model.Cliente;
import com.example.vantasOtm.model.MedioPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedioPagoRepository extends JpaRepository<MedioPago,Integer> {
}
