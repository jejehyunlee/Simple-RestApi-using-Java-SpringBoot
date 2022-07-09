package com.jeje.Crud_Relasi.controllers;


import com.jeje.Crud_Relasi.dtos.MerchantDTO;
import com.jeje.Crud_Relasi.models.Merchant;
import com.jeje.Crud_Relasi.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/HomeMerchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping(value = "/create")
    public MerchantDTO create(@RequestBody MerchantDTO request){
        final Merchant merchant = merchantService.mapToEntity(request);
        final Merchant result =merchantService.create(merchant);
        return merchantService.mapToDto(result);
    }

    @PutMapping(value = "/update/{id}")
    public MerchantDTO update(@PathVariable Long id, @RequestBody MerchantDTO request){
        final  Merchant merchant = merchantService.mapToEntity(request);
        final Merchant result = merchantService.update(id, merchant);
        return merchantService.mapToDto(result);
    }


    @GetMapping(value = "/all")
    public List<MerchantDTO> findAll()
    {
        return merchantService.findAll().stream().map(merchant -> merchantService.mapToDto(merchant))
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete( @PathVariable Long id){
        return merchantService.delete(id);

    }

}
