package com.my.autoservice.service;

import com.my.autoservice.model.Part;

public interface PartService {
    Part save(Part part);

    Part getById(Long idd);
}
