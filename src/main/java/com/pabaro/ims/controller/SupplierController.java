package com.pabaro.ims.controller;

import com.pabaro.ims.dto.SuccessResponse;
import com.pabaro.ims.dto.Supplier;
import com.pabaro.ims.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void persist(@RequestBody Supplier supplier) {
        service.persist(supplier);
    }

    @GetMapping()
    public ResponseEntity<SuccessResponse> retrieveAll() {
        List<Supplier> retrievList = service.retrieve();
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(retrievList)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> retrieveById(@PathVariable Long id) {
        Supplier supplier = service.retrieveById(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(supplier)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @PutMapping()
    public void update(@RequestBody Supplier supplier) {
        service.update(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
