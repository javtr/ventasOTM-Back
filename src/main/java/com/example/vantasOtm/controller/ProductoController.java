package com.example.vantasOtm.controller;

import com.example.vantasOtm.exception.RequestException;
import com.example.vantasOtm.model.Cliente;
import com.example.vantasOtm.model.Producto;
import com.example.vantasOtm.repository.ClienteRepository;
import com.example.vantasOtm.repository.ProductoRepository;
import com.example.vantasOtm.service.ClienteService;
import com.example.vantasOtm.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;


    @PostMapping("/save")
        public ResponseEntity<Producto> add(@RequestBody Producto producto){
        ResponseEntity<Producto> response;

        System.out.println(producto);

        //comprobar si se envian los datos necesarios
        if(producto.getNombre().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"nombre faltante");
        }else if(producto.getPrecio()==0){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"precio faltante");
        }else {
            response = ResponseEntity.ok(productoService.saveProducto(producto)) ;
        }

        return response;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Producto> getCliente(@PathVariable Integer id ){
        ResponseEntity<Producto> response;

        //comprobar si existe la entidad
        if(productoRepository.existsById(id)){
            response = ResponseEntity.ok(productoService.getProducto(id)) ;
        }else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        return response;
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Producto>> getAllCliente(){
        return ResponseEntity.ok(productoService.getAllProducto()) ;
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Integer id ){
        ResponseEntity<String> response;

        //comprobar si existe la entidad
        if(productoRepository.existsById(id)){
            productoService.deleteProducto(id);
        }
        else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        //comprobar si se elimino la entidad
        if(!productoRepository.existsById(id)){
            response = ResponseEntity.status(HttpStatus.OK).body("Entidad eliminada");
        }else{
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"La entidad no se elimino");
        }

        return response;
    }


    @PutMapping("/edit")
    public ResponseEntity<Producto> editTipoPago(@RequestBody Producto producto ){
        ResponseEntity<Producto> response;

        //comprobar si existe la entidad
        if(!productoRepository.existsById(producto.getId())){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        //comprobar si se envian los datos necesarios
        if(producto.getNombre().equals("")){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"nombre faltante");
        }else if(producto.getPrecio()==0){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"correo faltante");
        }

        return ResponseEntity.ok(productoService.saveProducto(producto)) ;
    }


    @GetMapping("/clientes/{id}")
    public ResponseEntity<Set<Cliente>> getProductoClientes(@PathVariable Integer id ){

        //comprobar si existe la entidad
        if(!productoRepository.existsById(id)){
            throw new RequestException("P-401", HttpStatus.BAD_REQUEST,"Entidad no existe");
        }

        return ResponseEntity.ok(productoService.getProducto(id).getClientesProducto()) ;
    }




}
