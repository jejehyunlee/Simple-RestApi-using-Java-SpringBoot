package com.jeje.Crud_Relasi.controllers;

import com.jeje.Crud_Relasi.dtos.StoreDTO;
import com.jeje.Crud_Relasi.models.Store;
import com.jeje.Crud_Relasi.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/HomeStore")
public class StoreController {

    @Autowired
    StoreService storeService;

//    @PostMapping(value = "/AddStore/{merchantId}")

    @PostMapping(value = "/add/{merchantId}")
    public StoreDTO AddStoreToMerchant( @PathVariable Long merchantId, @RequestBody StoreDTO request){
        final Store store = storeService.mapToEntity(request);
        final Store result =storeService.addStore(merchantId, store);
        return storeService.mapToDto(result);
    }

    @PutMapping(value = "/update/{id}")
    public StoreDTO update(@PathVariable Long id, @RequestBody StoreDTO request){
        final  Store store = storeService.mapToEntity(request);
        final Store result = storeService.update(id, store);
        return storeService.mapToDto(result);
    }

    @GetMapping(value = "/all")
    public List<StoreDTO> findAll()
    {
        return storeService.findAll().stream().map(store -> storeService.mapToDto(store))
                .collect(Collectors.toList());
    }


    @GetMapping(value = "/CariId/{id}")
    public Store findById(@PathVariable Long id)
    {
        return storeService.findById(id);

    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete( @PathVariable Long id){
        return storeService.delete(id);

    }


}
