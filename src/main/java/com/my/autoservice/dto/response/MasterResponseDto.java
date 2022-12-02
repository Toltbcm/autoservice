package com.my.autoservice.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MasterResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private List<Long> orderIds;
}
