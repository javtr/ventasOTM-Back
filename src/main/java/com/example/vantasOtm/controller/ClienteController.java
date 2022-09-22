package com.example.vantasOtm.controller;

import com.example.vantasOtm.exception.RequestException;
import com.example.vantasOtm.model.Cliente;
import com.example.vantasOtm.model.TipoPago;
import com.example.vantasOtm.repository.ClienteRepository;
import com.example.vantasOtm.repository.TipoPagoRepository;
import com.example.vantasOtm.service.ClienteService;
import com.example.vantasOtm.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;


    @PostMapping("/save")
        public ResponseEntity<Cliente> add(@RequestBody Cliente cliente){
        ResponseEntity<Cliente> response;

        //comprobar si se envian los datos necesarios
        if(cliente.getNombre().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"nombre faltante");
        }else if(cliente.getCorreo().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"correo faltante");
        }else {
            response = ResponseEntity.ok(clienteService.saveCliente(cliente)) ;
        }

        return response;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Integer id ){
        ResponseEntity<Cliente> response;

        //comprobar si existe la entidad
        if(clienteRepository.existsById(id)){
            response = ResponseEntity.ok(clienteService.getCliente(id)) ;
        }else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        return response;
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Cliente>> getAllCliente(){
        return ResponseEntity.ok(clienteService.getAllClientes()) ;
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Integer id ){
        ResponseEntity<String> response;

        //comprobar si existe la entidad
        if(clienteRepository.existsById(id)){
            clienteService.deleteClientes(id);
        }
        else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        //comprobar si se elimino la entidad
        if(!clienteRepository.existsById(id)){
            response = ResponseEntity.status(HttpStatus.OK).body("Entidad eliminada");
        }else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"La entidad no se elimino");
        }

        return response;
    }





    @PutMapping("/edit")
    public ResponseEntity<Cliente> deleteTipoPago(@RequestBody Cliente cliente ){
        ResponseEntity<Cliente> response;

        //comprobar si existe la entidad
        if(!clienteRepository.existsById(cliente.getId())){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        //comprobar si se envian los datos necesarios
        if(cliente.getNombre().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"nombre faltante");
        }else if(cliente.getCorreo().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"correo faltante");
        }

        return ResponseEntity.ok(clienteService.saveCliente(cliente)) ;
    }


}
