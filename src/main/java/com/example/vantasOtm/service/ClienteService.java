package com.example.vantasOtm.service;

import com.example.vantasOtm.model.Cliente;

import java.util.List;

public interface ClienteService {

    public Cliente saveCliente(Cliente cliente);
    public Cliente getCliente(Integer id);
    public List<Cliente> getAllClientes();
    public void deleteClientes(Integer id);

}
