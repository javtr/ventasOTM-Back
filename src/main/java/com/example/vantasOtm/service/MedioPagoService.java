package com.example.vantasOtm.service;

import com.example.vantasOtm.model.Cliente;
import com.example.vantasOtm.model.MedioPago;

import java.util.List;

public interface MedioPagoService {

    public MedioPago saveMedioPago(MedioPago medioPago);
    public MedioPago getMedioPago(Integer id);
    public List<MedioPago> getAllMedioPago();
    public void deleteMedioPago(Integer id);

}
