package com.jeje.Crud_Relasi.dtos;

import com.jeje.Crud_Relasi.models.Merchant;
import com.jeje.Crud_Relasi.models.Store;
import lombok.Data;
import java.util.List;

@Data
public class MerchantDTO {
        public long id;
        public String name;
        private List<Store> Stores;
}
