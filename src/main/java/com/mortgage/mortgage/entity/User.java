package com.mortgage.mortgage.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@ToString
@Entity
@Table(name = "user")

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long user_id;


    //@NaturalId
    private String name;


    private String email;


    private String password;


    // @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Role.class)
    private String role;


}