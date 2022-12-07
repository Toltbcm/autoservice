package com.my.autoservice.service;

import com.my.autoservice.model.Favor;

public interface FavorService {
    Favor create(Favor favor);

    Favor save(Favor favor);

    Favor getById(Long id);

}
