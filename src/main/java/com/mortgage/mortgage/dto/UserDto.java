package com.mortgage.mortgage.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long user_id;
    private String name;
    private String email;
    private String password;
    private String role;


}
