package com.example.vantasOtm.controller;

import com.example.vantasOtm.exception.RequestException;
import com.example.vantasOtm.model.Pago;
import com.example.vantasOtm.model.Producto;
import com.example.vantasOtm.repository.PagoRepository;
import com.example.vantasOtm.repository.ProductoRepository;
import com.example.vantasOtm.service.PagoService;
import com.example.vantasOtm.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@CrossOrigin
public class PagosController {

    @Autowired
    private PagoService pagoService;

    @Autowired
    private PagoRepository pagoRepository;


    @PostMapping("/save")
        public ResponseEntity<Pago> add(@RequestBody Pago pago){
        ResponseEntity<Pago> response;

        //comprobar si se envian los datos necesarios
        if(pago.getFechaCompra().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"fecha compra faltante");
        }else if(pago.getFechaPago().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"fecha pago faltante");
        }else if(pago.getValorPago()==0){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"valor pago faltante");
        }else if(pago.getValorFee()==0){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"valor fee faltante");
        }

        //comprobar si las relaciones existen
        if(!pagoRepository.existsById(pago.getCliente().getId())){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Cliente no existe");
        }else if (!pagoRepository.existsById(pago.getMedioPago().getId())) {
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"MedioPago no existe");
        }else if (!pagoRepository.existsById(pago.getTipoPago().getId())) {
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"TipoPago no existe");
        }

        return ResponseEntity.ok(pagoService.savePago(pago)) ;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Pago> getPago(@PathVariable Integer id ){
        ResponseEntity<Pago> response;

        //comprobar si existe la entidad
        if(pagoRepository.existsById(id)){
            response = ResponseEntity.ok(pagoService.getPago(id)) ;
        }else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        return response;
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Pago>> getAllPago(){
        return ResponseEntity.ok(pagoService.getAllPago()) ;
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePago(@PathVariable Integer id ){
        ResponseEntity<String> response;

        //comprobar si existe la entidad
        if(pagoRepository.existsById(id)){
            pagoService.deletePago(id);
        }
        else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        //comprobar si se elimino la entidad
        if(!pagoRepository.existsById(id)){
            response = ResponseEntity.status(HttpStatus.OK).body("Entidad eliminada");
        }else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"La entidad no se elimino");
        }

        return response;
    }


    @PutMapping("/edit")
    public ResponseEntity<Pago> editPago(@RequestBody Pago pago ){
        ResponseEntity<Pago> response;

        //comprobar si existe la entidad
        if(!pagoRepository.existsById(pago.getId())){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        //comprobar si se envian los datos necesarios
        if(pago.getFechaCompra().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"fecha compra faltante");
        } else if(pago.getFechaPago().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"fecha pago faltante");
        }else if(pago.getValorPago()==0){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"valor pago faltante");
        }else if(pago.getValorFee()==0){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"valor fee faltante");
        }

        return ResponseEntity.ok(pagoService.savePago(pago)) ;
    }


}
