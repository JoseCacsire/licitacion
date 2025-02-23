package com.apiRest.licitacion.controller;

import com.apiRest.licitacion.aggregates.request.LicitacionRequest;
import com.apiRest.licitacion.services.LicitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping
public class LicitacionController {

    private final LicitacionService licitacionService;

    @PostMapping("/licitacion")
    public ResponseEntity<String> registrarLicitacion(@RequestBody LicitacionRequest licitacionRequest){
        try {
            licitacionService.registrarLicitacion(licitacionRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Licitacion registrada exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar licitación: "
                    +e.getMessage());
        }
    }


}
