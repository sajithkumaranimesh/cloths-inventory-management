package com.pabaro.ims.controller;

import com.pabaro.ims.dto.Supplier;
import com.pabaro.ims.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public List<Supplier> retrieveAll() {
        return service.retrieve();
    }

    @GetMapping("/{id}")
    public Supplier retrieveById(@PathVariable Long id) {
        return service.retrieveById(id);
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
