package com.jeje.Crud_Relasi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeje.Crud_Relasi.dtos.MerchantDTO;
import com.jeje.Crud_Relasi.models.Merchant;
import com.jeje.Crud_Relasi.repos.MerchantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService{

    @Autowired
    MerchantRepo merchantRepo;

    @Override
    public Merchant create(Merchant merchant) {
       final Merchant result = merchantRepo.save(merchant);
        return result ;
    }

    @Override
    public Merchant update(Long id, Merchant merchant) {
        final Merchant result = findById(id);
        if (result != null){
            result.setName(merchant.getName());
            merchantRepo.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Merchant result = findById(id);
        if (result != null) {
            merchantRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Merchant> findAll() {
        return merchantRepo.findAll();
    }

    @Override
    public Merchant findById(Long id) {
        Optional<Merchant> result = merchantRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public MerchantDTO mapToDto(Merchant merchant) {

        return objectMapper.convertValue(merchant, MerchantDTO.class);
    }

    @Override
    public Merchant mapToEntity(MerchantDTO merchantDTO) {
        return objectMapper.convertValue(merchantDTO, Merchant.class);
    }

    ObjectMapper objectMapper = new ObjectMapper();



}
