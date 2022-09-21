package com.example.vantasOtm.service;
import com.example.vantasOtm.model.Pago;

import java.util.List;

public interface PagoService {

    public Pago savePago(Pago pago);
    public Pago getPago(Integer id);
    public List<Pago> getAllPago();
    public void deletePago(Integer id);

}
