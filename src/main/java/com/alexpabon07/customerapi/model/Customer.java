package com.alexpabon07.customerapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customer")
public class Customer {

    @Id
    private int id;
    private String document;
    private String name;
    private String lastName;
    private String email;
}
