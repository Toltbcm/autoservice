package com.my.autoservice.service.impl;

import com.my.autoservice.dto.request.MasterCreateDto;
import com.my.autoservice.model.Master;
import com.my.autoservice.repository.MasterRepository;
import com.my.autoservice.service.MasterService;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    MasterRepository masterRepository;

    @Override
    public Master create(MasterCreateDto masterCreateDto) {
        Master master = new Master();
        master.setFirstName(masterCreateDto.getFirstName());
        master.setLastName(masterCreateDto.getLastName());
        master.setPatronymic(masterCreateDto.getPatronymic());
        master.setCompletedOrders(new ArrayList<>());
        return master;
    }

    @Override
    public Master save(Master master) {
        return masterRepository.save(master);
    }
}
