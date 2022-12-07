package com.my.autoservice.service;

import com.my.autoservice.model.Favor;

public interface FavorService {
    Favor save(Favor favor);

    Favor getById(Long id);
}
