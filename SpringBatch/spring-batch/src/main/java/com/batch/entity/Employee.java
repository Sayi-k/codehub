package com.batch.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
}
