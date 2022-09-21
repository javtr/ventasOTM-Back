package com.example.vantasOtm.service;

import com.example.vantasOtm.model.MedioPago;
import com.example.vantasOtm.repository.MedioPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedioPagoServiceImp implements MedioPagoService {

    @Autowired
    private MedioPagoRepository medioPagoRepository;

    @Override
    public MedioPago saveMedioPago(MedioPago medioPago) {
        return medioPagoRepository.save(medioPago);
    }

    @Override
    public MedioPago getMedioPago(Integer id) {
        return medioPagoRepository.findById(id).get();
    }

    @Override
    public List<MedioPago> getAllMedioPago() {
        return medioPagoRepository.findAll();
    }

    @Override
    public void deleteMedioPago(Integer id) {
        medioPagoRepository.deleteById(id);
    }
}
