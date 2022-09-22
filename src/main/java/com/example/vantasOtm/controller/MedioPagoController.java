package com.example.vantasOtm.controller;

import com.example.vantasOtm.exception.RequestException;
import com.example.vantasOtm.model.MedioPago;
import com.example.vantasOtm.repository.MedioPagoRepository;
import com.example.vantasOtm.service.MedioPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medio-pago")
@CrossOrigin
public class MedioPagoController {


    @Autowired
    private MedioPagoService medioPagoService;

    @Autowired
    private MedioPagoRepository medioPagoRepository;


    @PostMapping("/save")
        public MedioPago add(@RequestBody MedioPago medioPago){

        //comprobar si se envian los datos necesarios
        if(medioPago.getMedioPago().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Datos faltantes");
        }

        return medioPagoService.saveMedioPago(medioPago);
    }

    @GetMapping("/{id}")
    public MedioPago getMedioPago(@PathVariable Integer id ){

        //comprobar si existe la entidad
        if(!medioPagoRepository.existsById(id)){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        return medioPagoService.getMedioPago(id);
    }

    @GetMapping("/get-all")
    public List<MedioPago> getAllMedioPago(){
        return medioPagoService.getAllMedioPago();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMedioPago(@PathVariable Integer id ){

        //comprobar si existe la entidad
        if(!medioPagoRepository.existsById(id)){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        medioPagoService.deleteMedioPago(id);
        return "MedioPago eliminado";
    }

    @PutMapping("/edit")
    public MedioPago deleteMedioPago(@RequestBody MedioPago medioPago ){

        //comprobar si existe la entidad
        if(!medioPagoRepository.existsById(medioPago.getId())){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        //comprobar si se envian los datos necesarios
        if(medioPago.getMedioPago().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Datos faltantes");
        }

        medioPagoService.saveMedioPago(medioPago);
        return medioPago;
    }


}
