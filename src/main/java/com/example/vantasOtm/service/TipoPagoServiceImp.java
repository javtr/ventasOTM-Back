package com.example.vantasOtm.service;

import com.example.vantasOtm.model.TipoPago;
import com.example.vantasOtm.repository.TipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TipoPagoServiceImp implements TipoPagoService{

    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    @Override
    public TipoPago saveTipoPago(TipoPago pago) {
        return tipoPagoRepository.save(pago);
    }

    @Override
    public TipoPago getTipoPago(Integer id) {
        return tipoPagoRepository.findById(id).get();
    }

    @Override
    public List<TipoPago> getAllTipoPago() {
        return tipoPagoRepository.findAll();
    }

    @Override
    public void deleteTipoPago(Integer id) {
        tipoPagoRepository.deleteById(id);
    }
}
