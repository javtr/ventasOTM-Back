package com.example.vantasOtm.service;

import com.example.vantasOtm.model.Cliente;
import com.example.vantasOtm.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente getCliente(Integer id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void deleteClientes(Integer id) {
        clienteRepository.deleteById(id);
    }
}
