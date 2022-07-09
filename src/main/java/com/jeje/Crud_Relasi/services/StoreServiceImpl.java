package com.jeje.Crud_Relasi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeje.Crud_Relasi.dtos.StoreDTO;
import com.jeje.Crud_Relasi.models.Merchant;
import com.jeje.Crud_Relasi.models.Store;
import com.jeje.Crud_Relasi.repos.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    MerchantService merchantService;

    @Autowired
    StoreRepo storeRepo;

    @Override
    public Store addStore(Long merchantId, Store store) {
        final Merchant merchant = merchantService.findById(merchantId);
        if ( merchant != null){
           store = storeRepo.save(store);
          if (merchant.getStores() != null) {
            List<Store> stores = merchant.getStores();
            stores.add(store);

            merchant.setStores(stores);

          } else {
                merchant.setStores(Collections.singletonList(store));
          }

          merchantService.create(merchant);
          return store;
       }
          return null;
    }

    @Override
    public Store create(Store store) {
        final Store result = storeRepo.save(store);
        return result ;
    }

    @Override
    public Store update(Long id, Store store) {
        final Store result = findById(id);
        if (result != null){
            result.setName(store.getName());
            result.setAddress(store.getAddress());
            storeRepo.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Store result = findById(id);
        if (result != null) {
            storeRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Store findById(Long id) {
        Optional<Store> result = storeRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public List<Store> findAll() {
        return storeRepo.findAll();
    }

    @Override
    public StoreDTO mapToDto(Store store) {
        return objectMapper.convertValue(store, StoreDTO.class);
    }

    @Override
    public Store mapToEntity(StoreDTO storeDTO) {
        return objectMapper.convertValue(storeDTO, Store.class);
    }

    ObjectMapper objectMapper = new ObjectMapper();
}
