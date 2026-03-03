package com.boot_demo1.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GenericGenerator(name = "UUIDGenerator" , type = org.hibernate.id.UUIDGenerator.class)
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id" ,length = 500)
    private String id;

    private String name;
    private String address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}