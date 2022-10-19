package com.springsecurity.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_tb")
public class Client_1 {

    @Id
    @GeneratedValue
    private Integer clientId;
    private String clientUsername;
    private String clientPassword;
    private Boolean clientActive;
    private String clientRoles;

}
