package com.example.vantasOtm.service;

import com.example.vantasOtm.model.Pago;
import com.example.vantasOtm.model.TipoPago;

import java.util.List;

public interface TipoPagoService {

    public TipoPago saveTipoPago(TipoPago pago);
    public TipoPago getTipoPago(Integer id);
    public List<TipoPago> getAllTipoPago();
    public void deleteTipoPago(Integer id);

}
