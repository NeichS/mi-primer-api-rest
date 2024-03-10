package com.api.test.primer_api.model.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ToString
@Builder
@Getter
public class UsersDto implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private String email;
}
