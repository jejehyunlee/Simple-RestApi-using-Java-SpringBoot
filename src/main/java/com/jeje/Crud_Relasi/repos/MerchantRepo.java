package com.jeje.Crud_Relasi.repos;

import com.jeje.Crud_Relasi.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepo extends JpaRepository<Merchant, Long> {
//    void delete(Long id);

}
