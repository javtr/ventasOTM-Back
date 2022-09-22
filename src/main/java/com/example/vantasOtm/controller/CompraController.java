package com.example.vantasOtm.controller;

import com.example.vantasOtm.exception.RequestException;
import com.example.vantasOtm.model.Cliente;
import com.example.vantasOtm.model.Pago;
import com.example.vantasOtm.model.Producto;
import com.example.vantasOtm.model.TipoPago;
import com.example.vantasOtm.repository.ClienteRepository;
import com.example.vantasOtm.repository.PagoRepository;
import com.example.vantasOtm.repository.ProductoRepository;
import com.example.vantasOtm.repository.TipoPagoRepository;
import com.example.vantasOtm.service.ClienteService;
import com.example.vantasOtm.service.ProductoService;
import com.example.vantasOtm.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
@CrossOrigin
public class CompraController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProductoRepository productoRepository;



    @PutMapping("/{productoId}/compra/{clienteId}")
    public ResponseEntity<Cliente> addStudentToSubject(
            @PathVariable Integer productoId,
            @PathVariable Integer clienteId
    ) {

        //comprobar si existe la entidad
        if(!productoRepository.existsById(productoId)){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Producto no existe");
        }else if(!clienteRepository.existsById(clienteId)){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Cliente no existe");
        }

        Producto producto = productoRepository.findById(productoId).get();
        Cliente cliente = clienteRepository.findById(clienteId).get();
        cliente.productosCliente.add(producto);

        return ResponseEntity.ok(clienteRepository.save(cliente)) ;
    }

}
