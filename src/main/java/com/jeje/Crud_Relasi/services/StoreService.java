package com.jeje.Crud_Relasi.services;

import com.jeje.Crud_Relasi.dtos.StoreDTO;
import com.jeje.Crud_Relasi.models.Store;
import java.util.List;

public interface StoreService {
    Store addStore(Long merchantId, Store store);
    Store create(Store store);
    Store update( Long id, Store store);
    Boolean delete(Long id);
    Store findById(Long id);
    List<Store> findAll();
    StoreDTO mapToDto(Store store);
    Store mapToEntity(StoreDTO storeDTO);

}
