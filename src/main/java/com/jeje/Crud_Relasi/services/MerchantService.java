package com.jeje.Crud_Relasi.services;

import com.jeje.Crud_Relasi.dtos.MerchantDTO;
import com.jeje.Crud_Relasi.models.Merchant;

import java.util.List;

public interface MerchantService {
    Merchant create(Merchant merchant);
    Merchant update( Long id, Merchant merchant);
    Boolean delete(Long id);
    List<Merchant> findAll();
    Merchant findById(Long id);

    MerchantDTO mapToDto(Merchant merchant);
    Merchant mapToEntity(MerchantDTO merchantDTO);

}
