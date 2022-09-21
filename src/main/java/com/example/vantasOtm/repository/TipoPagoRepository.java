package com.example.vantasOtm.repository;

import com.example.vantasOtm.model.MedioPago;
import com.example.vantasOtm.model.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPagoRepository  extends JpaRepository<TipoPago,Integer> {
}
