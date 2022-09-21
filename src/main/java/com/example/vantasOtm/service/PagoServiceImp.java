package com.example.vantasOtm.service;

import com.example.vantasOtm.model.Pago;
import com.example.vantasOtm.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PagoServiceImp implements PagoService{

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public Pago savePago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago getPago(Integer id) {
        return pagoRepository.findById(id).get();
    }

    @Override
    public List<Pago> getAllPago() {
        return pagoRepository.findAll();
    }

    @Override
    public void deletePago(Integer id) {
        pagoRepository.deleteById(id);
    }
}
