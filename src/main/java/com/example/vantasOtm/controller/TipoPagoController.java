package com.example.vantasOtm.controller;

import com.example.vantasOtm.exception.RequestException;
import com.example.vantasOtm.model.MedioPago;
import com.example.vantasOtm.model.TipoPago;
import com.example.vantasOtm.repository.MedioPagoRepository;
import com.example.vantasOtm.repository.TipoPagoRepository;
import com.example.vantasOtm.service.MedioPagoService;
import com.example.vantasOtm.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-pago")
@CrossOrigin
public class TipoPagoController {

    @Autowired
    private TipoPagoService tipoPagoService;

    @Autowired
    private TipoPagoRepository tipoPagoRepository;


    @PostMapping("/save")
        public ResponseEntity<TipoPago> add(@RequestBody TipoPago tipoPago){
        ResponseEntity<TipoPago> response;

        //comprobar si se envian los datos necesarios
        if(tipoPago.getTipoPago().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"TipoPago faltante");
        }else {
            response = ResponseEntity.ok(tipoPagoService.saveTipoPago(tipoPago)) ;
        }

        return response;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<TipoPago> getTipoPago(@PathVariable Integer id ){
        ResponseEntity<TipoPago> response;

        //comprobar si existe la entidad
        if(tipoPagoRepository.existsById(id)){
            response = ResponseEntity.ok(tipoPagoService.getTipoPago(id)) ;
        }else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        return response;
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<TipoPago>> getAllTipoPago(){
        return ResponseEntity.ok(tipoPagoService.getAllTipoPago()) ;
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTipoPago(@PathVariable Integer id ){
        ResponseEntity<String> response;

        //comprobar si existe la entidad
        if(tipoPagoRepository.existsById(id)){
            tipoPagoService.deleteTipoPago(id);
        }
        else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        //comprobar si se elimino la entidad
        if(!tipoPagoRepository.existsById(id)){
            response = ResponseEntity.status(HttpStatus.OK).body("Entidad eliminada");
        }else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"La entidad no se elimino");
        }

        return response;
    }





    @PutMapping("/edit")
    public ResponseEntity<TipoPago> deleteTipoPago(@RequestBody TipoPago tipoPago ){
        ResponseEntity<TipoPago> response;

        //comprobar si existe la entidad
        if(!tipoPagoRepository.existsById(tipoPago.getId())){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        //comprobar si se envian los datos necesarios
        if(tipoPago.getTipoPago().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Datos faltantes");
        }

        return ResponseEntity.ok(tipoPagoService.saveTipoPago(tipoPago)) ;
    }


}
